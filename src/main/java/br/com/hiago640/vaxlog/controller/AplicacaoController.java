package br.com.hiago640.vaxlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiago640.vaxlog.dto.AplicacaoRequest;
import br.com.hiago640.vaxlog.model.RegistroVacina;
import br.com.hiago640.vaxlog.repository.AplicacaoRepository;
import br.com.hiago640.vaxlog.service.AplicacaoService;

@RestController
@RequestMapping("/aplicacao")
public class AplicacaoController {

	@Autowired
	private AplicacaoRepository repository;
	
	@Autowired
	private AplicacaoService service;
	
	@GetMapping("/listar")
	public List<RegistroVacina> getAll() {
		System.out.println("entrou aqui");
		
		return repository.findAll();
	}
	
	@PostMapping("/criar")
	public AplicacaoRequest incluirVacina(@RequestBody AplicacaoRequest aplicacao) {
		service.salvar(aplicacao);
		
		return aplicacao;
	}
	
}
