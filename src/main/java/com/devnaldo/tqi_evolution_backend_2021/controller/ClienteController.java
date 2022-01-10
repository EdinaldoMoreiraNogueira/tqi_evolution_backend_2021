package com.devnaldo.tqi_evolution_backend_2021.controller;

import com.devnaldo.tqi_evolution_backend_2021.exception.ClienteNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.ClienteModel;
import com.devnaldo.tqi_evolution_backend_2021.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private ClienteService clienteService;


    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteModel> listaCliente(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteModel listarClientePorId(@PathVariable(value="id") Long id) throws ClienteNaoCadastradoException {
        return clienteService.listarClientePorId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel salvarCliente(@RequestBody ClienteModel cliente){
        return clienteService.salvar(cliente);

    }

    @PutMapping ("/{id}")
    public ClienteModel modificar (@PathVariable Long id, @RequestBody ClienteModel cliente) throws ClienteNaoCadastradoException {
        return clienteService.modificar(id,cliente);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Long id) throws ClienteNaoCadastradoException{
        clienteService.deletar(id);
    }
}
