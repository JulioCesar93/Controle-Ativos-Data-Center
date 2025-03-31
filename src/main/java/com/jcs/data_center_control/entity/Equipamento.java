package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.StatusEquipamento;
import com.jcs.data_center_control.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hostname;
    private String ipProducao;
    private String ipIdrac;
    private String serial;
    private String patrimonio;
    private String processador;
    private String memoria;
    private String hd;
    private Integer nucleos;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento statusEquipamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Localizacao localizacao;

    private Date dataAtivacao;
    private Date dataInicioGarantia;
    private Date dataFimGarantia;
}