package com.hackergrow.hackergrow.repositories;

import com.hackergrow.hackergrow.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
}

