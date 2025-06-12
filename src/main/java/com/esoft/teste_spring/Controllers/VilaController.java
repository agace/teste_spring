package com.esoft.teste_spring.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.esoft.teste_spring.models.Vila;
import com.esoft.teste_spring.Services.VilaService;
import com.esoft.teste_spring.DTOs.VilaDTO;


@RestController
@RequestMapping("/vilas")
public class VilaController {

    private final VilaService vilaService;

    public VilaController(VilaService vilaService) {
        this.vilaService = vilaService;
    }

    @GetMapping
    public List<Vila> listar() {
        return vilaService.listar();
    }

		@PostMapping
		public Vila criar(@RequestBody VilaDTO dto) {
				Vila vila = new Vila();
				vila.setNome(dto.nome());
				vila.setNumeroHabitantes(dto.numeroHabitantes());
				return vilaService.salvar(vila);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Vila> atualizar(@PathVariable Long id, @RequestBody VilaDTO dto) {
				Optional<Vila> optionalVila = vilaService.buscarPorId(id);

				if (optionalVila.isEmpty()) {
						return ResponseEntity.notFound().build();
				}

				Vila vila = optionalVila.get();
				vila.setNome(dto.nome());
				vila.setNumeroHabitantes(dto.numeroHabitantes());

				Vila updatedVila = vilaService.salvar(vila);
				return ResponseEntity.ok(updatedVila);
		}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        vilaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

