package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.entity.Localizacao;

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
    public ResponseEntity<Localizacao> criar(@RequestBody Localizacao localizacao) {
        return ResponseEntity.ok(localizacaoService.criar(localizacao));
    }

    @GetMapping("/{ordemLoc}")
    public ResponseEntity<Localizacao> buscarPorOrdemLoc(@PathVariable Integer ordemLoc) {
        return ResponseEntity.ok(localizacaoService.buscarPorOrdemLoc(ordemLoc));
    }

    @GetMapping("/equipamento/serial/{serialTag}")
    public ResponseEntity<Localizacao> buscarPorSerialTag(@PathVariable String serialTag) {
        return ResponseEntity.ok(localizacaoService.buscarPorSerialTag(serialTag));
    }

    @PutMapping("/{ordemLoc}")
    public ResponseEntity<Localizacao> atualizar(
            @PathVariable Integer ordemLoc,
            @RequestBody Localizacao localizacao) {

        return ResponseEntity.ok(localizacaoService.atualizar(ordemLoc, localizacao));
    }

    @DeleteMapping("/{ordemLoc}")
    public ResponseEntity<Void> remover(@PathVariable Integer ordemLoc) {
        localizacaoService.remover(ordemLoc);
        return ResponseEntity.noContent().build();
    }

    // Alocar equipamento por ordemLoc e serialTag
    @PutMapping("/{ordemLoc}/alocar/{serialTag}")
    public ResponseEntity<Localizacao> alocar(
            @PathVariable Integer ordemLoc,
            @PathVariable String serialTag) {

        return ResponseEntity.ok(localizacaoService.alocarEquipamento(ordemLoc, serialTag));
    }
}

