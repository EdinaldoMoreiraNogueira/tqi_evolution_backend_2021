package com.devnaldo.tqi_evolution_backend_2021.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnaliseCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer quantidadeParcelas;

    @Column(nullable = false)
    private String dataPrimeiraParcela;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}