package com.devnaldo.tqi_evolution_backend_2021.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnaliseCreditoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    @Max(value = 60, message = "A quantidade máxima de parcelas é 60 ")
    private Integer quantidadeParcelas;

    @Column(nullable = false)
    private Date dataPrimeiraParcela;

    @ManyToOne
    @JoinColumn(name = "clienteID")
    private ClienteModel cliente;

    @OneToMany
    @JoinColumn(name = "analiseParcelasFinaciamentoID")
    private List<AnaliseParcelasFinanciamentoModel> analiseParcelasFinanciamentos = new ArrayList<>();
}
