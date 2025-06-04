package com.jcs.data_center_control.repositories;

import com.jcs.data_center_control.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository <Equipamento, Integer> {

}
