package br.com.hiago640.vaxlog.exception.custom;

import jakarta.persistence.EntityNotFoundException;

public class VaccineRecordNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1275635155022317431L;

	public VaccineRecordNotFoundException() {
		super("Registro de Vacinação não localizado.");
	}
	
	public VaccineRecordNotFoundException(String message) {
		super(message);
	}
	

}
