package com.esoft.teste_spring.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.esoft.teste_spring.models.Jutsu;
import com.esoft.teste_spring.Services.JutsuService;
import com.esoft.teste_spring.DTOs.JutsuDTO;

@RestController
@RequestMapping("/jutsus")
public class JutsuController {

    private final JutsuService jutsuService;

    public JutsuController(JutsuService jutsuService) {
        this.jutsuService = jutsuService;
    }

    @GetMapping
    public List<Jutsu> listar() {
        return jutsuService.listar();
    }

    @PostMapping
    public Jutsu criar(@RequestBody JutsuDTO dto) {
        Jutsu jutsu = new Jutsu();
        jutsu.setNome(dto.nome());
        jutsu.setDescricao(dto.descricao());
        jutsu.setDificuldade(dto.dificuldade());
        return jutsuService.salvar(jutsu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jutsu> atualizar(@PathVariable Long id, @RequestBody JutsuDTO dto) {
        Jutsu atualizado = jutsuService.atualizar(id, dto);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        jutsuService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

