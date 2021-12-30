package com.devnaldo.tqi_evolution_backend_2021.service;

import com.devnaldo.tqi_evolution_backend_2021.exception.ClienteNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.Cliente;
import com.devnaldo.tqi_evolution_backend_2021.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;


    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {

        return clienteRepository.findAll();

    }

    public Cliente listarClientePorId(Integer id) throws ClienteNaoCadastradoException {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoCadastradoException(id));
        return cliente;
    }

    public Cliente salvar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    public Cliente modificar(Integer id, Cliente cliente) throws ClienteNaoCadastradoException {

        clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoCadastradoException(id));
        cliente.setId(id);

        return clienteRepository.save(cliente);
    }

    public void deletar(Integer id) throws ClienteNaoCadastradoException{
        clienteRepository.deleteById(id);
    }

}
