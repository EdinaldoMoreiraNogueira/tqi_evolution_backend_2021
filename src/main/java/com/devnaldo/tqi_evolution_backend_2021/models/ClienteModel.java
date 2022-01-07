package com.devnaldo.tqi_evolution_backend_2021.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteModel implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        @Column(nullable = false, length = 50)
        @NotNull(message = "Por favor, informe o nome")
        private String nome;

        @Column(nullable = false, length = 50, unique = true)
        @Email(message = "email deve ser válido")
        private String email;

        @Column(nullable = false, length = 11, unique = true)
        @Size(min = 11, message = "11 dígitos deve conter o CPF")
        private String cpf;

        @Column(nullable = false, length = 11)
        @Size(min = 11, message = "11 dígitos deve conter o RG")
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
