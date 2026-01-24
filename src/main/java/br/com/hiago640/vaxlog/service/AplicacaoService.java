package br.com.hiago640.vaxlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiago640.vaxlog.dto.AplicacaoRequest;
import br.com.hiago640.vaxlog.model.RegistroVacina;
import br.com.hiago640.vaxlog.model.Usuario;
import br.com.hiago640.vaxlog.model.Vacina;
import br.com.hiago640.vaxlog.repository.AplicacaoRepository;
import br.com.hiago640.vaxlog.repository.UsuarioRepository;
import br.com.hiago640.vaxlog.repository.VacinaRepository;

@Service
public class AplicacaoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AplicacaoService.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VacinaRepository vacinaRepository;

	@Autowired
	private AplicacaoRepository registroRepository;

	@Transactional
	public void salvar(AplicacaoRequest dto) {

		LOGGER.trace("Entrou em salvarAplicacao");
		LOGGER.debug("Aplicacao recebida: {}", dto);
		
		Usuario usuario = usuarioRepository.findById(dto.usuarioId)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		Vacina vacina = vacinaRepository.findById(dto.vacinaId)
				.orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

		RegistroVacina registro = new RegistroVacina();
		registro.usuario = usuario;
		registro.vacina = vacina;
		registro.dose = dto.dose;
		registro.dataAplicacao = dto.dataAplicacao;
		registro.localAplicacao = dto.localAplicacao;
		registro.lote = dto.lote;
		registro.observacoes = dto.observacao;

		registroRepository.save(registro);
		
		LOGGER.debug("Aplicação salva com sucesso: {}", vacina);
	}
	
	@Transactional
	public void alterar(AplicacaoRequest dto) {
		LOGGER.trace("Entrou em alterarAplicacao");
		LOGGER.debug("Aplicacao recebido: {}", dto);

		Usuario usuario = usuarioRepository.findById(dto.usuarioId)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		Vacina vacina = vacinaRepository.findById(dto.vacinaId)
				.orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

		RegistroVacina registro = new RegistroVacina();
		registro.usuario = usuario;
		registro.vacina = vacina;
		registro.dose = dto.dose;
		registro.dataAplicacao = dto.dataAplicacao;
		registro.localAplicacao = dto.localAplicacao;
		registro.lote = dto.lote;
		registro.observacoes = dto.observacao;
		
		registroRepository.save(registro);

		LOGGER.debug("Aplicacao alterada com sucesso: {}", registro);
	}

	@Transactional
	public void excluir(AplicacaoRequest dto) {
		LOGGER.trace("Entrou em excluirAplicacao");
		LOGGER.debug("Aplicacao recebida: {}", dto);

		Usuario usuario = usuarioRepository.findById(dto.usuarioId)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		Vacina vacina = vacinaRepository.findById(dto.vacinaId)
				.orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

		RegistroVacina registro = new RegistroVacina();
		registro.usuario = usuario;
		registro.vacina = vacina;
		registro.dose = dto.dose;
		registro.dataAplicacao = dto.dataAplicacao;
		registro.localAplicacao = dto.localAplicacao;
		registro.lote = dto.lote;
		registro.observacoes = dto.observacao;
		
		registroRepository.delete(registro);

		LOGGER.debug("Aplicação removida com sucesso: {}", registro);
	}
}
