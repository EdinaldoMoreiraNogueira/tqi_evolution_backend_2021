package com.devnaldo.tqi_evolution_backend_2021.repository;

import com.devnaldo.tqi_evolution_backend_2021.models.AnaliseCreditoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AnaliseCreditoRepository extends JpaRepository<AnaliseCreditoModel, Long> {


    Optional<AnaliseCreditoModel> findById(Long id);
}
