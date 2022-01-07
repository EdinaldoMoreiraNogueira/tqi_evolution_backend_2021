package com.devnaldo.tqi_evolution_backend_2021.repository;


import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseParcelasFinanciamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnaliseParcelasFinaciamentoRepository extends JpaRepository<AnaliseParcelasFinanciamentoModel,Long> {

    Optional<AnaliseParcelasFinanciamentoModel> findById(Long id);
}
