package br.com.aulas.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "cor")
@Data
public class CorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcor", nullable = false, unique = true)
    private Long id;

    @Column(name = "nomecor", nullable = false)
    private String nome;
}
