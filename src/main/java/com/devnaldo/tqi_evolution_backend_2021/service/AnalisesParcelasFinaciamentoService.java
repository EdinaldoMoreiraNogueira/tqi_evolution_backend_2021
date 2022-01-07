package com.devnaldo.tqi_evolution_backend_2021.service;

import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseParcelasFinanciamentoModel;
import com.devnaldo.tqi_evolution_backend_2021.repository.AnaliseParcelasFinaciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalisesParcelasFinaciamentoService {


    AnaliseParcelasFinaciamentoRepository analiseParcelasFinaciamentoRepository;

    @Autowired
    public AnalisesParcelasFinaciamentoService (AnaliseParcelasFinaciamentoRepository analiseParcelasFinaciamentoRepository){
        this.analiseParcelasFinaciamentoRepository = analiseParcelasFinaciamentoRepository;
    }

    public List<AnaliseParcelasFinanciamentoModel> findAll(){
       return analiseParcelasFinaciamentoRepository.findAll();
    }

    public AnaliseParcelasFinanciamentoModel finById(Long id){
        Optional<AnaliseParcelasFinanciamentoModel> analiseParcelasFinanciamento = analiseParcelasFinaciamentoRepository.findById(id);
        return analiseParcelasFinanciamento.get();
    }
    public AnaliseParcelasFinanciamentoModel solicitar(AnaliseParcelasFinanciamentoModel analiseParcelasFinanciamento){
        return analiseParcelasFinaciamentoRepository.save(analiseParcelasFinanciamento);
    }

    public AnaliseParcelasFinanciamentoModel atualizar(Long id, AnaliseParcelasFinanciamentoModel apf){
        analiseParcelasFinaciamentoRepository.findById(id);
        return analiseParcelasFinaciamentoRepository.save(apf);
    }
    public void deletar(Long id){
        analiseParcelasFinaciamentoRepository.deleteById(id);

    }
}
