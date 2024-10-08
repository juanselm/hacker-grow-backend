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

    @Column(name = "ruta_solucion", length = 255, nullable = true)
    private String rutaSolucion;

    @Column(name = "url_recurso", length = 325, nullable = true)
    private String urlRecurso;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEnum estado;

    // Default constructor
    public Reto() {}

    // Parameterized constructor
    public Reto(String nombreReto, String descripcion, NivelDificultadEnum nivelDificultad, String rutaSolucion, String urlRecurso, EstadoEnum estado) {
        this.nombreReto = nombreReto;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
        this.rutaSolucion = rutaSolucion;
        this.urlRecurso = urlRecurso;
        this.estado = estado;
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

    public String getRutaSolucion() {
        return rutaSolucion;
    }

    public void setRutaSolucion(String rutaSolucion) {
        this.rutaSolucion = rutaSolucion;
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
}
