package com.jcs.data_center_control.controller;

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

    @GetMapping
    public ResponseEntity<Equipamento> buscarEquipamentoPorSerial(@RequestParam String serial) {
        return ResponseEntity.ok(equipamentoService.buscarEquipamentoPorSerial(serial));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEquipamentoPorSerial(@RequestParam String serial) {
        equipamentoService.deletarEquipamentoPorSerial(serial);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEquipamentoPorId(@RequestParam Integer id,
                                                      @RequestBody Equipamento equipamento) {
        equipamentoService.atualizarEquipamentoPorId(id, equipamento);
        return ResponseEntity.ok().build();
    }
}
