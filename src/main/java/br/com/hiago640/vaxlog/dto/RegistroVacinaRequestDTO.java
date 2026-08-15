package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record RegistroVacinaRequestDTO(
	@NotNull(message = "O ID Usuário é obrigatório") 
	Long usuarioId, 
	
	@NotNull(message = "O ID Vacina é obrigatório") 
	Long vacinaId, 
	
	@NotBlank(message = "A Dose é obrigatória") 
	String dose, 

	@PastOrPresent(message = "A Data de Aplicação não pode estar no Futuro")  
	LocalDate dataAplicacao,
	String estabelecimento, 
	String observacao
) {}
