package com.jcs.data_center_control.enums;

public enum StatusLocal {

    VAZIO(0, "Vazio"),
    ADEQUACAO(1, "Adequação"),
    DISPONIVEL(2, "Disponível"),
    OCUPADO(3, "Ocupado"),
    RESERVADO(4, "Reservado"),
    STANDBY(5, "Standby");

    private final Integer codigo;
    private final String descricao;

    private StatusLocal(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusLocal toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusLocal status : StatusLocal.values()) {
            if (cod.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status Local inválido: " + cod);
    }
}
