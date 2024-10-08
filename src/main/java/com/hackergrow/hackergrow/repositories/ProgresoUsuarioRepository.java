package com.hackergrow.hackergrow.repositories;

import com.hackergrow.hackergrow.entities.ProgresoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoUsuarioRepository extends JpaRepository<ProgresoUsuario, Long> {
}