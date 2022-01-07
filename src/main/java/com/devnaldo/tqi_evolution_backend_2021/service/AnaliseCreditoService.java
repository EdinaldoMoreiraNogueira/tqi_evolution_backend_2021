package com.devnaldo.tqi_evolution_backend_2021.service;

import com.devnaldo.tqi_evolution_backend_2021.exception.AnaliseCreditoNaoCadastradoException;
import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseCreditoModel;
import com.devnaldo.tqi_evolution_backend_2021.repository.AnaliseCreditoRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
@Data
@NoArgsConstructor
public class AnaliseCreditoService {

    private AnaliseCreditoRepository analiseCreditoRepository;

    @Autowired
    public AnaliseCreditoService(AnaliseCreditoRepository analiseCreditoRepository){
        this.analiseCreditoRepository = analiseCreditoRepository;
    }
    public List<AnaliseCreditoModel> listarAnalises(){
        return analiseCreditoRepository.findAll();
    }

    public AnaliseCreditoModel listarAnaliseCreditoPorID(Long id){

        Optional<AnaliseCreditoModel> findById = analiseCreditoRepository.findById(id);

        return findById.get();

    }

    public AnaliseCreditoModel solicitar(AnaliseCreditoModel analiseCredito) {


        return analiseCreditoRepository.save(analiseCredito);
    }

    public AnaliseCreditoModel atualizar(Long id, AnaliseCreditoModel analiseCredito) throws AnaliseCreditoNaoCadastradoException {

        analiseCreditoRepository.findById(id).orElseThrow(() -> new AnaliseCreditoNaoCadastradoException(id));
        analiseCredito.setId(id);
        return analiseCreditoRepository.save(analiseCredito);
    }

    
    public void deletar( Long id) throws AnaliseCreditoNaoCadastradoException{
        analiseCreditoRepository.deleteById(id);
    }

}

