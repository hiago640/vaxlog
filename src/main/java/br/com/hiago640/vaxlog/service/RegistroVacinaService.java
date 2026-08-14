package br.com.hiago640.vaxlog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.dto.RegistroVacinaRequestDTO;
import br.com.hiago640.vaxlog.dto.RegistroVacinaResponseDTO;
import br.com.hiago640.vaxlog.exception.custom.UserNotFoundException;
import br.com.hiago640.vaxlog.exception.custom.VaccineNotFoundException;
import br.com.hiago640.vaxlog.exception.custom.VaccineRecordNotFoundException;
import br.com.hiago640.vaxlog.mapper.RegistroVacinaMapper;
import br.com.hiago640.vaxlog.model.RegistroVacina;
import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.model.Vacina;
import br.com.hiago640.vaxlog.repository.RegistroVacinaRepository;
import br.com.hiago640.vaxlog.repository.UsuarioRepository;
import br.com.hiago640.vaxlog.repository.VacinaRepository;

@Service
public class RegistroVacinaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistroVacinaService.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VacinaRepository vacinaRepository;

	@Autowired
	private RegistroVacinaRepository registroRepository;

	@Autowired
	private RegistroVacinaMapper mapper;

	@Transactional
	public RegistroVacinaResponseDTO salvar(RegistroVacinaRequestDTO dto) {
		LOGGER.trace("Entrou em salvarAplicacao");
		LOGGER.debug("Aplicacao recebida: {}", dto);

		Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new UserNotFoundException());

		Vacina vacina = vacinaRepository.findById(dto.vacinaId()).orElseThrow(() -> new VaccineNotFoundException());

		RegistroVacina aplicacao = mapper.toEntity(dto, usuario, vacina);
		RegistroVacina salvo = registroRepository.save(aplicacao);

		LOGGER.debug("Aplicação salva com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public RegistroVacinaResponseDTO alterar(Long id, RegistroVacinaRequestDTO dto) {
		LOGGER.trace("Entrou em alterarAplicacao");
		LOGGER.debug("ID recebido: {}, DTO: {}", id, dto);

		if (!registroRepository.existsById(id)) {
			throw new VaccineRecordNotFoundException();
		}

		Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new UserNotFoundException());

		Vacina vacina = vacinaRepository.findById(dto.vacinaId()).orElseThrow(() -> new VaccineNotFoundException());

		RegistroVacina aplicacao = mapper.toEntity(dto, usuario, vacina);
		aplicacao.setId(id);

		RegistroVacina salvo = registroRepository.save(aplicacao);

		LOGGER.debug("Aplicação alterada com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public void excluir(Long id) {
		LOGGER.trace("Entrou em excluirAplicacao");
		LOGGER.debug("ID recebido para exclusão: {}", id);

		if (!registroRepository.existsById(id)) {
			throw new VaccineRecordNotFoundException();
		}

		registroRepository.deleteById(id);
		LOGGER.debug("Aplicação removida com sucesso. ID: {}", id);
	}

	public List<RegistroVacinaResponseDTO> listarTodos() {
		return registroRepository.findAll().stream().map(mapper::toResponse).toList();
	}

	public List<RegistroVacinaResponseDTO> listarPorUsuario(Long usuarioID) {
		Usuario usuario = usuarioRepository.findById(usuarioID).orElseThrow(() -> new UserNotFoundException());

		return registroRepository.findByUsuario(usuario).stream().map(mapper::toResponse).toList();
	}
}
