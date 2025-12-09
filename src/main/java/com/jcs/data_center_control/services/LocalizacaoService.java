package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.entity.Localizacao;
import com.jcs.data_center_control.repositories.EquipamentoRepository;
import com.jcs.data_center_control.repositories.LocalizacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public Localizacao criar(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Localizacao buscarPorOrdemLoc(Integer ordemLoc) {
        return localizacaoRepository.findByOrdemLoc(ordemLoc)
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada."));
    }

    public Localizacao buscarPorSerialTag(String serialTag) {

        Equipamento equipamento = equipamentoRepository.findBySerialTag(serialTag)
                .orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado pelo serialTag: " + serialTag));

        return localizacaoRepository.findByEquipamento(equipamento)
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada para este equipamento."));
    }


    public Localizacao atualizar(Integer ordemLoc, Localizacao newLocalizacao) {

        Localizacao existente = buscarPorOrdemLoc(ordemLoc);

        existente.setDataCenter(newLocalizacao.getDataCenter());
        existente.setLocal(newLocalizacao.getLocal());
        existente.setSala(newLocalizacao.getSala());
        existente.setFila(newLocalizacao.getFila());
        existente.setBastidor(newLocalizacao.getBastidor());
        existente.setNivel(newLocalizacao.getNivel());
        existente.setStatusLocal(newLocalizacao.getStatusLocal());

        return localizacaoRepository.save(existente);
    }

    public void remover(Integer ordemLoc) {
        localizacaoRepository.deleteById(ordemLoc);
    }

    public Localizacao alocarEquipamento(Integer ordemLoc, String serialTag) {

        Localizacao localizacao = buscarPorOrdemLoc(ordemLoc);

        Equipamento equipamento = equipamentoRepository.findBySerialTag(serialTag)
                .orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado."));

        localizacao.setEquipamento(equipamento);
        equipamento.setLocalizacao(localizacao);

        equipamentoRepository.save(equipamento);
        return localizacaoRepository.save(localizacao);
    }
}
