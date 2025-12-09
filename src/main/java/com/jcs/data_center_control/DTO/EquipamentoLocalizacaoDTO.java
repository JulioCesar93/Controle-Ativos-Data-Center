package com.jcs.data_center_control.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoLocalizacaoDTO {

    // Dados do Equipamento
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
    private String fornecedorGarantia;
    private String observacoes;

    private String dataAtivacao;
    private String dataInicioGarantia;
    private String dataFimGarantia;

    // Localização
    private Integer ordemLoc;
    private String dataCenter;
    private String local;
    private String sala;
    private Integer fila;
    private Integer bastidor;
    private Integer nivel;
    private String statusLocal;
}
