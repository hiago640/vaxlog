package br.com.hiago640.vaxlog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
	private String nome;
	private String email;
	private String password;

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, nome=%s, email=%s, password=%s]", id, nome, email, password);
	}

}
