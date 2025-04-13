package com.jcs.data_center_control.enums;

public enum Bastidor {

    _1(1, "Bastidor 1"),
    _2(2, "Bastidor 2"),
    _3(3, "Bastidor 3"),
    _4(4, "Bastidor 4"),
    _5(5, "Bastidor 5"),
    _6(6, "Bastidor 6"),
    _8(8, "Bastidor 8"),
    _9(9, "Bastidor 9"),
    _10(10, "Bastidor 10"),
    _11(11, "Bastidor 11"),
    _12(12, "Bastidor 12"),
    _13(13, "Bastidor 13"),
    _14(14, "Bastidor 14"),
    _15(15, "Bastidor 15"),
    _16(16, "Bastidor 16"),
    _17(17, "Bastidor 17"),
    _18(18, "Bastidor 18"),
    _19(19, "Bastidor 19"),
    _20(20, "Bastidor 20"),
    _5A(21, "Bastidor 5A"),
    _6A(22, "Bastidor 6A");

    private final Integer codigo;
    private final String descricao;

    private Bastidor(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Bastidor toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Bastidor x : Bastidor.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Bastidor inválido: " + cod);
    }
}
