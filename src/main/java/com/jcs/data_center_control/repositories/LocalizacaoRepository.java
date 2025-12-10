package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Equipamento;
import com.jcs.data_center_control.entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, String> {

    Optional<Localizacao> findByOrdemLoc(String ordemLoc);
    Optional<Localizacao> findByEquipamento(Equipamento equipamento);

}