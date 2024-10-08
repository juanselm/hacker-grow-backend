package com.hackergrow.hackergrow.repositories;

import com.hackergrow.hackergrow.entities.Reto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetoRepository extends JpaRepository<Reto, Long> {
}