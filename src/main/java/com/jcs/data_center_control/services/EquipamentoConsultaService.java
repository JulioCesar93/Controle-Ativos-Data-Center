package com.jcs.data_center_control.services;

import com.jcs.data_center_control.DTO.EquipamentoLocalizacaoDTO;
import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.mappers.EquipamentoLocalizacaoMapper;
import com.jcs.data_center_control.repositories.EquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoConsultaService {

    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoLocalizacaoMapper mapper;

    // Buscar equipamento com a localização completa
    public EquipamentoLocalizacaoDTO buscarPorOrdemLoc(Integer ordemLoc) {
        Equipamento equipamento = equipamentoRepository.findById(ordemLoc)
                .orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado."));

        return mapper.toDTO(equipamento);
    }

    // Listar todos com a localização
    public List<EquipamentoLocalizacaoDTO> listarTodos() {
        return equipamentoRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
