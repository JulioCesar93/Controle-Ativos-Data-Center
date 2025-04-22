package com.jcs.data_center_control.entity;

import com.jcs.data_center_control.enums.StatusEquipamento;
import com.jcs.data_center_control.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_EQUIPAMENTO")
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false, unique = true)
    private String hostname;

    private String ipProducao;
    private String ipIdrac;
    private String serial;
    private String patrimonio;
    private String processador;
    private String memoria;
    private String hd;
    private Integer nucleos;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento statusEquipamento;

    private Date dataAtivacao;
    private Date dataInicioGarantia;
    private Date dataFimGarantia;

    private String Observacoes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpProducao() {
        return ipProducao;
    }

    public void setIpProducao(String ipProducao) {
        this.ipProducao = ipProducao;
    }

    public String getIpIdrac() {
        return ipIdrac;
    }

    public void setIpIdrac(String ipIdrac) {
        this.ipIdrac = ipIdrac;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public Integer getNucleos() {
        return nucleos;
    }

    public void setNucleos(Integer nucleos) {
        this.nucleos = nucleos;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public StatusEquipamento getStatusEquipamento() {
        return statusEquipamento;
    }

    public void setStatusEquipamento(StatusEquipamento statusEquipamento) {
        this.statusEquipamento = statusEquipamento;
    }

    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public Date getDataInicioGarantia() {
        return dataInicioGarantia;
    }

    public void setDataInicioGarantia(Date dataInicioGarantia) {
        this.dataInicioGarantia = dataInicioGarantia;
    }

    public Date getDataFimGarantia() {
        return dataFimGarantia;
    }

    public void setDataFimGarantia(Date dataFimGarantia) {
        this.dataFimGarantia = dataFimGarantia;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }
}

