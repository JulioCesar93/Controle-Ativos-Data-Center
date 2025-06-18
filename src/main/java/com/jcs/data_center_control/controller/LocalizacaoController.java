package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.entity.Localizacao;
import com.jcs.data_center_control.entity.Localizacao;
import com.jcs.data_center_control.services.LocalizacaoService;
import com.jcs.data_center_control.services.LocalizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/localizacao")
@RequiredArgsConstructor
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    @PostMapping
    public ResponseEntity<Void> salvarLocalizacao(@RequestBody Localizacao localizacao) {
        localizacaoService.salvarLocalizacao(localizacao);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Localizacao> buscarLocalizacaoPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(localizacaoService.buscarLocalizacaoPorId(Long.valueOf(id)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarLocalizacaoPorId(@RequestParam Integer id) {
        localizacaoService.deletarLocalizacaoPorId(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarLocalizacaoPorId(@RequestParam Integer id,
                                                      @RequestBody Localizacao localizacao) {
        localizacaoService.atualizarLocalizacaoPorId(id, localizacao);
        return ResponseEntity.ok().build();
    }
}
