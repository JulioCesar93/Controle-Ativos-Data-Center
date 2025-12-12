package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

    Optional<Equipamento> findByHostname(String hostname);

    Optional<Equipamento> findBySerialTag(String serialTag);

    void deleteByHostname(String hostname);

    void deleteBySerialTag(String serialTag);

    @Query("""
        SELECT e FROM Equipamento e
        WHERE e.hostname = :value OR e.serialTag = :value
    """)
    Optional<Equipamento> findByHostnameOrSerialTag(@Param("value") String value);
}
