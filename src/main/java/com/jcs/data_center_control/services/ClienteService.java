package com.jcs.data_center_control.services;

import com.jcs.data_center_control.DTO.ClienteDTO;
import com.jcs.data_center_control.DTO.EquipamentoDTO;
import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.exceptions.ResourceNotFoundException;
import com.jcs.data_center_control.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // ================= CONVERSORES =================

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCnpj(cliente.getCnpj());

        // dto.setEquipamentos
        return dto;
    }

    // ========== POST (Salvar) ==========
    public void salvarCliente(Cliente cliente) {
        if (clienteRepository.findByCnpj(cliente.getCnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado");
        }
        if (clienteRepository.findByNome(cliente.getNome()).isPresent()) {
            throw new RuntimeException("Nome já cadastrado");
        }

        clienteRepository.saveAndFlush(cliente);
    }
    // ========== BUSCAS ========================================

    public ClienteDTO buscarClientePorNome(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente " + nome + " não encontrado"));
        return toDTO(cliente);
    }

    public ClienteDTO buscarClientePorCnpj(String cnpj) {
        Cliente cliente = clienteRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new ResourceNotFoundException("CNPJ não encontrado"));
        return toDTO(cliente);
    }

    public ClienteDTO buscarClientePorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado"));
        return toDTO(cliente);
    }



    // ========== DELETE ==========

    public void deletarClientePorCnpj(String cnpj){
        Cliente cliente = clienteRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("CNPJ não encontrado"));
        clienteRepository.deleteByCnpj(cliente.getCnpj());
    }

    public void deletarClientePorId(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("ID não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public void deletarClientePorNome(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));
        clienteRepository.deleteById(cliente.getId());
    }


    // ========== ATUALIZAR ==========

    public void atualizarClientePorId(Integer id, Cliente cliente){
        Cliente clienteEntity = clienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() :
                        clienteEntity.getCnpj())
                .nome(cliente.getNome() != null ? cliente.getNome() :
                        clienteEntity.getNome())
                .id(clienteEntity.getId())
                .build();

        clienteRepository.saveAndFlush(clienteAtualizado);
    }

    public void atualizarClientePorNome(String nome, Cliente cliente) {
        Cliente clienteEntity = clienteRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("ID de Cliente não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .id(clienteEntity.getId())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() : clienteEntity.getCnpj())
                .build();

        clienteRepository.saveAndFlush(clienteAtualizado);
    }

    public void atualizarClientePorCnpj(String cnpj, Cliente cliente) {
        Cliente clienteEntity = clienteRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Cliente com CNPJ não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .id(clienteEntity.getId())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() : clienteEntity.getCnpj())
                .build();

        clienteRepository.saveAndFlush(clienteAtualizado);
    }

}