package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
