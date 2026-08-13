package br.com.hiago640.vaxlog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.dto.CreateUserDTO;
import br.com.hiago640.vaxlog.dto.UserResponseDTO;
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
	public UserResponseDTO salvar(CreateUserDTO dto) {
		LOGGER.trace("Entrou em salvarUsuario");
		LOGGER.debug("Usuario recebido: {}", dto);

		Usuario usuario = mapper.toEntity(dto);
		Usuario salvo = repository.save(usuario);

		LOGGER.debug("Usuario salvo com sucesso: {}", salvo);
		return mapper.toResponse(salvo);
	}

	@Transactional
	public void alterar(Usuario usuario) {
		LOGGER.trace("Entrou em alterarUsuario");
		LOGGER.debug("Usuario recebido: {}", usuario);

		repository.save(usuario);

		LOGGER.debug("Usuario alterado com sucesso: {}", usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) {
		LOGGER.trace("Entrou em excluirUsuario");
		LOGGER.debug("Usuario recebido: {}", usuario);

		repository.delete(usuario);

		LOGGER.debug("Usuario removido com sucesso: {}", usuario);
	}

	public List<UserResponseDTO> listarTodos() {
		return repository.findAll().stream().map(mapper::toResponse).toList();
	}

}
