package br.com.hiago640.vaxlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository repository;

	@Transactional
	public void salvar(Usuario usuario) {
		LOGGER.trace("Entrou em salvarUsuario");
		LOGGER.debug("Usuario recebido: {}", usuario);

		repository.save(usuario);

		LOGGER.debug("Usuario salvo com sucesso: {}", usuario);
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

}
