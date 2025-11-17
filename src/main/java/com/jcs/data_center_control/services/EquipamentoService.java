package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.exceptions.ResourceNotFoundException;
import com.jcs.data_center_control.repositories.ClienteRepository;
import com.jcs.data_center_control.repositories.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, ClienteRepository clienteRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    // ========== POST (Salvar) ==============================
    public void salvarEquipamento(Equipamento equipamento) {

        if (equipamentoRepository.findBySerialTag(equipamento.getSerialTag()).isPresent()) {
            throw new RuntimeException("Serial já cadastrado");
        }
        if (equipamentoRepository.findByHostname(equipamento.getHostname()).isPresent()) {
            throw new RuntimeException("Hostname já cadastrado");
        }

        // Se o JSON trouxe cliente
        if (equipamento.getCliente() != null) {
            Cliente cliente = null;

            // busca por ID
            if (equipamento.getCliente().getId() != null) {
                cliente = clienteRepository.findById(equipamento.getCliente().getId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Cliente não encontrado com ID " + equipamento.getCliente().getId()
                        ));
            }
            // Se não tiver ID, mas tiver nome, busca pelo nome
            else if (equipamento.getCliente().getNome() != null) {
                cliente = clienteRepository.findByNome(equipamento.getCliente().getNome())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Cliente não encontrado com nome " + equipamento.getCliente().getNome()
                        ));
            }

            // Cliente existente associa pelo ID
            if (cliente != null) {
                equipamento.setCliente(cliente);
                equipamento.setClienteNome(cliente.getNome()); // duplicação no banco
            } else {
                equipamento.setCliente(null);
                equipamento.setClienteNome(null);
            }
        } else {
            // Nenhum cliente informado / Equipamento sem cliente
            equipamento.setCliente(null);
            equipamento.setClienteNome(null);
        }

        equipamentoRepository.saveAndFlush(equipamento);
    }

    // ========== BUSCAS ========================================

    public Equipamento buscarEquipamentoPorId(Integer id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento com ID " + id + " não encontrado"));
    }

    public Equipamento buscarEquipamentoPorSerialTag(String serialTag) {
        return equipamentoRepository.findBySerialTag(serialTag)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento com SerialTag " + serialTag + " não encontrado"));
    }

    public Equipamento buscarEquipamentoPorHostname(String hostname) {
        return equipamentoRepository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Hostname não encontrado"));
    }

    // ========== DELETE ========================================

    @Transactional
    public void deletarEquipamentoPorId(Integer id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new RuntimeException("ID não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }

    @Transactional
    public void deletarEquipamentoPorSerialTag(String serialTag) {
        Equipamento equipamento = equipamentoRepository.findBySerialTag(serialTag)
                .orElseThrow(() -> new RuntimeException("SerialTag não encontrado"));
        equipamentoRepository.deleteBySerialTag(equipamento.getSerialTag());
    }

    @Transactional
    public void deletarEquipamentoPorHostname(String hostname) {
        Equipamento equipamento = equipamentoRepository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Hostname não encontrado"));
        equipamentoRepository.deleteByHostname(equipamento.getHostname());
    }

    // ========== ATUALIZAÇÕES ==========================

    public void atualizarEquipamentoPorId(Integer id, Equipamento equipamento) {
        Equipamento equipamentoEntity = equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        equipamentoEntity.setSerialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : equipamentoEntity.getSerialTag());
        equipamentoEntity.setHostname(equipamento.getHostname() != null ? equipamento.getHostname() : equipamentoEntity.getHostname());
        equipamentoEntity.setIpProducao(equipamento.getIpProducao() != null ? equipamento.getIpProducao() : equipamentoEntity.getIpProducao());
        equipamentoEntity.setIpIdrac(equipamento.getIpIdrac() != null ? equipamento.getIpIdrac() : equipamentoEntity.getIpIdrac());
        equipamentoEntity.setPatrimonio(equipamento.getPatrimonio() != null ? equipamento.getPatrimonio() : equipamentoEntity.getPatrimonio());
        equipamentoEntity.setProcessador(equipamento.getProcessador() != null ? equipamento.getProcessador() : equipamentoEntity.getProcessador());
        equipamentoEntity.setMemoria(equipamento.getMemoria() != null ? equipamento.getMemoria() : equipamentoEntity.getMemoria());
        equipamentoEntity.setHd(equipamento.getHd() != null ? equipamento.getHd() : equipamentoEntity.getHd());
        equipamentoEntity.setNucleos(equipamento.getNucleos() != null ? equipamento.getNucleos() : equipamentoEntity.getNucleos());
        equipamentoEntity.setTipoServico(equipamento.getTipoServico() != null ? equipamento.getTipoServico() : equipamentoEntity.getTipoServico());
        equipamentoEntity.setStatusEquipamento(equipamento.getStatusEquipamento() != null ? equipamento.getStatusEquipamento() : equipamentoEntity.getStatusEquipamento());
        equipamentoEntity.setDataAtivacao(equipamento.getDataAtivacao() != null ? equipamento.getDataAtivacao() : equipamentoEntity.getDataAtivacao());
        equipamentoEntity.setFornecedorGarantia(equipamento.getFornecedorGarantia() != null ? equipamento.getFornecedorGarantia() : equipamentoEntity.getFornecedorGarantia());
        equipamentoEntity.setDataInicioGarantia(equipamento.getDataInicioGarantia() != null ? equipamento.getDataInicioGarantia() : equipamentoEntity.getDataInicioGarantia());
        equipamentoEntity.setDataFimGarantia(equipamento.getDataFimGarantia() != null ? equipamento.getDataFimGarantia() : equipamentoEntity.getDataFimGarantia());
        equipamentoEntity.setObservacoes(equipamento.getObservacoes() != null ? equipamento.getObservacoes() : equipamentoEntity.getObservacoes());

        // Se o JSON trouxer cliente
        if (equipamento.getCliente() != null && equipamento.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(equipamento.getCliente().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
            equipamentoEntity.setCliente(cliente);
        }

        equipamentoRepository.saveAndFlush(equipamentoEntity);
    }

    public void atualizarEquipamentoPorSerialTag(String serialTag, Equipamento equipamento) {
        Equipamento equipamentoEntity = equipamentoRepository.findBySerialTag(serialTag)
                .orElseThrow(() -> new RuntimeException("Equipamento informado não encontrado"));

        equipamentoEntity.setSerialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : equipamentoEntity.getSerialTag());
        equipamentoEntity.setHostname(equipamento.getHostname() != null ? equipamento.getHostname() : equipamentoEntity.getHostname());
        equipamentoEntity.setIpProducao(equipamento.getIpProducao() != null ? equipamento.getIpProducao() : equipamentoEntity.getIpProducao());
        equipamentoEntity.setIpIdrac(equipamento.getIpIdrac() != null ? equipamento.getIpIdrac() : equipamentoEntity.getIpIdrac());
        equipamentoEntity.setPatrimonio(equipamento.getPatrimonio() != null ? equipamento.getPatrimonio() : equipamentoEntity.getPatrimonio());
        equipamentoEntity.setProcessador(equipamento.getProcessador() != null ? equipamento.getProcessador() : equipamentoEntity.getProcessador());
        equipamentoEntity.setMemoria(equipamento.getMemoria() != null ? equipamento.getMemoria() : equipamentoEntity.getMemoria());
        equipamentoEntity.setHd(equipamento.getHd() != null ? equipamento.getHd() : equipamentoEntity.getHd());
        equipamentoEntity.setNucleos(equipamento.getNucleos() != null ? equipamento.getNucleos() : equipamentoEntity.getNucleos());
        equipamentoEntity.setTipoServico(equipamento.getTipoServico() != null ? equipamento.getTipoServico() : equipamentoEntity.getTipoServico());
        equipamentoEntity.setStatusEquipamento(equipamento.getStatusEquipamento() != null ? equipamento.getStatusEquipamento() : equipamentoEntity.getStatusEquipamento());
        equipamentoEntity.setDataAtivacao(equipamento.getDataAtivacao() != null ? equipamento.getDataAtivacao() : equipamentoEntity.getDataAtivacao());
        equipamentoEntity.setFornecedorGarantia(equipamento.getFornecedorGarantia() != null ? equipamento.getFornecedorGarantia() : equipamentoEntity.getFornecedorGarantia());
        equipamentoEntity.setDataInicioGarantia(equipamento.getDataInicioGarantia() != null ? equipamento.getDataInicioGarantia() : equipamentoEntity.getDataInicioGarantia());
        equipamentoEntity.setDataFimGarantia(equipamento.getDataFimGarantia() != null ? equipamento.getDataFimGarantia() : equipamentoEntity.getDataFimGarantia());
        equipamentoEntity.setObservacoes(equipamento.getObservacoes() != null ? equipamento.getObservacoes() : equipamentoEntity.getObservacoes());

        equipamentoRepository.saveAndFlush(equipamentoEntity);
    }

    public void atualizarEquipamentoPorHostname(String hostname, Equipamento equipamento) {
        Equipamento entidade = equipamentoRepository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Equipamento com hostname informado não encontrado"));

        entidade.setSerialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : entidade.getSerialTag());
        entidade.setHostname(equipamento.getHostname() != null ? equipamento.getHostname() : entidade.getHostname());
        entidade.setIpProducao(equipamento.getIpProducao() != null ? equipamento.getIpProducao() : entidade.getIpProducao());
        entidade.setIpIdrac(equipamento.getIpIdrac() != null ? equipamento.getIpIdrac() : entidade.getIpIdrac());
        entidade.setPatrimonio(equipamento.getPatrimonio() != null ? equipamento.getPatrimonio() : entidade.getPatrimonio());
        entidade.setProcessador(equipamento.getProcessador() != null ? equipamento.getProcessador() : entidade.getProcessador());
        entidade.setMemoria(equipamento.getMemoria() != null ? equipamento.getMemoria() : entidade.getMemoria());
        entidade.setHd(equipamento.getHd() != null ? equipamento.getHd() : entidade.getHd());
        entidade.setNucleos(equipamento.getNucleos() != null ? equipamento.getNucleos() : entidade.getNucleos());
        entidade.setTipoServico(equipamento.getTipoServico() != null ? equipamento.getTipoServico() : entidade.getTipoServico());
        entidade.setStatusEquipamento(equipamento.getStatusEquipamento() != null ? equipamento.getStatusEquipamento() : entidade.getStatusEquipamento());
        entidade.setDataAtivacao(equipamento.getDataAtivacao() != null ? equipamento.getDataAtivacao() : entidade.getDataAtivacao());
        entidade.setFornecedorGarantia(equipamento.getFornecedorGarantia() != null ? equipamento.getFornecedorGarantia() : entidade.getFornecedorGarantia());
        entidade.setDataInicioGarantia(equipamento.getDataInicioGarantia() != null ? equipamento.getDataInicioGarantia() : entidade.getDataInicioGarantia());
        entidade.setDataFimGarantia(equipamento.getDataFimGarantia() != null ? equipamento.getDataFimGarantia() : entidade.getDataFimGarantia());
        entidade.setObservacoes(equipamento.getObservacoes() != null ? equipamento.getObservacoes() : entidade.getObservacoes());

        equipamentoRepository.saveAndFlush(entidade);
    }
}
