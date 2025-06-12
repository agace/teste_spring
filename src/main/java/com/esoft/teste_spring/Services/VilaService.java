package com.esoft.teste_spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esoft.teste_spring.models.Vila;
import com.esoft.teste_spring.repositories.VilaRepository;

@Service
public class VilaService {

    private final VilaRepository vilaRepository;

    public VilaService(VilaRepository vilaRepository) {
        this.vilaRepository = vilaRepository;
    }

    public List<Vila> listar() {
        return vilaRepository.findAll();
    }

    public Optional<Vila> buscarPorId(Long id) {
        return vilaRepository.findById(id);
    }

    public Vila salvar(Vila vila) {
        return vilaRepository.save(vila);
    }

    public void deletar(Long id) {
        vilaRepository.deleteById(id);
    }
}

