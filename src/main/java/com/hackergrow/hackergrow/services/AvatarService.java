package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.Avatar;
import com.hackergrow.hackergrow.entities.Usuario;
import com.hackergrow.hackergrow.repositories.AvatarRepository;
import com.hackergrow.hackergrow.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvatarService {
    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Avatar> obtenerTodosLosAvatares() {
        return avatarRepository.findAll(); // Ensure the database contains avatar records
    }

    public boolean actualizarAvatarDeUsuario(Long userId, Long avatarId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);
        if (usuarioOpt.isPresent() && avatarRepository.existsById(avatarId)) {
            Usuario usuario = usuarioOpt.get();
            usuario.setIdAvatar(avatarId);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public Optional<Avatar> obtenerAvatarPorId(Long avatarId) {
        return avatarRepository.findById(avatarId);
    }
}
