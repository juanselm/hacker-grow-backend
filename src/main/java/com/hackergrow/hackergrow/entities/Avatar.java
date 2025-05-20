package com.hackergrow.hackergrow.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "avatars")
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvatar;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "url_imagen", columnDefinition = "TEXT", nullable = false)
    private String urlImagen;

    // Getters and Setters
    public Long getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(Long idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
