package com.hackergrow.hackergrow.entities;

import com.hackergrow.hackergrow.enums.EstadoEnum;
import com.hackergrow.hackergrow.enums.NivelDificultadEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "retos")
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReto;

    @Column(name = "nombre_reto", length = 100, nullable = false)
    private String nombreReto;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_dificultad", nullable = false)
    private NivelDificultadEnum nivelDificultad;

    @Column(name = "hash_solucion", length = 30, nullable = false)
    private String hashSolucion;

    @Column(name = "url_recurso", length = 325, nullable = true)
    private String urlRecurso;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEnum estado;

    @Column(name = "categoria", length = 100, nullable = false)
    private String categoria;

    // Default constructor
    public Reto() {}

    // Parameterized constructor
    public Reto(String nombreReto, String descripcion, NivelDificultadEnum nivelDificultad, String hashSolucion, String urlRecurso, EstadoEnum estado, String categoria) {
        this.nombreReto = nombreReto;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
        this.hashSolucion = hashSolucion;
        this.urlRecurso = urlRecurso;
        this.estado = estado;
        this.categoria = categoria;
    }

    // Getters and Setters
    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public String getNombreReto() {
        return nombreReto;
    }

    public void setNombreReto(String nombreReto) {
        this.nombreReto = nombreReto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NivelDificultadEnum getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(NivelDificultadEnum nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public String getHashSolucion() {
        return hashSolucion;
    }

    public void setHashSolucion(String hashSolucion) {
        this.hashSolucion = hashSolucion;
    }

    public String getUrlRecurso() {
        return urlRecurso;
    }

    public void setUrlRecurso(String urlRecurso) {
        this.urlRecurso = urlRecurso;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
