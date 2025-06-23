package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.repositories.EquipamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public void salvarEquipamento(Equipamento equipamento){
        repository.saveAndFlush(equipamento);
    }

    public Equipamento buscarEquipamentoPorSerial(String serial){
        return repository.findBySerial(serial).orElseThrow(
                () -> new RuntimeException("Equipamento não encontrado")
        );
    }

    public void deletarEquipamentoPorSerial(String serial) {
        repository.deleteBySerial(serial);
    }

    public void deletarEquipamentoPorId(Integer id) {
        Equipamento equipamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + id));
        repository.delete(equipamento);
    }

    public void deletarEquipamentoPorObjeto(Equipamento equipamento) {
        if (equipamento.getId() != null) {
            deletarEquipamentoPorId(equipamento.getId());
        } else if (equipamento.getSerial() != null) {
            deletarEquipamentoPorSerial(equipamento.getSerial());
        } else {
            throw new RuntimeException("É necessário informar 'id' ou 'serial' para exclusão.");
        }
    }


    public void atualizarEquipamentoPorId(Integer id, Equipamento equipamento){
        Equipamento equipamentoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Equipamento não encontrado"));

        Equipamento equipamentoAtualizado = Equipamento.builder()
                .serial(equipamento.getSerial() != null ? equipamento.getSerial() :
                        equipamentoEntity.getSerial())
                .hostname(equipamento.getHostname() != null ? equipamento.getHostname() :
                        equipamentoEntity.getHostname())
                .id(equipamentoEntity.getId())
                .build();

        repository.saveAndFlush(equipamentoAtualizado);
    }
}

