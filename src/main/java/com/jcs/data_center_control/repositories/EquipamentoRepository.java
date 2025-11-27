package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

    Optional<Equipamento> findByHostname(String hostname);

    Optional<Equipamento> findBySerialTag(String serialTag);

    void deleteByHostname(String hostname);

    void deleteBySerialTag(String serialTag);
}
