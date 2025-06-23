package com.jcs.data_center_control.enums;

import lombok.Getter;

@Getter
public enum Fila {

    FILA_01(1, "Fila 01"),
    FILA_02(2, "Fila 02"),
    FILA_03(3, "Fila 03"),
    FILA_04(4, "Fila 04"),
    FILA_05(5, "Fila 05"),
    FILA_06(6, "Fila 06"),
    FILA_07(7, "Fila 07"),
    FILA_08(8, "Fila 08"),
    FILA_09(9, "Fila 09"),
    FILA_10(10, "Fila 10"),
    FILA_11(11, "Fila 11"),
    FILA_12(12, "Fila 12"),
    FILA_13(13, "Fila 13"),
    FILA_14(14, "Fila 14"),
    FILA_15(15, "Fila 15"),
    FILA_16(16, "Fila 16"),
    FILA_17(17, "Fila 17"),
    FILA_18(18, "Fila 18"),
    FILA_19(19, "Fila 19"),
    FILA_20(20, "Fila 20"),
    FILA_21(21, "Fila 21"),
    FILA_22(22, "Fila 22"),
    FILA_23(23, "Fila 23"),
    FILA_24(24, "Fila 24");

    private final Integer codigo;
    private final String descricao;

    private Fila(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Fila toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Fila x : Fila.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Fila inválida: " + cod);
    }
}
