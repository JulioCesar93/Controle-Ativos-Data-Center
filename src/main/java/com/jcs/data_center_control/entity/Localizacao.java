package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOCALIZACAO")
public class Localizacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private DataCenter dataCenter;

    @Enumerated(EnumType.STRING)
    private LocalEquipamento local;

    @Enumerated(EnumType.STRING)
    private Sala sala;

    @Enumerated(EnumType.STRING)
    private Fila fila;

    @Enumerated(EnumType.STRING)
    private Bastidor bastidor;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Enumerated(EnumType.STRING)
    private StatusLocal statusLocal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public LocalEquipamento getLocal() {
        return local;
    }

    public void setLocal(LocalEquipamento local) {
        this.local = local;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Bastidor getBastidor() {
        return bastidor;
    }

    public void setBastidor(Bastidor bastidor) {
        this.bastidor = bastidor;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public StatusLocal getStatusLocal() {
        return statusLocal;
    }

    public void setStatusLocal(StatusLocal statusLocal) {
        this.statusLocal = statusLocal;
    }
}

