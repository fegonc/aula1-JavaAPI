package br.com.aulas.controllers;

import br.com.aulas.entities.CarroEntity;
import br.com.aulas.entities.MarcaEntity;
import br.com.aulas.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marcas")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping
    public List<MarcaEntity> recuperarTodasMarcas(){
        return marcaService.buscarTodasMarcas();
    }

    @PostMapping
    public ResponseEntity adicionarMarca(@RequestBody MarcaEntity marca){
        if(marca.getId() == null){
            marcaService.salvarOuAlterarMarca(marca);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity alterarMarca(@RequestBody MarcaEntity marca){
        if(marca.getId() != null){
            marcaService.salvarOuAlterarMarca(marca);
            return ResponseEntity.status(200).build();
        }else {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public void apagarMarca(@PathVariable Long id) {
        marcaService.apagarMarca(id);
    }

}
