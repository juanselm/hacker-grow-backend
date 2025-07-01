package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.dto.UsuarioRankingDTO;
import com.hackergrow.hackergrow.entities.Usuario;
import com.hackergrow.hackergrow.entities.ProgresoUsuario;
import com.hackergrow.hackergrow.enums.EstadoRetoEnum;
import com.hackergrow.hackergrow.repositories.UsuarioRepository;
import com.hackergrow.hackergrow.repositories.ProgresoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ProgresoUsuarioService {

    @Autowired
    private ProgresoUsuarioRepository progresoUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ProgresoUsuario guardarEstadoReto(ProgresoUsuario progresoUsuario) {
        return progresoUsuarioRepository.save(progresoUsuario);
    }

    public List<ProgresoUsuario> obtenerEstadoRetosPorUsuario(Long idUsuario) {
        return progresoUsuarioRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<UsuarioRankingDTO> obtenerRankingUsuariosPorRetos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioRankingDTO> ranking = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            List<ProgresoUsuario> completados = progresoUsuarioRepository.findByUsuarioIdUsuario(usuario.getIdUsuario())
                .stream()
                .filter(pu -> pu.getEstadoReto() == EstadoRetoEnum.completado && pu.getFechaFinalizacion() != null)
                .collect(Collectors.toList());
            int retosCompletados = completados.size();
            java.time.LocalDateTime fechaUltimaSolucion = completados.stream()
                .map(ProgresoUsuario::getFechaFinalizacion)
                .min(Comparator.naturalOrder())
                .orElse(null);
            if (retosCompletados > 0) {
                ranking.add(new UsuarioRankingDTO(
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getNombreDeUsuario(),
                    retosCompletados,
                    fechaUltimaSolucion
                ));
            }
        }
        ranking.sort(Comparator.comparingInt(UsuarioRankingDTO::getRetosCompletados).reversed()
            .thenComparing(UsuarioRankingDTO::getFechaUltimaSolucion));
        return ranking;
    }
}