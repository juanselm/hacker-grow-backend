package com.hackergrow.hackergrow.entities;

import com.hackergrow.hackergrow.enums.TipoMensajeEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "mensaje_alerta")
public class MensajeAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensaje;

    @ManyToOne
    @JoinColumn(name = "id_reto", nullable = false)
    private Reto reto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mensaje", length = 20, nullable = false)
    private TipoMensajeEnum tipoMensaje;

    @Column(name = "contenido_mensaje", columnDefinition = "TEXT", nullable = false)
    private String contenidoMensaje;

    @Column(name = "condicion_desencadenante", length = 100, nullable = true)
    private String condicionDesencadenante;

    // Default constructor
    public MensajeAlerta() {}

    // Parameterized constructor
    public MensajeAlerta(Reto reto, TipoMensajeEnum tipoMensaje, String contenidoMensaje, String condicionDesencadenante) {
        this.reto = reto;
        this.tipoMensaje = tipoMensaje;
        this.contenidoMensaje = contenidoMensaje;
        this.condicionDesencadenante = condicionDesencadenante;
    }

    // Getters and Setters
    public Long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Reto getReto() {
        return reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }

    public TipoMensajeEnum getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensajeEnum tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public String getCondicionDesencadenante() {
        return condicionDesencadenante;
    }

    public void setCondicionDesencadenante(String condicionDesencadenante) {
        this.condicionDesencadenante = condicionDesencadenante;
    }
}