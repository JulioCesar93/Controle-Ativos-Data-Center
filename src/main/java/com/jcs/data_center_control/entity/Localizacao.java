package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JoinColumn(name = "localizacao_id")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

