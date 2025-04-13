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
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "cliente_id")
    private String hostname;

    @ManyToOne
    private String ipProducao;

    @ManyToOne
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

    public Equipamento(Long id, String hostname, String ipProducao, String ipIdrac, String serial, String patrimonio, String processador, String memoria, String hd, Integer nucleos, TipoServico tipoServico, StatusEquipamento statusEquipamento, Cliente cliente, Localizacao localizacao) {
        this.id = id;
        this.hostname = hostname;
        this.ipProducao = ipProducao;
        this.ipIdrac = ipIdrac;
        this.serial = serial;
        this.patrimonio = patrimonio;
        this.processador = processador;
        this.memoria = memoria;
        this.hd = hd;
        this.nucleos = nucleos;
        this.tipoServico = tipoServico;
        this.statusEquipamento = statusEquipamento;
        this.cliente = cliente;
        this.localizacao = localizacao;
    }
}

