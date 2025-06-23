package com.jcs.data_center_control.enums;

import lombok.Getter;

@Getter
public enum TipoServico {

    HOST_DEDICADO(0, "Host Dedicado"),
    COLOCATION(1, "Colocation"),
    HOST_DEDICADO_PARCERIA(2, "Host Dedicado Parceria"),
    FLEX(3, "Flex"),
    FLEX_CLOUD(4, "Flex Cloud"),
    VDC_VCLOUD(5, "VDC vCloud"),
    UNICLOUD(6, "UniCloud"),
    MULTI_CLOUD_ALUGUEL(7, "Multi Cloud Aluguel"),
    CLOUD_2_ELASTIC(8, "Cloud 2 Elastic"),
    CLOUD_VSAN(9, "Cloud VSAN"),
    CLOUD_VSAN_ALUGUEL(10, "Cloud VSAN Aluguel");

    private final Integer codigo;
    private final String descricao;

    private TipoServico(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoServico toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (TipoServico s : TipoServico.values()) {
            if (cod.equals(s.getCodigo())) {
                return s;
            }
        }

        throw new IllegalArgumentException("Serviço invalido: " + cod);
    }
}
