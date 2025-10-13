package br.com.aulas.services;

import br.com.aulas.entities.CarroCorEntity;
import br.com.aulas.entities.CarroEntity;
import br.com.aulas.entities.CorEntity;
import br.com.aulas.repositories.CarroRepository;
import br.com.aulas.repositories.CorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    private CorRepository corRepository;

    @PersistenceContext
    private EntityManager em;

    public List<CarroEntity> buscarTodosCarros(){
        return carroRepository.findAll();
    }

    @Transactional
    public void salvarOuAlterarCarro(CarroEntity carro){
        for (CarroCorEntity carroCor : carro.getCores()) {
            carroCor.setCarro(carro);

            // Garantir que o objeto CorEntity existe no banco (busca pelo id)
            if (carroCor.getCor() != null && carroCor.getCor().getId() != null) {
                CorEntity cor = corRepository.findById(carroCor.getCor().getId())
                        .orElseThrow(() -> new RuntimeException("Cor não encontrada"));
                carroCor.setCor(cor);
            }
        }

        carroRepository.save(carro); // Cascade.ALL salva tudo (carro + carro_cor)
    }


    public void apagarCarro(Long id){
        carroRepository.deleteById(id);
    }
}
