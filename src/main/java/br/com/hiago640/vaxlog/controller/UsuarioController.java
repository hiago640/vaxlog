package br.com.hiago640.vaxlog.controller;

import java.util.List;

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

import br.com.hiago640.vaxlog.dto.UserRequestDTO;
import br.com.hiago640.vaxlog.dto.UserResponseDTO;
import br.com.hiago640.vaxlog.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> getAll() {
		List<UserResponseDTO> usuarios = service.listarTodos();

		return ResponseEntity.ok(usuarios);
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
		UserResponseDTO response = service.salvar(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
		UserResponseDTO response = service.alterar(id, dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
		service.excluir(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
