package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

        private final ClienteService clienteService;

        @PostMapping
        public ResponseEntity<Void> salvarCliente(@RequestBody Cliente cliente) {
            clienteService.salvarCliente(cliente);
            return ResponseEntity.ok().build();
        }

        @GetMapping
        public ResponseEntity<Cliente> buscarClientePorCnpj(@RequestParam String cnpj) {
            return ResponseEntity.ok(clienteService.buscarClientePorCnpj(cnpj));
        }

        @DeleteMapping
        public ResponseEntity<Void> deletarClientePorEmail(@RequestParam String cnpj) {
            clienteService.deletarClientePorCnpj(cnpj);
            return ResponseEntity.ok().build();
        }

        @PutMapping
        public ResponseEntity<Void> atualizarClientePorId(@RequestParam Integer id,
                                                          @RequestBody Cliente cliente) {
            clienteService.atualizarClientePorId(id, cliente);
            return ResponseEntity.ok().build();
        }
    }