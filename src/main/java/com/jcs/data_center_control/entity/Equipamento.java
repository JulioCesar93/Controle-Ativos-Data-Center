package com.jcs.data_center_control.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
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

    //LOCALIZAÇÃO
    @OneToOne(mappedBy = "equipamento", fetch = FetchType.LAZY)
    private Localizacao localizacao;

    //CLIENTE -------------------------------------
    @Column(name = "cliente_nome")
    private String clienteNome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "hostname", nullable = false)
    private String hostname;

    @Column(name = "serialTag", unique = true, nullable = false)
    private String serialTag;

    @Column(name = "ip_producao", length = 50)
    private String ipProducao;

    @Column(name = "ip_idrac", length = 50)
    private String ipIdrac;

    @Column(length = 100)
    private String patrimonio;

    @Column(length = 100)
    private String processador;

    @Column(length = 100)
    private String memoria;

    @Column(length = 100)
    private String hd;
    private Integer nucleos;

    //@Enumerated(EnumType.STRING)
    @Column(name = "tipo_servico", length = 50)
    private String tipoServico;

    //@Enumerated(EnumType.STRING)
    @Column(name = "status_equipamento", length = 50)
    private String statusEquipamento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_ativacao")
    private Date dataAtivacao;

    @Column(name = "fornecedor_garantia", length = 100)
    private String fornecedorGarantia;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio_garantia")
    private LocalDate dataInicioGarantia;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim_garantia")
    private LocalDate dataFimGarantia;

    @Column(length = 500, name = "observacoes")
    private String observacoes;

}