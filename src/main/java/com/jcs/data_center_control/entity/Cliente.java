package com.jcs.data_center_control.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table (name = "TB_CLIENTE")
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
                
    private String cnpj;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Equipamento> equipamentos;

}
