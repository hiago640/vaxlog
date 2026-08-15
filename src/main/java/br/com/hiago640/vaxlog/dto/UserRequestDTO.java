package br.com.hiago640.vaxlog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO (
	@NotBlank(message = "O nome é obrigatório") 
	String nome,
	
	@NotBlank(message = "O Email é obrigatório") 
	@Email(message = "É necessário incluir um e-mail válido")  
	String email,
	
	@NotBlank(message = "A senha é obrigatória")  
	String password
) {}
