package com.devnaldo.tqi_evolution_backend_2021.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoCadastradoException extends Exception {

    public ClienteNaoCadastradoException(Long id){
        super("Cliente com id: " + id + " não encontrado!!");
    }
}
