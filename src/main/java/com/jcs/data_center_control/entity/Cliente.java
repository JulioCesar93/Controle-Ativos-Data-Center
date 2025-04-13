package com.jcs.data_center_control.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Equipamento> equipamentos;
}
