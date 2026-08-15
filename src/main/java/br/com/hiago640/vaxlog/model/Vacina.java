package br.com.hiago640.vaxlog.model;

import java.time.LocalDate;

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
public class Vacina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String fabricante;
	private String lote;
	private LocalDate dataValidade;

	@Override
	public String toString() {
		return String.format("Vacina [id=%s, nome=%s, fabricante=%s, lote=%s, dataValidade=%s]", id, nome, fabricante,
				lote, dataValidade);
	}

}
