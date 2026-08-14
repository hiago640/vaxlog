package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;

public record RegistroVacinaRequestDTO(
	@Nonnull Long usuarioId, 
	@Nonnull Long vacinaId, 
	@Nonnull String dose, 
	@Nonnull LocalDate dataAplicacao,
	String estabelecimento, 
	String lote, 
	String observacao
) {}
