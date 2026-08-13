package br.com.hiago640.vaxlog.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hiago640.vaxlog.exception.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleEntityNotFoundException(Exception e, WebRequest request){
		
		ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request){
		
		ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	

	
}
