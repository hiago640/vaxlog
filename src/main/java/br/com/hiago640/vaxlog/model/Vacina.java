package br.com.hiago640.vaxlog.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vacina {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	private String nome;
	private String lote;
	private LocalDate aplicacao;
	
	public Vacina() {
	}

	public Vacina(UUID id, String nome, String lote, LocalDate aplicacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.lote = lote;
		this.aplicacao = aplicacao;
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

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public LocalDate getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(LocalDate aplicacao) {
		this.aplicacao = aplicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Vacina [id=%s, nome=%s, lote=%s, aplicacao=%s]", id, nome, lote, aplicacao);
	}

}
