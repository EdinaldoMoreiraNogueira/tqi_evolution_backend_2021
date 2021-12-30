package com.devnaldo.tqi_evolution_backend_2021.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Cliente {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        @Column(nullable = false, length = 50)
        private String nome;

        @Column(nullable = false, length = 250)
        private String email;

        @Column(nullable = false, length = 11)
        private String cpf;

        @Column(nullable = false, length = 11)
        private String rg;

        @Column(nullable = false, length = 50)
        private String rua;

        @Column(nullable = false, length = 20)
        private String bairro;

        @Column(nullable = false, length = 20)
        private String cidade;

        @Column(nullable = false, length = 20)
        private String numero;

        @Column(nullable = false, length = 20)
        private String cep;

        @Column(nullable = false, length = 50)
        private BigDecimal renda;

        @Column(nullable = false, length = 10)
        private String senha;
}
