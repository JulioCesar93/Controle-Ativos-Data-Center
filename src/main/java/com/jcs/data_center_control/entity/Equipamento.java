package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.StatusEquipamento;
import com.jcs.data_center_control.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_EQUIPAMENTO")
public class Equipamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "localizacao_id")
    //private Localizacao localizacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "hostname", nullable = false)
    private String hostname;

    @Column(name = "serialTag", unique = true, nullable = false)
    private String serialTag;

    private String ipProducao;
    private String ipIdrac;
    private String patrimonio;
    private String processador;
    private String memoria;
    private String hd;
    private Integer nucleos;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento statusEquipamento;

    @DateTimeFormat
    private Date dataAtivacao;

    private String forncedorGarantia;
    private Date dataInicioGarantia;
    private Date dataFimGarantia;

    private String Observacoes;

}