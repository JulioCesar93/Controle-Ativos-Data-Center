package com.jcs.data_center_control.enums;

public enum StatusEquipamento {

    ROLE_USER(0, "ROLE_USER"),
    ROLE_OPERATOR(1, "ROLE_OPERATOR"),
    ROLE_ADMIN(2, "ROLE_ADMIN"),
    EM_OPERACAO(3, "EM OPERAÇÃO"),
    IMPLANTACAO(4, "IMPLANTAÇÃO"),
    DESLIGADO(5, "DESLIGADO"),
    DESATIVADO(6, "DESATIVADO");

    private final Integer codigo;
    private final String descricao;

    private StatusEquipamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusEquipamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusEquipamento status : StatusEquipamento.values()) {
            if (cod.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status Equipamento inválido: " + cod);
    }
}

