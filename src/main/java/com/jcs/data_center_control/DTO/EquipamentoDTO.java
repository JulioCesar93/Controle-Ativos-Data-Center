package com.jcs.data_center_control.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jcs.data_center_control.entity.Equipamento;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EquipamentoDTO {

    private Integer id;
    private String clienteNome;
    private String hostname;
    private String serialTag;
    private String ipProducao;
    private String ipIdrac;
    private String patrimonio;
    private String processador;
    private String memoria;
    private String hd;
    private Integer nucleos;
    private String tipoServico;
    private String statusEquipamento;
    private Date dataAtivacao;
    private String fornecedorGarantia;
    private Date dataInicioGarantia;
    private Date dataFimGarantia;
    private String observacoes;

    @JsonBackReference
    private ClienteDTO cliente;

    @JsonBackReference
    private EquipamentoDTO equipamento;

    public EquipamentoDTO() {
    }
}
