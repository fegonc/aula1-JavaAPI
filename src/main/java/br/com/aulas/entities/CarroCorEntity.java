package br.com.aulas.entities;

import jakarta.persistence.*;

@Entity(name = "carro_cor")
public class CarroCorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro_cor")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro", nullable = false)
    private CarroEntity carro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cor", nullable = false)
    private CorEntity cor;


    public Long getId() { return id; }
    public CarroEntity getCarro() { return carro; }
    public void setCarro(CarroEntity carro) { this.carro = carro; }
    public CorEntity getCor() { return cor; }
    public void setCor(CorEntity cor) { this.cor = cor; }
}
