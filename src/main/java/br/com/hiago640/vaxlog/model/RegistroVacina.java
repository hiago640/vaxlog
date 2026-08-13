package br.com.hiago640.vaxlog.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroVacina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Usuario usuario;

	@ManyToOne(optional = false)
	private Vacina vacina;

	@Enumerated(EnumType.STRING)
	private DoseEnum dose;

	private LocalDate dataAplicacao;
	private String localAplicacao;
	private String lote;
	private String observacao;

	public String toString() {
		return String.format(
				"RegistroVacina [id=%s, usuario=%s, vacina=%s, dose=%s, dataAplicacao=%s, localAplicacao=%s, lote=%s, observacao=%s]",
				id, usuario, vacina, dose, dataAplicacao, localAplicacao, lote, observacao);
	}

}
