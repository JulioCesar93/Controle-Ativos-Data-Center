package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.DTO.EquipamentoDTO;
import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.services.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipamento")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Void> salvarEquipamento(@RequestBody Equipamento equipamento) {
        equipamentoService.salvarEquipamento(equipamento);
        return ResponseEntity.ok().build();
    }

    // ========== BUSCA ==========

    //BUSCA id
    @GetMapping(params = "id")
    public ResponseEntity<Equipamento> buscarEquipamentoPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(equipamentoService.buscarEquipamentoPorId(id));
    }

    //BUSCA SerialTag
    @GetMapping(params = "serialTag")
    public ResponseEntity<Equipamento> buscarEquipamentoPorSerialTag(@RequestParam String serialTag) {
        return ResponseEntity.ok(equipamentoService.buscarEquipamentoPorSerialTag(serialTag));
    }

    //BUSCA hostname
    @GetMapping(params = "hostname")
    public ResponseEntity<Equipamento> buscarEquipamentoPorHostname(@RequestParam String hostname) {
        return ResponseEntity.ok(equipamentoService.buscarEquipamentoPorHostname(hostname));
    }

    // ========== DELETE ==============================

    // DELETE por id
    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deletarEquipamentoPorId(@RequestParam Integer id) {
        equipamentoService.deletarEquipamentoPorId(id);
        return ResponseEntity.ok().build();
    }

    // DELETE por SerialTag
    @DeleteMapping(params = "serialTag")
    public ResponseEntity<Void> deletarEquipamentoPorSerialTag(@RequestParam String serialTag) {
        equipamentoService.deletarEquipamentoPorSerialTag(serialTag);
        return ResponseEntity.ok().build();
    }

    // DELETE por hostname
    @DeleteMapping(params = "hostname")
    public ResponseEntity<Void> deletarEquipamentoPorHostname(@RequestParam String hostname) {
        equipamentoService.deletarEquipamentoPorHostname(hostname);
        return ResponseEntity.ok().build();
    }

    // ========== ATUALIZA ==============================

    @PutMapping(params = "id")
    public ResponseEntity<Void> atualizarEquipamentoPorId(@RequestParam Integer id,
                                                      @RequestBody Equipamento equipamento) {
        equipamentoService.atualizarEquipamentoPorId(id, equipamento);
        return ResponseEntity.ok().build();
    }

    @PutMapping(params = "serialTag")
    public ResponseEntity<Void> atualizarEquipamentoPorSerialTag(@RequestParam String serialTag,
                                                                 @RequestBody Equipamento equipamento) {
        equipamentoService.atualizarEquipamentoPorSerialTag(serialTag, equipamento);
        return ResponseEntity.ok().build();
    }

    @PutMapping(params = "hostname")
    public ResponseEntity<Void> atualizarEquipamentoPorHostname(@RequestParam String hostname,
                                                                @RequestBody Equipamento equipamento) {
        equipamentoService.atualizarEquipamentoPorHostname(hostname, equipamento);
        return ResponseEntity.ok().build();
    }
}
