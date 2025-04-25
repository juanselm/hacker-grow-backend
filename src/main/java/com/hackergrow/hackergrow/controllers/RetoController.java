package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.entities.Reto;
import com.hackergrow.hackergrow.services.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Reto>> listarRetosPorCategoria(@PathVariable String categoria) {
        List<Reto> retos = retoService.obtenerRetosPorCategoria(categoria);
        return ResponseEntity.ok(retos);
    }

    @GetMapping("/count-by-category")
    public ResponseEntity<Map<String, Long>> contarRetosPorCategoria() {
        Map<String, Long> conteoPorCategoria = retoService.contarRetosPorCategoria();
        return ResponseEntity.ok(conteoPorCategoria);
    }
}