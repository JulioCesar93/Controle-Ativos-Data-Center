package com.jcs.data_center_control.entity;

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
    @Column(name = "ordem_loc", length = 50)
    private String ordemLoc;

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

    public void setOrdemLoc(String ordemLoc) {
        this.ordemLoc = ordemLoc;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public void setStatusLocal(String statusLocal) {
        this.statusLocal = statusLocal;
    }
}