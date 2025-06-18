package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Localizacao;
import com.jcs.data_center_control.entity.Localizacao;
import com.jcs.data_center_control.repositories.LocalizacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository repository;

    public LocalizacaoService(LocalizacaoRepository repository) {
        this.repository = repository;
    }

    public void salvarLocalizacao(Localizacao localizacao){
        repository.saveAndFlush(localizacao);
    }

    public Localizacao buscarLocalizacaoPorId(Long id){
        return repository.findById(Math.toIntExact(id)).orElseThrow(
                () -> new RuntimeException("Localizacao não encontrada")
        );
    }

    public void deletarLocalizacaoPorId(Long id){
        repository.deleteById(Math.toIntExact(id));
    }

    public void atualizarLocalizacaoPorId(Integer id, Localizacao localizacao){
        Localizacao localizacaoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Localizacao não encontrado"));

        Localizacao localizacaoAtualizada = Localizacao.builder()
                .id(localizacao.getId() != null ? localizacao.getId() :
                        localizacaoEntity.getId())
                .fila(localizacao.getFila() != null ? localizacao.getFila() :
                        localizacaoEntity.getFila())
                .bastidor(localizacao.getBastidor() != null ? localizacao.getBastidor() :
                        localizacaoEntity.getBastidor())
                .id(localizacaoEntity.getId())
                .build();

        repository.saveAndFlush(localizacaoAtualizada);
    }
}
