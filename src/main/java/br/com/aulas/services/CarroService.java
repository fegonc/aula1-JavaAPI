package br.com.aulas.services;

import br.com.aulas.entities.CarroEntity;
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

    @PersistenceContext
    private EntityManager em;

    public List<CarroEntity> buscarTodosCarros(){
        return carroRepository.findAll();
    }

    @Transactional
    public void salvarOuAlterarCarro(CarroEntity carro){
        carroRepository.save(carro);

        if (carro.getIdCor() != null) {
            em.createNativeQuery("INSERT INTO aulas1.carro_cor (id_carro, id_cor) VALUES (:idCarro, :idCor)")
                    .setParameter("idCarro", carro.getId())
                    .setParameter("idCor", carro.getIdCor().getId())
                    .executeUpdate();
        }
    }

    public void apagarCarro(Long id){
        carroRepository.deleteById(id);
    }
}
