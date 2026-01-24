package br.com.hiago640.vaxlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.repository.UsuarioRepository;
import br.com.hiago640.vaxlog.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/listar")
	public List<Usuario> getAll() {
		System.out.println("entrou aqui");

		return repository.findAll();
	}

	@PostMapping("/criar")
	public Usuario incluirVacina(@RequestBody Usuario usuario) {
		service.salvar(usuario);

		return usuario;
	}

}
