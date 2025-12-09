package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    Optional<Localizacao> findByOrdemLoc(Integer ordemLoc);
    Optional<Localizacao> findByEquipamento(Equipamento equipamento);

    // Identificador
    //Optional<Equipamento> findBySerialTag(String serialTag);
    //Optional<Equipamento> findByHostname(String hostname);



}