package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.entities.Usuario;
import com.hackergrow.hackergrow.exceptions.UsuarioExistenteException;
import com.hackergrow.hackergrow.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/sign-in")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (UsuarioExistenteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioLogueado = usuarioService.loginUsuario(usuario.getCorreo(), usuario.getContrasena());
            return ResponseEntity.ok(usuarioLogueado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}