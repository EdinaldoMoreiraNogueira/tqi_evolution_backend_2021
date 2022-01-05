package com.devnaldo.tqi_evolution_backend_2021.service;

import com.devnaldo.tqi_evolution_backend_2021.exception.AnaliseCreditoNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseCredito;
import com.devnaldo.tqi_evolution_backend_2021.repository.AnaliseCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class AnaliseCreditoService {

    private AnaliseCreditoRepository analiseCreditoRepository;

    @Autowired
    public AnaliseCreditoService(AnaliseCreditoRepository analiseCreditoRepository){
        this.analiseCreditoRepository = analiseCreditoRepository;
    }
    public List<AnaliseCredito> listarAnalises(){
        return analiseCreditoRepository.findAll();
    }

    public AnaliseCredito listarAnaliseCreditoPorID(Long id){

        Optional<AnaliseCredito> findById = analiseCreditoRepository.findById(id);

        return findById.get();

    }

    public AnaliseCredito solicitar(@RequestBody AnaliseCredito analiseCredito) {

        return analiseCreditoRepository.save(analiseCredito);
    }

    public AnaliseCredito atualizar(@PathVariable Long id, @RequestBody AnaliseCredito analiseCredito) throws AnaliseCreditoNaoCadastradoException {

        analiseCreditoRepository.findById(id).orElseThrow(() -> new AnaliseCreditoNaoCadastradoException(id));
        analiseCredito.setId(id);
        return analiseCreditoRepository.save(analiseCredito);
    }

    
    public void deletar( Long id) throws AnaliseCreditoNaoCadastradoException{
        analiseCreditoRepository.deleteById(id);
    }

}

