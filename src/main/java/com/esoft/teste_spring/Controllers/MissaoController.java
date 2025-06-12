package com.esoft.teste_spring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esoft.teste_spring.DTOs.MissaoDTO;
import com.esoft.teste_spring.Services.MissaoService;
import com.esoft.teste_spring.models.Missao;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    MissaoService missaoService;

    @GetMapping
    public List<Missao> listar() {
        return missaoService.listar();
    }

    @PostMapping
    public MissaoDTO criar(@RequestBody MissaoDTO entity) {
        return missaoService.salvar(entity);
    }

    @PutMapping("/{id}")
    public MissaoDTO editar(@PathVariable Long id, @RequestBody MissaoDTO entity) {
        missaoService.salvar(id, entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) throws Exception {
        missaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> retrieve(@PathVariable Long id) {
        MissaoDTO result = missaoService.buscarPorId(id);
        if (result == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
