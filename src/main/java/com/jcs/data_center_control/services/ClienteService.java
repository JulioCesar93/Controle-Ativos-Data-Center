package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.exceptions.ResourceNotFoundException;
import com.jcs.data_center_control.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // ========== POST (Salvar) ==========
    public void salvarCliente(Cliente cliente) {
        if (repository.findByCnpj(cliente.getCnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado");
        }
        if (repository.findByNome(cliente.getNome()).isPresent()) {
            throw new RuntimeException("Nome já cadastrado");
        }

        repository.saveAndFlush(cliente);
    }

    //BUSCA - CNPJ
    public Cliente buscarClientePorCnpj(String cnpj){
        return repository.findByCnpj(cnpj).orElseThrow(
                () -> new RuntimeException("CNPJ não encontrado")
        );
    }

    //BUSCA - ID
    public Cliente buscarClientePorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado"));
    }

    //BUSCA nome
    public Cliente buscarClientePorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Não encontrado")
        );
    }

    // ========== DELETE ==========

    public void deletarClientePorCnpj(String cnpj){
        repository.deleteByCnpj(cnpj);
    }

    public void deletarClientePorId(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ID não encontrado");
        }
        repository.deleteById(id);
    }

    public void deletarClientePorNome(String nome) {
        Cliente cliente = repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));
        repository.deleteById(cliente.getId());
    }


    // ========== ATUALIZAR ==========

    public void atualizarClientePorId(Integer id, Cliente cliente){
        Cliente clienteEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() :
                        clienteEntity.getCnpj())
                .nome(cliente.getNome() != null ? cliente.getNome() :
                        clienteEntity.getNome())
                .id(clienteEntity.getId())
                .build();

        repository.saveAndFlush(clienteAtualizado);
    }

    public void atualizarClientePorNome(String nome, Cliente cliente) {
        Cliente clienteEntity = repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Cliente com ID não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .id(clienteEntity.getId())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() : clienteEntity.getCnpj())
                .build();

        repository.saveAndFlush(clienteAtualizado);
    }

    public void atualizarClientePorCnpj(String cnpj, Cliente cliente) {
        Cliente clienteEntity = repository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Cliente com CNPJ não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .id(clienteEntity.getId())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .cnpj(cliente.getCnpj() != null ? cliente.getCnpj() : clienteEntity.getCnpj())
                .build();

        repository.saveAndFlush(clienteAtualizado);
    }

}