package com.jcs.data_center_control.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "TB_CLIENTE")
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Equipamento> equipamentos;

}
