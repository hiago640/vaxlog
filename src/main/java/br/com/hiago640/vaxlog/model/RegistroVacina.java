package br.com.hiago640.vaxlog.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroVacina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@ManyToOne(optional = false)
	public Usuario usuario;

	@ManyToOne(optional = false)
	public Vacina vacina;

	public String dose;

	public LocalDate dataAplicacao;

	public String localAplicacao;

	public String lote;

	@Column(length = 500)
	public String observacoes;

	public RegistroVacina() {
	}

	public RegistroVacina(Usuario usuario, Vacina vacina, String dose, LocalDate dataAplicacao,
			String localAplicacao, String lote, String observacoes) {

		this.usuario = usuario;
		this.vacina = vacina;
		this.dose = dose;
		this.dataAplicacao = dataAplicacao;
		this.localAplicacao = localAplicacao;
		this.lote = lote;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public String getLocalAplicacao() {
		return localAplicacao;
	}

	public void setLocalAplicacao(String localAplicacao) {
		this.localAplicacao = localAplicacao;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return String.format(
				"RegistroVacina [id=%s, usuario=%s, vacina=%s, dose=%s, dataAplicacao=%s, localAplicacao=%s, lote=%s, observacoes=%s]",
				id, usuario, vacina, dose, dataAplicacao, localAplicacao, lote, observacoes);
	}

}
