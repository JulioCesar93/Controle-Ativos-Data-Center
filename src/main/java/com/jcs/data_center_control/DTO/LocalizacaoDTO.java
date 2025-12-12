package com.jcs.data_center_control.DTO;

//import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalizacaoDTO {

    private Integer idLocalizacao;
    private Integer idEquipamento;
    private String dataCenter;
    private String local;
    private String sala;
    private Integer fila;
    private Integer bastidor;
    private Integer nivel;
    private String statusLocal;
}
