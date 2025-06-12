package com.esoft.teste_spring.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esoft.teste_spring.DTOs.NinjaDTO;
import com.esoft.teste_spring.models.Missao;
import com.esoft.teste_spring.models.Ninja;
import com.esoft.teste_spring.models.Vila;
import com.esoft.teste_spring.repositories.MissaoRepository;
import com.esoft.teste_spring.repositories.NinjaRepository;
import com.esoft.teste_spring.repositories.VilaRepository;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final MissaoRepository missaoRepository;
    private final VilaRepository vilaRepository;

    public NinjaService(NinjaRepository ninjaRepository, MissaoRepository missaoRepository, VilaRepository vilaRepository) {
        this.ninjaRepository = ninjaRepository;
        this.missaoRepository = missaoRepository;
        this.vilaRepository = vilaRepository;
    }

    public List<NinjaDTO> listar() {
        return ninjaRepository.findAll().stream().map(NinjaDTO::new).toList();
    }

    public NinjaDTO salvar(NinjaDTO ninjaDTO) throws Exception {

        Ninja ninjaEntity = new Ninja();
        ninjaEntity.setNome(ninjaDTO.nome());
        ninjaEntity.setIdade(ninjaDTO.idade());
        ninjaEntity.setCla(ninjaDTO.cla());

        if (ninjaDTO.missaoId() != null) {
            Missao missao = missaoRepository.findById(ninjaDTO.missaoId())
                .orElseThrow(() -> new Exception("Missão não encontrada"));
            ninjaEntity.setMissao(missao);
        }

        if (ninjaDTO.vilaId() != null) {
            Vila vila = vilaRepository.findById(ninjaDTO.vilaId())
                .orElseThrow(() -> new Exception("Vila não encontrada"));
            ninjaEntity.setVila(vila);
        } else {
            ninjaEntity.setVila(null);
        }

        Ninja salvo = ninjaRepository.save(ninjaEntity);
        return new NinjaDTO(salvo);
    }

    public NinjaDTO salvar(Long id, NinjaDTO ninjaDTO) throws Exception {

        Ninja ninjaEntity = ninjaRepository.findById(id)
            .orElseThrow(() -> new Exception("Ninja não encontrado"));

        ninjaEntity.setNome(ninjaDTO.nome());
        ninjaEntity.setIdade(ninjaDTO.idade());
        ninjaEntity.setCla(ninjaDTO.cla());

        if (ninjaDTO.missaoId() != null) {
            Missao missao = missaoRepository.findById(ninjaDTO.missaoId())
                .orElseThrow(() -> new Exception("Missão não encontrada"));
            ninjaEntity.setMissao(missao);
        } else {
            ninjaEntity.setMissao(null);
        }

        if (ninjaDTO.vilaId() != null) {
            Vila vila = vilaRepository.findById(ninjaDTO.vilaId())
                .orElseThrow(() -> new Exception("Vila não encontrada"));
            ninjaEntity.setVila(vila);
        } else {
            ninjaEntity.setVila(null);
        }

        Ninja salvo = ninjaRepository.save(ninjaEntity);
        return new NinjaDTO(salvo);
    }

    public NinjaDTO buscarPorId(Long id) {
        return new NinjaDTO(ninjaRepository.findById(id).orElse(null));
    }

    public void deletar(Long id) {
        ninjaRepository.deleteById(id);
    }
}

