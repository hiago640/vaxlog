package br.com.hiago640.vaxlog.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	private String nome;
	private String email;
	private String password;

	public Usuario() {
	}

	public Usuario(UUID id, String nome, String email, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, nome=%s, email=%s, password=%s]", id, nome, email, password);
	}

}
