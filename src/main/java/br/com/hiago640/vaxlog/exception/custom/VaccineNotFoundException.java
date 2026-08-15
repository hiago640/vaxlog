package br.com.hiago640.vaxlog.exception.custom;

import jakarta.persistence.EntityNotFoundException;

public class VaccineNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1275635155022317431L;

	public VaccineNotFoundException() {
		super("Vacina não localizada.");
	}
	
	public VaccineNotFoundException(String message) {
		super(message);
	}
	

}
