package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.ProgresoUsuario;
import com.hackergrow.hackergrow.repositories.ProgresoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoUsuarioService {

    @Autowired
    private ProgresoUsuarioRepository progresoUsuarioRepository;

    public ProgresoUsuario guardarEstadoReto(ProgresoUsuario progresoUsuario) {
        return progresoUsuarioRepository.save(progresoUsuario);
    }

    public List<ProgresoUsuario> obtenerEstadoRetosPorUsuario(Long idUsuario) {
        return progresoUsuarioRepository.findByUsuarioIdUsuario(idUsuario);
    }
}