package br.com.aulas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "carro")
@Data
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro", nullable = false, unique = true)
    private Long id;

    @Column(name = "nomecarro", nullable = false)
    private String nome;

    @Column(name = "anafabricacaocarro", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "anomodelocarro", nullable = false)
    private Integer anoModelo;

    @Column(name = "modelocarro", nullable = false)
    private String modelo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private MarcaEntity marca;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarroCorEntity> cores = new ArrayList<>();

}

