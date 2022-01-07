package com.devnaldo.tqi_evolution_backend_2021.service;

import com.devnaldo.tqi_evolution_backend_2021.exception.ClienteNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.ClienteModel;
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

    public List<ClienteModel> listarClientes() {

        return clienteRepository.findAll();

    }

    public ClienteModel listarClientePorId(Long id) throws ClienteNaoCadastradoException {

        ClienteModel cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoCadastradoException(id));
        return cliente;
    }

    public ClienteModel salvar(ClienteModel cliente) {

        return clienteRepository.save(cliente);
    }

    public ClienteModel modificar(Long id, ClienteModel cliente) throws ClienteNaoCadastradoException {

        clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoCadastradoException(id));
        cliente.setId(id);

        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) throws ClienteNaoCadastradoException{
        clienteRepository.deleteById(id);
    }

}
