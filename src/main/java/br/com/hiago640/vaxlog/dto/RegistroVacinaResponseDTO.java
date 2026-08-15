package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

import br.com.hiago640.vaxlog.model.DoseEnum;

public record RegistroVacinaResponseDTO(
	Long id,
	UserResponseDTO usuario, 
    VacinaResponseDTO vacina,
    DoseEnum dose,
	LocalDate dataAplicacao, 
	String estabelecimento, 
	String observacao) {
}
