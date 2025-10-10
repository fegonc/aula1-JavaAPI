package br.com.aulas.controllers;


import br.com.aulas.Pessoa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("status")
public class StatusController {

    @GetMapping
    public String status(@RequestParam String nome){
        return "Bem vindo, " + nome + "!";
    }

    @PostMapping
    public String statusPost(@RequestBody Pessoa pessoa){
        return "Servidor Funcionando! Requisição POST Ola " + pessoa.getNome();
    }

    @PutMapping
    public String statusPut(@RequestBody Pessoa pessoa){
        return "Servidor Funcionando! Requisição PUT Ola " + pessoa.getNome();
    }

    @DeleteMapping("/{nome}")
    public String statusDelete(@PathVariable String nome){
        return "Usuario deletado, " + nome + "!";
    }
}
