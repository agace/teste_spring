package com.esoft.teste_spring.DTOs;

import com.esoft.teste_spring.models.Ninja;

import java.util.List;
import java.util.stream.Collectors;

public record NinjaDTO(
    Long id,
    String nome,
    int idade,
    String cla,
    Long vilaId,
    List<Long> jutsuId,
    Long missaoId
) {

    public NinjaDTO(Ninja ninja) {
        this(
            ninja.getId(),
            ninja.getNome(),
            ninja.getIdade(),
            ninja.getCla(),
            ninja.getVila() != null ? ninja.getVila().getId() : null,
            ninja.getJutsus() != null ? ninja.getJutsus().stream().map(j -> j.getId()).collect(Collectors.toList()) : null,
            ninja.getMissao() != null ? ninja.getMissao().getId() : null
        );
    }
}

