package br.com.hiago640.vaxlog.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VacinaRequestDTO(
    @NotBlank(message = "O nome é obrigatório") 
    String nome, 
    
    @NotBlank(message = "O fabricante é obrigatório") 
    String fabricante,
    
    @NotBlank(message = "O lote é obrigatório") 
    String lote,
    
    @NotNull(message = "A data de validade é obrigatória") 
    @FutureOrPresent(message = "A data de validade não pode estar no passado") 
    LocalDate dataValidade
) {}
