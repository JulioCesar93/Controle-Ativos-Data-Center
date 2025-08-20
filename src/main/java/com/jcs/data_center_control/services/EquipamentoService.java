package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.exceptions.ResourceNotFoundException;
import com.jcs.data_center_control.repositories.EquipamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    // ========== POST (Salvar) ==============================
    public void salvarEquipamento(Equipamento equipamento) {
        if (repository.findBySerialTag(equipamento.getSerialTag()).isPresent()) {
            throw new RuntimeException("Serial já cadastrado");
        }
        if (repository.findByHostname(equipamento.getHostname()).isPresent()) {
            throw new RuntimeException("Hostname já cadastrado");
        }
        repository.saveAndFlush(equipamento);
    }

    // ========== BUSCAS ========================================

    // GET ID
    public Equipamento buscarEquipamentoPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento com ID " + id + " não encontrado"));
    }

    // GET SerialTag
    public Equipamento buscarEquipamentoPorSerialTag(String serialTag) {
        return repository.findBySerialTag(serialTag)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + serialTag + " não encontrado"));
    }

    // GET hostname
    public Equipamento buscarEquipamentoPorHostname(String hostname) {
        return repository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Hostname não encontrado"));
    }

    // ========== DELETE ========================================

    public void deletarEquipamentoPorId(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ID não encontrado");
        }
        repository.deleteById(id);
    }

    public void deletarEquipamentoPorSerialTag(String serialTag) {
        Equipamento equipamento = repository.findBySerialTag(serialTag)
                .orElseThrow(() -> new RuntimeException("SerialTag não encontrado"));
        repository.deleteBySerialTag(equipamento.getSerialTag());
    }

    public void deletarEquipamentoPorHostname(String hostname) {
        Equipamento equipamento = repository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Hostname não encontrado"));
        repository.deleteByHostname(equipamento.getHostname());
    }

    // ========== ATUALIZAÇÕES ========================================

    // PUT - ID
    public void atualizarEquipamentoPorId(Integer id, Equipamento equipamento) {
        Equipamento entidade = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        Equipamento atualizado = Equipamento.builder()
                .id(entidade.getId())
                .serialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : entidade.getSerialTag())
                .hostname(equipamento.getHostname() != null ? equipamento.getHostname() : entidade.getHostname())
                .build();

        repository.saveAndFlush(atualizado);
    }

    // PUT - SerialTag
    public void atualizarEquipamentoPorSerialTag(String serialTag, Equipamento equipamento) {
        Equipamento entidade = repository.findBySerialTag(serialTag)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        Equipamento atualizado = Equipamento.builder()
                .id(entidade.getId())
                .serialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : entidade.getSerialTag())
                .hostname(equipamento.getHostname() != null ? equipamento.getHostname() : entidade.getHostname())
                .build();

        repository.saveAndFlush(atualizado);
    }

    // PUT - Hostname
    public void atualizarEquipamentoPorHostname(String hostname, Equipamento equipamento) {
        Equipamento entidade = repository.findByHostname(hostname)
                .orElseThrow(() -> new RuntimeException("Equipamento com hostname não encontrado"));

        Equipamento atualizado = Equipamento.builder()
                .id(entidade.getId())
                .serialTag(equipamento.getSerialTag() != null ? equipamento.getSerialTag() : entidade.getSerialTag())
                .hostname(equipamento.getHostname() != null ? equipamento.getHostname() : entidade.getHostname())
                .build();

        repository.saveAndFlush(atualizado);
    }
}
