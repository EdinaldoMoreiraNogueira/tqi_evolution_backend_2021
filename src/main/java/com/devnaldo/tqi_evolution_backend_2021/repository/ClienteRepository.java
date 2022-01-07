package com.devnaldo.tqi_evolution_backend_2021.repository;

import com.devnaldo.tqi_evolution_backend_2021.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Long>{
    Optional<ClienteModel> findById(Long id);



}
