package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.StatusEquipamento;
import com.jcs.data_center_control.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@Table(name = "TB_EQUIPAMENTO")
public class Equipamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "localizacao_id")
    //private Localizacao localizacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false, unique = true)
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

    private Date dataAtivacao;
    private Date dataInicioGarantia;
    private Date dataFimGarantia;

    private String Observacoes;

}