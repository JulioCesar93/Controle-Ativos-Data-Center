package com.jcs.data_center_control.enums;

import lombok.Getter;

@Getter
public enum Sala {

    CENTRAL_TC(0, "Central TC"),
    CENTRAL_TI(1, "Central TI"),
    CLOROX(2, "Clorox"),
    SALA_SW_6A(3, "Sala SW 6A"),
    SALA_SW_6B(4, "Sala SW 6B"),
    NAO_APLICA(5, "Não se Aplica");

    private final Integer codigo;
    private final String descricao;

    private Sala(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Sala toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Sala sala : Sala.values()) {
            if (cod.equals(sala.getCodigo())) {
                return sala;
            }
        }

        throw new IllegalArgumentException("Sala inválida: " + cod);
    }
}

