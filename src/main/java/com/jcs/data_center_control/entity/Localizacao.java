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

    }