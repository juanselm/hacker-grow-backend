package com.hackergrow.hackergrow.dto;

public class UsuarioRankingDTO {
    private Long idUsuario;
    private String nombre;
    private String nombreDeUsuario;
    private int retosCompletados;
    private java.time.LocalDateTime fechaUltimaSolucion;

    public UsuarioRankingDTO(Long idUsuario, String nombre, String nombreDeUsuario, int retosCompletados, java.time.LocalDateTime fechaUltimaSolucion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.retosCompletados = retosCompletados;
        this.fechaUltimaSolucion = fechaUltimaSolucion;
    }

    public Long getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getNombreDeUsuario() { return nombreDeUsuario; }
    public int getRetosCompletados() { return retosCompletados; }
    public java.time.LocalDateTime getFechaUltimaSolucion() { return fechaUltimaSolucion; }

    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNombreDeUsuario(String nombreDeUsuario) { this.nombreDeUsuario = nombreDeUsuario; }
    public void setRetosCompletados(int retosCompletados) { this.retosCompletados = retosCompletados; }
    public void setFechaUltimaSolucion(java.time.LocalDateTime fechaUltimaSolucion) { this.fechaUltimaSolucion = fechaUltimaSolucion; }
}
