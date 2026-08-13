package br.com.hiago640.vaxlog.dto;

import jakarta.annotation.Nonnull;

public record CreateUserDTO (
	@Nonnull String nome,
	@Nonnull String email,
	@Nonnull String password
) {}
