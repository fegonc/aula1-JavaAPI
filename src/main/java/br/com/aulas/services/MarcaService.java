package br.com.aulas.services;

import br.com.aulas.entities.CarroEntity;
import br.com.aulas.entities.MarcaEntity;
import br.com.aulas.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<MarcaEntity> buscarTodasMarcas(){
        return marcaRepository.findAll();
    }

    public void salvarOuAlterarMarca(MarcaEntity marca){
        marcaRepository.save(marca);
    }

    public void apagarMarca(Long id){
        marcaRepository.deleteById(id);
    }
}
