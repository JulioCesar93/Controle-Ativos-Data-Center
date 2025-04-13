package com.jcs.data_center_control.enums;

public enum DataCenter {

    DC_238(0, "DC 238"),
    PARQUE_DAS_ANTENAS(1, "Parque das Antenas"),
    ASCENTY(2, "Ascenty");

    private final Integer codigo;
    private final String descricao;

    private DataCenter(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static DataCenter toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (DataCenter x : DataCenter.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("DataCenter inválido: " + cod);
    }
}
