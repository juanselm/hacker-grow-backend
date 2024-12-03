package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.Reto;
import com.hackergrow.hackergrow.repositories.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetoService {

    @Autowired
    private RetoRepository retoRepository;

    public List<Reto> obtenerTodosLosRetos() {
        return retoRepository.findAll();
    }

    public Optional<Reto> obtenerRetoPorId(Long id) {
        return retoRepository.findById(id);
    }

    public List<Reto> obtenerRetosPorCategoria(String categoria) {
        return retoRepository.findByCategoria(categoria);
    }
}