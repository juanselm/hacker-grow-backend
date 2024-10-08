package com.hackergrow.hackergrow.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.hackergrow.hackergrow.enums.EstadoRetoEnum;

@Entity
@Table(name = "progreso_usuarios")
public class ProgresoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_reto", nullable = false)
    private Reto reto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_reto", length = 20, nullable = false)
    private EstadoRetoEnum estadoReto;

    @Column(name = "fecha_inicio", nullable = true)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_finalizacion", nullable = true)
    private LocalDateTime fechaFinalizacion;

    @Column(name = "intentos", nullable = true)
    private Integer intentos;

    // Default constructor
    public ProgresoUsuario() {}

    // Parameterized constructor
    public ProgresoUsuario(Usuario usuario, Reto reto, EstadoRetoEnum estadoReto, LocalDateTime fechaInicio, LocalDateTime fechaFinalizacion, Integer intentos) {
        this.usuario = usuario;
        this.reto = reto;
        this.estadoReto = estadoReto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.intentos = intentos;
    }

    // Getters and Setters
    public Long getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Long idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reto getReto() {
        return reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }

    public EstadoRetoEnum getEstadoReto() {
        return estadoReto;
    }

    public void setEstadoReto(EstadoRetoEnum estadoReto) {
        this.estadoReto = estadoReto;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }
}