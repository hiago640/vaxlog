package br.com.hiago640.vaxlog.model;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
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

	@Nonnull
	@ManyToOne(optional = false)
	private Usuario usuario;

	@ManyToOne(optional = false)
	@Nonnull
	private Vacina vacina;
	
	@Nonnull
	@Enumerated(EnumType.STRING)
	private DoseEnum dose;
	
	@Nonnull
	private LocalDate dataAplicacao;
	@Nonnull	
	private String lote;
	private String estabelecimento;
	private String observacao;

	public String toString() {
		return String.format(
				"RegistroVacina [id=%s, usuario=%s, vacina=%s, dose=%s, dataAplicacao=%s, estabelecimento=%s, lote=%s, observacao=%s]",
				id, usuario, vacina, dose, dataAplicacao, estabelecimento, lote, observacao);
	}

}
