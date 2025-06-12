package com.esoft.teste_spring.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.esoft.teste_spring.models.Jutsu;
import com.esoft.teste_spring.models.Ninja;
import com.esoft.teste_spring.repositories.JutsuRepository;
import com.esoft.teste_spring.repositories.NinjaRepository;
import com.esoft.teste_spring.DTOs.JutsuDTO;

@Service
public class JutsuService {

    private final JutsuRepository jutsuRepository;
    private final NinjaRepository ninjaRepository;

    public JutsuService(JutsuRepository jutsuRepository, NinjaRepository ninjaRepository) {
        this.jutsuRepository = jutsuRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public List<Jutsu> listar() {
        return jutsuRepository.findAll();
    }

    public Optional<Jutsu> buscarPorId(Long id) {
        return jutsuRepository.findById(id);
    }

    public Jutsu salvar(Jutsu jutsu) {
        return jutsuRepository.save(jutsu);
    }

    public void deletar(Long id) {
        jutsuRepository.deleteById(id);
    }

    public Jutsu atualizar(Long id, JutsuDTO dto) {
        Optional<Jutsu> optionalJutsu = jutsuRepository.findById(id);

        if (optionalJutsu.isEmpty()) {
            throw new RuntimeException("Jutsu não encontrado com id: " + id);
        }

        Jutsu jutsu = optionalJutsu.get();
        jutsu.setNome(dto.nome());
        jutsu.setDescricao(dto.descricao());
        jutsu.setDificuldade(dto.dificuldade());

        List<Ninja> ninjas = ninjaRepository.findAllById(dto.ninjasId());

        jutsu.setNinjas(ninjas);

        for (Ninja ninja : ninjas) {
            if (!ninja.getJutsus().contains(jutsu)) {
                ninja.getJutsus().add(jutsu);
            }
        }

        return jutsuRepository.save(jutsu);
    }
}

