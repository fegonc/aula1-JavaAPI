package br.com.aulas.controllers;

import br.com.aulas.entities.CarroEntity;
import br.com.aulas.entities.CorEntity;
import br.com.aulas.services.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cores")
public class CorController {

    @Autowired
    CorService corService;

    @GetMapping
    public List<CorEntity> recuperarTodasCores(){
        return corService.buscarTodasCores();
    }

    @PostMapping
    public ResponseEntity adicionarCor(@RequestBody CorEntity cor){
        if(cor.getId() == null){
            corService.salvarOuAlterarCor(cor);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity alterarCor(@RequestBody CorEntity cor){
        if(cor.getId() != null){
            corService.salvarOuAlterarCor(cor);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public void apagarCor(@PathVariable Long id){
        corService.apagarCor(id);
    }
}
