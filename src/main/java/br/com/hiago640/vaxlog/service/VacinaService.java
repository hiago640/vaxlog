package br.com.hiago640.vaxlog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.dto.VacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.VacinaResponseDTO;
import br.com.hiago640.vaxlog.exception.custom.VaccineNotFoundException;
import br.com.hiago640.vaxlog.mapper.VacinaMapper;
import br.com.hiago640.vaxlog.model.Vacina;
import br.com.hiago640.vaxlog.repository.VacinaRepository;

@Service
public class VacinaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VacinaService.class);

	@Autowired
	private VacinaRepository repository;

	@Autowired
	private VacinaMapper mapper;

	@Transactional
	public VacinaResponseDTO salvar(VacinaRequestDTO dto) {
		LOGGER.trace("Entrou em salvarVacina");
		LOGGER.debug("Vacina recebida: {}", dto);

		Vacina vacina = mapper.toEntity(dto);
		Vacina salvo = repository.save(vacina);

		LOGGER.debug("Vacina salva com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public VacinaResponseDTO alterar(Long id, VacinaRequestDTO dto) {
		LOGGER.trace("Entrou em alterarVacina");
		LOGGER.debug("ID recebido: {}, DTO: {}", id, dto);

		if (!repository.existsById(id)) {
			throw new VaccineNotFoundException();
		}

		Vacina vacina = mapper.toEntity(dto);
		vacina.setId(id);

		Vacina salvo = repository.save(vacina);

		LOGGER.debug("Vacina alterada com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public void excluir(Long id) {
		LOGGER.trace("Entrou em excluirVacina");
		LOGGER.debug("ID recebido para exclusão: {}", id);

		if (!repository.existsById(id)) {
			throw new VaccineNotFoundException();
		}

		repository.deleteById(id);
		LOGGER.debug("Vacina removida com sucesso. ID: {}", id);
	}

	public List<VacinaResponseDTO> listarTodos() {
		List<VacinaResponseDTO> lista = repository.findAll().stream().map(mapper::toResponse).toList();
		return lista;
	}

}
