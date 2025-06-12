package com.esoft.teste_spring.models;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "tb_jutsu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jutsu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private int dificuldade;

    @ManyToMany(mappedBy = "jutsus")
    //@JsonManagedReference
    @JsonIgnoreProperties("jutsus")
    private List<Ninja> ninjas;
}

