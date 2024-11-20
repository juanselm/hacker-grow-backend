package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.entities.Reto;
import com.hackergrow.hackergrow.services.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/retos")
public class RetoController {

    @Autowired
    private RetoService retoService;

    @GetMapping
    public ResponseEntity<List<Reto>> listarTodosLosRetos() {
        List<Reto> retos = retoService.obtenerTodosLosRetos();
        return ResponseEntity.ok(retos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reto> obtenerRetoPorId(@PathVariable Long id) {
        Optional<Reto> reto = retoService.obtenerRetoPorId(id);
        return reto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}