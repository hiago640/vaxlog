package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

public record VacinaResponseDTO (
	Long id, 
	String nome, 
	String fabricante,
	String lote,
	LocalDate dataValidade
) {}
