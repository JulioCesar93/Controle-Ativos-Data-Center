package com.jcs.data_center_control.services;

import com.jcs.data_center_control.entity.Cliente;
import com.jcs.data_center_control.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        repository.saveAndFlush(cliente);
    }

    public Cliente buscarClientePorCnpj(String cnpj){
        return repository.findByCnpj(cnpj).orElseThrow(
                () -> new RuntimeException("CNPJ não encontrado")
        );
    }

    public void deletarClientePorCnpj(String cnpj){
        repository.deleteByCnpj(cnpj);
    }

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
}