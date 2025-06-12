package com.esoft.teste_spring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_vila")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private int numeroHabitantes;

    @OneToMany(mappedBy = "vila")
    @JsonManagedReference
    private List<Ninja> ninjas;
}

