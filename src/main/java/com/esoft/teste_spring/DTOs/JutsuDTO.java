package com.esoft.teste_spring.DTOs;

import java.util.List;

public record JutsuDTO(String nome, String descricao, int dificuldade, List<Long> ninjasId) {}

