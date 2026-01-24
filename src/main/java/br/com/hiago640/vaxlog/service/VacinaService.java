package br.com.hiago640.vaxlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.model.Vacina;
import br.com.hiago640.vaxlog.repository.VacinaRepository;

@Service
public class VacinaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VacinaService.class);

	@Autowired
	private VacinaRepository repository;

	@Transactional
	public void salvar(Vacina vacina) {
		LOGGER.trace("Entrou em salvarVacina");
		LOGGER.debug("Vacina recebida: {}", vacina);

		repository.save(vacina);

		LOGGER.debug("Vacina salva com sucesso: {}", vacina);
	}

	@Transactional
	public void alterar(Vacina vacina) {
		LOGGER.trace("Entrou em alterarVacina");
		LOGGER.debug("Vacina recebida: {}", vacina);

		repository.save(vacina);

		LOGGER.debug("Vacina alterada com sucesso: {}", vacina);
	}

	@Transactional
	public void excluir(Vacina vacina) {
		LOGGER.trace("Entrou em excluirVacina");
		LOGGER.debug("Vacina recebida: {}", vacina);

		repository.delete(vacina);

		LOGGER.debug("Vacina removida com sucesso: {}", vacina);
	}

}
