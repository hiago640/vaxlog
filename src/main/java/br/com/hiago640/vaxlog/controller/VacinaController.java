package br.com.hiago640.vaxlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiago640.vaxlog.dto.VacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.VacinaResponseDTO;
import br.com.hiago640.vaxlog.service.VacinaService;

@RestController
@RequestMapping("/vaccine")
public class VacinaController {
	
	@Autowired
	private VacinaService service;
	
	@GetMapping
	public ResponseEntity<List<VacinaResponseDTO>> getAll() {
		List<VacinaResponseDTO> vacinas = service.listarTodos();
		
		return ResponseEntity.ok(vacinas);
	}
	
	@PostMapping
	public ResponseEntity<VacinaResponseDTO> createVaccine(@RequestBody VacinaRequestDTO vacina) {
		VacinaResponseDTO response = service.salvar(vacina);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
