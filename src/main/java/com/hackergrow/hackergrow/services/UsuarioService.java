package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.Usuario;
import com.hackergrow.hackergrow.exceptions.UsuarioExistenteException;
import com.hackergrow.hackergrow.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        // Verificar si el correo ya existe
        Optional<Usuario> usuarioExistentePorCorreo = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (usuarioExistentePorCorreo.isPresent()) {
            throw new UsuarioExistenteException("El correo ya está registrado.");
        }

        // Verificar si el nombre de usuario ya existe
        Optional<Usuario> usuarioExistentePorNombreDeUsuario = usuarioRepository.findByNombreDeUsuario(usuario.getNombreDeUsuario());
        if (usuarioExistentePorNombreDeUsuario.isPresent()) {
            throw new UsuarioExistenteException("El nombre de usuario ya está registrado.");
        }

        usuario.setFechaRegistro(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }
}