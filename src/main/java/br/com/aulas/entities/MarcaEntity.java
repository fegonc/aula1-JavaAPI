package br.com.aulas.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "marca")
@Data
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarca", nullable = false, unique = true)
    private Long id;

    @Column(name = "nomemarca", nullable = false)
    private String nome;

}
