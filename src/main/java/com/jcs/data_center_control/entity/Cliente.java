package com.jcs.data_center_control.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = false)
    private String nome;

    private String cnpj;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY)
    //private List<Equipamento> equipamentos;
    private Set<Equipamento> equipamentos = new HashSet<>();


}
