package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "TB_LOCALIZACAO")
public class Localizacao implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

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

}