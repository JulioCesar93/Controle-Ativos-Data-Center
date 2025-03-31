package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.DataCenter;
import com.jcs.data_center_control.enums.Fila;
import com.jcs.data_center_control.enums.LocalEquipamento;
import com.jcs.data_center_control.enums.Sala;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

