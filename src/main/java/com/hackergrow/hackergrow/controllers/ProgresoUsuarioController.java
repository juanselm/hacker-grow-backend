package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.dto.UsuarioRankingDTO;
import com.hackergrow.hackergrow.entities.ProgresoUsuario;
import com.hackergrow.hackergrow.services.ProgresoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso-usuarios")
public class ProgresoUsuarioController {

    @Autowired
    private ProgresoUsuarioService progresoUsuarioService;

    @PostMapping
    public ResponseEntity<ProgresoUsuario> guardarEstadoReto(@RequestBody ProgresoUsuario progresoUsuario) {
        ProgresoUsuario nuevoProgreso = progresoUsuarioService.guardarEstadoReto(progresoUsuario);
        return ResponseEntity.ok(nuevoProgreso);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ProgresoUsuario>> obtenerEstadoRetosPorUsuario(@PathVariable Long idUsuario) {
        List<ProgresoUsuario> progresoUsuarios = progresoUsuarioService.obtenerEstadoRetosPorUsuario(idUsuario);
        return ResponseEntity.ok(progresoUsuarios);
    }

    @GetMapping("/ranking-usuarios")
    public ResponseEntity<List<UsuarioRankingDTO>> rankingUsuariosPorRetos() {
        List<UsuarioRankingDTO> ranking = progresoUsuarioService.obtenerRankingUsuariosPorRetos();
        return ResponseEntity.ok(ranking);
    }
}