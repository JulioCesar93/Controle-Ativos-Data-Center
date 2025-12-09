package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_LOCALIZACAO")
public class Localizacao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ordemLoc", unique = true, nullable = false)
    private Integer ordemLoc;

    //EQUIPAMENTO -------------------------------------
    @OneToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    //-------------------------
    @Column(name = "dataCenter")
    private String dataCenter;

    @Column(name = "local")
    private String local;

    @Column(name = "sala")
    private String sala;

    @Column(name = "fila")
    private Integer fila;

    @Column(name = "bastidor")
    private Integer bastidor;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "statusLocal")
    private String statusLocal;

    public Integer getOrdemLoc() {
        return ordemLoc;
    }

    public void setOrdemLoc(Integer ordemLoc) {
        this.ordemLoc = ordemLoc;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getStatusLocal() {
        return statusLocal;
    }

    public void setStatusLocal(String statusLocal) {
        this.statusLocal = statusLocal;
    }
}