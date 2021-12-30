package com.devnaldo.tqi_evolution_backend_2021.controller;

import com.devnaldo.tqi_evolution_backend_2021.exception.ClienteNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.Cliente;
import com.devnaldo.tqi_evolution_backend_2021.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listaCliente(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente listarClientePorId(@PathVariable(value="id") Integer id) throws ClienteNaoCadastradoException {
        return clienteService.listarClientePorId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);

    }

    @PutMapping ("/{id}")
    public Cliente modificar (@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNaoCadastradoException {
        return clienteService.modificar(id,cliente);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) throws ClienteNaoCadastradoException{
        clienteService.deletar(id);
    }
}
