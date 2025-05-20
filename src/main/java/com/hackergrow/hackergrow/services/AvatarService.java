package com.hackergrow.hackergrow.services;

import com.hackergrow.hackergrow.entities.Avatar;
import com.hackergrow.hackergrow.repositories.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarService {
    @Autowired
    private AvatarRepository avatarRepository;

    public List<Avatar> obtenerTodosLosAvatares() {
        return avatarRepository.findAll(); // Ensure the database contains avatar records
    }
}
