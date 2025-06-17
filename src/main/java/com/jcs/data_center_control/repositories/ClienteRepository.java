package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    Optional<Cliente> findByCnpj(String cnpj);

    @Transactional
    void deleteByCnpj(String cnpj);
}