package br.com.aulas.controllers;

import br.com.aulas.entities.CarroEntity;
import br.com.aulas.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarroController {

    @Autowired
    CarroService carroService;

    @GetMapping
    public List<CarroEntity> recuperarTodosCarros(){
        return carroService.buscarTodosCarros();
    }

    @PostMapping
    public ResponseEntity adicionarCarro(@RequestBody CarroEntity carro){
        try{
            if(carro.getId() == null){
                carroService.salvarOuAlterarCarro(carro);
                return ResponseEntity.status(200).build();
            }else {
                return ResponseEntity.status(500).build();
            }
        } catch (Exception ex){
            return ResponseEntity.status(500).build();

        }

    }

    @PutMapping
    public ResponseEntity alterarCarro(@RequestBody CarroEntity carro){
        try{
            if(carro.getId() != null){
                carroService.salvarOuAlterarCarro(carro);
                return ResponseEntity.status(200).build();
            }else {
                return ResponseEntity.status(500).build();
            }
        } catch (Exception ex){
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping("/{id}")
    public void apagarCarro(@PathVariable Long id){
        carroService.apagarCarro(id);
    }
}
