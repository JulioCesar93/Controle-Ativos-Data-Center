package com.jcs.data_center_control.controller;

import com.jcs.data_center_control.DTO.ClienteDTO;
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

    // ========== BUSCA ==========
    //BUSCA Cliente via cnpj
    @GetMapping(params = "cnpj")
    public ResponseEntity<ClienteDTO> buscarClientePorCnpj(@RequestParam String cnpj) {
        return ResponseEntity.ok(clienteService.buscarClientePorCnpj(cnpj));
    }

    //BUSCA Cliente via id
    @GetMapping(params = "id")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@RequestParam Integer id) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    //BUSCA Cliente via nome
    @GetMapping(params = "nome")
    public ResponseEntity<ClienteDTO> buscarClientePorNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.buscarClientePorNome(nome));
    }
    
    // ========== DELETE ==========
    //DELETE por cnpj
    @DeleteMapping(params = "cnpj")
    public ResponseEntity<Void> deletarClientePorCnpj(@RequestParam String cnpj) {
        clienteService.deletarClientePorCnpj(cnpj);
        return ResponseEntity.ok().build();
    }

    // DELETE por id
    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deletarClientePorId(@RequestParam Integer id) {
        clienteService.deletarClientePorId(id);
        return ResponseEntity.ok().build();
    }

    // DELETE por nome
    @DeleteMapping(params = "nome")
    public ResponseEntity<Void> deletarClientePorNome(@RequestParam String nome) {
        clienteService.deletarClientePorNome(nome);
        return ResponseEntity.ok().build();
    }

    // ========== ATUALIZAR ==========
    // PUT por NOME
    @PutMapping(params = "nome")
    public ResponseEntity<Void> atualizarClientePorNome(@RequestParam String nome,
                                                        @RequestBody Cliente cliente) {
        clienteService.atualizarClientePorNome(nome, cliente);
        return ResponseEntity.ok().build();
    }

    // PUT por ID
    @PutMapping(params = "id")
    public ResponseEntity<Void> atualizarClientePorId(@RequestParam Integer id,
                                                      @RequestBody Cliente cliente) {
        clienteService.atualizarClientePorId(id, cliente);
        return ResponseEntity.ok().build();
    }

    // PUT por CNPJ
    @PutMapping(params = "cnpj")
    public ResponseEntity<Void> atualizarClientePorCnpj(@RequestParam String cnpj,
                                                        @RequestBody Cliente cliente) {
        clienteService.atualizarClientePorCnpj(cnpj, cliente);
        return ResponseEntity.ok().build();
    }
}