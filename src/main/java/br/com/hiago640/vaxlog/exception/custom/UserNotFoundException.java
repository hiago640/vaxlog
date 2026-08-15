package br.com.hiago640.vaxlog.exception.custom;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 7570005252208072833L;

	public UserNotFoundException() {
		super("Usuário não localizado.");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	

}
