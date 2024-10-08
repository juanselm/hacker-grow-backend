package com.hackergrow.hackergrow.repositories;

import com.hackergrow.hackergrow.entities.MensajeAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeAlertaRepository extends JpaRepository<MensajeAlerta, Long> {
}