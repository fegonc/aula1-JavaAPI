package br.com.aulas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "carro")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cor", referencedColumnName = "idcor")
    private CorEntity idCor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    public CorEntity getIdCor() {
        return idCor;
    }

    public void setIdCor(CorEntity idCor) {
        this.idCor = idCor;
    }
}
