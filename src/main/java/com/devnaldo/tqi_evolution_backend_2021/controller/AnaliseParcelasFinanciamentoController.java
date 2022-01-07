package com.devnaldo.tqi_evolution_backend_2021.controller;

import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseParcelasFinanciamentoModel;
import com.devnaldo.tqi_evolution_backend_2021.service.AnalisesParcelasFinaciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcelas")
public class AnaliseParcelasFinanciamentoController {

    private AnalisesParcelasFinaciamentoService analisesParcelasFinaciamentoService;

    @Autowired
    public AnaliseParcelasFinanciamentoController(AnalisesParcelasFinaciamentoService analisesParcelasFinaciamentoService){
        this.analisesParcelasFinaciamentoService = analisesParcelasFinaciamentoService;
    }

    @GetMapping
    public List<AnaliseParcelasFinanciamentoModel> listarTodas(){
        return  analisesParcelasFinaciamentoService.findAll();
 }
    @GetMapping("/{id}")
    public List<AnaliseParcelasFinanciamentoModel> listarPorID(@PathVariable Long id){
        return(List<AnaliseParcelasFinanciamentoModel>) analisesParcelasFinaciamentoService.finById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnaliseParcelasFinanciamentoModel solicitar(@RequestBody AnaliseParcelasFinanciamentoModel analiseParcelasFinanciamento ){
        return analisesParcelasFinaciamentoService.solicitar(analiseParcelasFinanciamento);
    }

    @PutMapping("/{id}")
    public AnaliseParcelasFinanciamentoModel atualizar(@PathVariable Long id, AnaliseParcelasFinanciamentoModel analiseParcelasFinanciamento){
        return analisesParcelasFinaciamentoService.atualizar(id, analiseParcelasFinanciamento);
    }

    public void deletar(@PathVariable Long id){
        analisesParcelasFinaciamentoService.deletar(id);
    }


}

