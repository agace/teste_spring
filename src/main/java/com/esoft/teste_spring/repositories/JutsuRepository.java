package com.esoft.teste_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esoft.teste_spring.models.Jutsu;

public interface JutsuRepository extends JpaRepository<Jutsu, Long> {}

