package br.com.hiago640.vaxlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiago640.vaxlog.model.Vacina;
import br.com.hiago640.vaxlog.repository.VacinaRepository;

@RestController
@RequestMapping("/vacina")
public class VacinaController {

	@Autowired
	private VacinaRepository repository;
	
	@GetMapping("/listar")
	public List<Vacina> getAll() {
		System.out.println("entrou aqui");
		
		return repository.findAll();
	}
	
	@PostMapping("/criar")
	public Vacina incluirVacina(@RequestBody Vacina vacina) {
	
		repository.save(vacina);
		
		return vacina;
	}
	
}
