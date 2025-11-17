package com.jcs.data_center_control.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jcs.data_center_control.DTO.EquipamentoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;

    @JsonManagedReference
    private List<EquipamentoDTO> equipamentos;

    public ClienteDTO() {
    }
}
