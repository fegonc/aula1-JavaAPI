package br.com.aulas.services;

import br.com.aulas.entities.CorEntity;
import br.com.aulas.repositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorService {

    @Autowired
    CorRepository corRepository;

    public List<CorEntity> buscarTodasCores(){
        return corRepository.findAll();
    }

    public void salvarOuAlterarCor(CorEntity cor){
        corRepository.save(cor);
    }

    public void apagarCor(Long id){
        corRepository.deleteById(id);
    }
}
