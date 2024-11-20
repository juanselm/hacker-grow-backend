package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.Reto;
import com.hackergrow.hackergrow.repositories.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetoService {

    @Autowired
    private RetoRepository retoRepository;

    public List<Reto> obtenerTodosLosRetos() {
        return retoRepository.findAll();
    }
}
