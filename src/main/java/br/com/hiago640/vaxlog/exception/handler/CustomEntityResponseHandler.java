package br.com.hiago640.vaxlog.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CustomEntityResponseHandler { 
	
	/* 400 - HttpStatus.BAD_REQUEST*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(MethodArgumentNotValidException ex) {
    	
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Erro na validação dos dados da requisição.");
        problemDetail.setTitle("Dados Inválidos");

        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            erros.put(error.getField(), error.getDefaultMessage())
        );
        
        problemDetail.setProperty("erros", erros);
        
        return problemDetail;
    }
    
    /* 404 - HttpStatus.NOT_FOUND*/
    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleEntityNotFoundException(EntityNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Recurso não encontrado");
        
        return problemDetail;
    }
    
    /*JSON mal formado*/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleMessageNotReadable(HttpMessageNotReadableException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "O corpo da requisição está malformado ou contém tipos de dados inválidos.");
        problemDetail.setTitle("Requisição Malformada");
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleAllExceptions(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno inesperado no servidor: " );
        problemDetail.setTitle("Erro Interno do Servidor");
        
        return problemDetail;
    }
}