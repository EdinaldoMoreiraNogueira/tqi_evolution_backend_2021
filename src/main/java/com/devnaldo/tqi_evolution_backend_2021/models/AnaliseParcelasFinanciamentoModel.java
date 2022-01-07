package com.devnaldo.tqi_evolution_backend_2021.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnaliseParcelasFinanciamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParcela;
    @Column(nullable = false)
    private Date dataVencimento;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "AnaliseCreditoID")
    private AnaliseCreditoModel analiseCredito;


}
