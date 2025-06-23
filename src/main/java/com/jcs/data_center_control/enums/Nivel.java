package com.jcs.data_center_control.enums;

import lombok.Getter;

@Getter
public enum Nivel {

    NIVEL_01(0, "Nível 01"),
    NIVEL_02(1, "Nível 02"),
    NIVEL_03(2, "Nível 03"),
    NIVEL_04(3, "Nível 04"),
    NIVEL_05(4, "Nível 05"),
    NIVEL_06(5, "Nível 06"),
    NIVEL_07(6, "Nível 07"),
    NIVEL_08(7, "Nível 08"),
    NIVEL_09(8, "Nível 09"),
    NIVEL_10(9, "Nível 10"),
    NIVEL_11(10, "Nível 11"),
    NIVEL_12(11, "Nível 12"),
    NIVEL_13(12, "Nível 13"),
    NIVEL_14(13, "Nível 14"),
    NIVEL_15(14, "Nível 15"),
    NIVEL_16(15, "Nível 16"),
    NIVEL_17(16, "Nível 17"),
    NIVEL_18(17, "Nível 18"),
    NIVEL_19(18, "Nível 19"),
    NIVEL_20(19, "Nível 20"),
    NIVEL_21(20, "Nível 21"),
    NIVEL_22(21, "Nível 22"),
    NIVEL_23(22, "Nível 23"),
    NIVEL_24(23, "Nível 24"),
    NIVEL_25(24, "Nível 25"),

    LAMINA(25, "Lâmina"),

    BANDEJA_01(26, "Bandeja 01"),
    BANDEJA_02(27, "Bandeja 02"),
    BANDEJA_03(28, "Bandeja 03"),
    BANDEJA_04(29, "Bandeja 04"),
    BANDEJA_05(30, "Bandeja 05"),
    BANDEJA_06(31, "Bandeja 06"),
    BANDEJA_07(32, "Bandeja 07"),
    BANDEJA_08(33, "Bandeja 08"),
    BANDEJA_09(34, "Bandeja 09"),
    BANDEJA_10(35, "Bandeja 10"),
    BANDEJA_11(36, "Bandeja 11"),
    BANDEJA_12(37, "Bandeja 12"),
    BANDEJA_13(38, "Bandeja 13"),
    BANDEJA_14(39, "Bandeja 14"),
    BANDEJA_15(40, "Bandeja 15"),
    BANDEJA_16(41, "Bandeja 16"),
    BANDEJA_17(42, "Bandeja 17"),
    BANDEJA_18(43, "Bandeja 18"),
    BANDEJA_19(44, "Bandeja 19"),
    BANDEJA_20(45, "Bandeja 20");

    private final Integer codigo;
    private final String descricao;

    private Nivel(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Nivel toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Nivel nivel : Nivel.values()) {
            if (cod.equals(nivel.getCodigo())) {
                return nivel;
            }
        }

        throw new IllegalArgumentException("Nível inválido: " + cod);
    }
}
