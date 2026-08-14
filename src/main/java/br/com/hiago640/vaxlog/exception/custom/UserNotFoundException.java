package br.com.hiago640.vaxlog.exception.custom;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7570005252208072833L;

	public UserNotFoundException() {
		super("Usuário não localizado.");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	

}
