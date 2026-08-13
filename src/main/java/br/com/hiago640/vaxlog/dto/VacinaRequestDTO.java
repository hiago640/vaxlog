package br.com.hiago640.vaxlog.dto;

import jakarta.annotation.Nonnull;

public record VacinaRequestDTO(
	@Nonnull String nome, 
	@Nonnull String fabricante
) {}
