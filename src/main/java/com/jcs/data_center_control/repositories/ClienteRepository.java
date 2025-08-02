package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {


    Optional<Cliente> findByNome(String nome);
    Optional<Cliente> findByCnpj(String cnpj);
    Optional<Cliente> findById(Integer id);

    @Transactional
    void deleteByCnpj(String cnpj);
}