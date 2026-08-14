package br.com.hiago640.vaxlog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiago640.vaxlog.dto.RegistroVacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.RegistroVacinaResponseDTO;
import br.com.hiago640.vaxlog.service.RegistroVacinaService;

@RestController
@RequestMapping("/vaccine-record")
public class RegistroVacinaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroVacinaController.class);

	@Autowired
	private RegistroVacinaService service;

	@GetMapping
	public ResponseEntity<List<RegistroVacinaResponseDTO>> listarTodos() {

		LOGGER.info("entrou em listar todos");
		List<RegistroVacinaResponseDTO> aplicacoes = service.listarTodos();
		return ResponseEntity.ok(aplicacoes);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<RegistroVacinaResponseDTO>> buscarAplicacoesPorUsuario(
			@PathVariable(name = "id") Long usuarioID) {
		List<RegistroVacinaResponseDTO> aplicacoes = service.listarPorUsuario(usuarioID);
		return ResponseEntity.ok(aplicacoes);
	}

	@PostMapping
	public ResponseEntity<RegistroVacinaResponseDTO> createVaccineRecord(
			@RequestBody RegistroVacinaRequestDTO aplicacao) {
		RegistroVacinaResponseDTO response = service.salvar(aplicacao);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RegistroVacinaResponseDTO> updateVaccineRecord(@PathVariable Long id,
			@RequestBody RegistroVacinaRequestDTO dto) {
		RegistroVacinaResponseDTO response = service.alterar(id, dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<RegistroVacinaResponseDTO> deleteVaccineRecord(@PathVariable Long id) {
		service.excluir(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
