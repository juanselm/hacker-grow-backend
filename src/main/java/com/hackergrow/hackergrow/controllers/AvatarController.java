package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.entities.Avatar;
import com.hackergrow.hackergrow.services.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/avatars")
    public ResponseEntity<List<Avatar>> listarAvatares() {
        System.out.println("Entrando a listarAvatares");
        List<Avatar> avatars = avatarService.obtenerTodosLosAvatares();
        System.out.println("Avatares obtenidos: " + avatars.size());
        if (avatars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(avatars);
    }

    @GetMapping("/avatars/{avatarId}")
    public ResponseEntity<Avatar> obtenerAvatarPorId(@PathVariable Long avatarId) {
        return avatarService.obtenerAvatarPorId(avatarId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{userId}/avatar/{avatarId}")
    public ResponseEntity<String> actualizarAvatarUsuario(
            @PathVariable Long userId,
            @PathVariable Long avatarId) {
        boolean actualizado = avatarService.actualizarAvatarDeUsuario(userId, avatarId);
        if (actualizado) {
            return ResponseEntity.ok("Avatar actualizado correctamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo actualizar el avatar.");
        }
    }
}
