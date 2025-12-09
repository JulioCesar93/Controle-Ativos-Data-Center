package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.DTO.EquipamentoLocalizacaoDTO;
import com.jcs.data_center_control.services.EquipamentoConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoConsultaController {

    private final EquipamentoConsultaService service;

    // Buscar um único equipamento
    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoLocalizacaoDTO> buscarPorOrdemLoc(@PathVariable Integer ordemLoc) {
        return ResponseEntity.ok(service.buscarPorOrdemLoc(ordemLoc));
    }

    // Listar todos os equipamentos com suas localizações
    @GetMapping
    public ResponseEntity<List<EquipamentoLocalizacaoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
