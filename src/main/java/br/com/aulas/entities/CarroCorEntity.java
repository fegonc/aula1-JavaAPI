package br.com.aulas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "carro_cor")
@Data
public class CarroCorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro_cor")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro", nullable = false)
    @JsonIgnore
    private CarroEntity carro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cor", nullable = false)
    private CorEntity cor;

}
