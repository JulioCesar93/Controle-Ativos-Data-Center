package com.jcs.data_center_control.DTO;

//import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalizacaoDTO {

    private Integer idLocalizacao;

    private Integer idEquipamento;

    //@NotBlank(message = "O campo dataCenter é obrigatório.")
    private String dataCenter;

    //@NotBlank(message = "O campo local é obrigatório.")
    private String local;

    private String sala;

    //@Min(value = 1, message = "Fila deve ser >= 1")
    private Integer fila;

    //@Min(value = 1, message = "Bastidor deve ser >= 1")
    private Integer bastidor;

    //@Min(value = 1, message = "Nível deve ser >= 1")
    private Integer nivel;

    private String statusLocal;
}
