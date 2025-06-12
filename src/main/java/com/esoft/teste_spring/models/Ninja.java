package com.esoft.teste_spring.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.esoft.teste_spring.DTOs.NinjaDTO;

import java.util.List;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ninja")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;
    private String cla;

    @ManyToOne
    @JoinColumn(name = "vila_id")
    @JsonBackReference
    private Vila vila;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JsonBackReference
    private Missao missao;

		@ManyToMany
		@JoinTable(
				name = "ninja_jutsus",
				joinColumns = @JoinColumn(name = "ninja_id"),
				inverseJoinColumns = @JoinColumn(name = "jutsu_id")
		)

    @JsonIgnoreProperties("ninjas")
    //@JsonBackReference
		private List<Jutsu> jutsus;

    public Ninja(NinjaDTO ninja) {
        this.id = ninja.id();
        this.nome = ninja.nome();
        this.idade = ninja.idade();
        this.cla = ninja.cla();
    }

}
