package com.jcs.data_center_control.enums;

public enum LocalEquipamento {

    CLOROX_TELECOM(0, "Clorox Telecom"),
    SUBSOLO(1, "Subsolo"),
    TERREO(2, "Térreo");

    private final Integer codigo;
    private final String descricao;

    private LocalEquipamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static LocalEquipamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (LocalEquipamento local : LocalEquipamento.values()) {
            if (cod.equals(local.getCodigo())) {
                return local;
            }
        }

        throw new IllegalArgumentException("LocalEquipamento inválido: " + cod);
    }
}
