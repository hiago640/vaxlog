package br.com.hiago640.vaxlog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.dto.UserRequestDTO;
import br.com.hiago640.vaxlog.dto.UserResponseDTO;
import br.com.hiago640.vaxlog.exception.custom.UserNotFoundException;
import br.com.hiago640.vaxlog.mapper.UsuarioMapper;
import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioMapper mapper;

	@Transactional
	public UserResponseDTO salvar(UserRequestDTO dto) {
		LOGGER.trace("Entrou em salvarUsuario");
		LOGGER.debug("Usuario recebido: {}", dto);

		Usuario usuario = mapper.toEntity(dto);
		Usuario salvo = repository.save(usuario);

		LOGGER.debug("Usuario salvo com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public UserResponseDTO alterar(Long id, UserRequestDTO dto) {
		LOGGER.trace("Entrou em alterarUsuario");
		LOGGER.debug("ID recebido: {}, DTO: {}", id, dto);

		if (!repository.existsById(id)) {
			throw new UserNotFoundException();
		}

		Usuario user = mapper.toEntity(dto);
		user.setId(id);

		Usuario salvo = repository.save(user);

		LOGGER.debug("Usuário alterado com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public void excluir(Long id) {
		LOGGER.trace("Entrou em excluirUsuario");
		LOGGER.debug("ID recebido para exclusão: {}", id);

		if (!repository.existsById(id)) {
			throw new UserNotFoundException();
		}

		repository.deleteById(id);
		LOGGER.debug("Usuário removido com sucesso. ID: {}", id);
	}

	public List<UserResponseDTO> listarTodos() {
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}

}
