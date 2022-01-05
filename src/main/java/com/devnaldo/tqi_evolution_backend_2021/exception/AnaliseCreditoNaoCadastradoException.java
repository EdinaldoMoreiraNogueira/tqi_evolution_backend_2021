package com.devnaldo.tqi_evolution_backend_2021.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnaliseCreditoNaoCadastradoException extends Exception {

    public AnaliseCreditoNaoCadastradoException(Long id){
        super("Analise de crédito com o id: "  + id +  " nao localizado!!");
    }

}
