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

}