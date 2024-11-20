package com.hackergrow.hackergrow.controllers;

import com.hackergrow.hackergrow.entities.Reto;
import com.hackergrow.hackergrow.services.RetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
