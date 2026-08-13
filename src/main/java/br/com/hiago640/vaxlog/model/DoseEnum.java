package br.com.hiago640.vaxlog.model;

public enum DoseEnum {

	DOSE_UNICA("Dose Única"),
	DOSE_ZERO("Dose Zero"),
	PRIMEIRA_DOSE("1ª Dose"),
	SEGUNDA_DOSE("2ª Dose"),
	TERCEIRA_DOSE("3ª Dose"),
	DOSE_ADICIONAL("Dose Adicional"),
	REFORCO("Reforço"),
	REFORCO_ANUAL("Reforço Anual"),
	DOSE_CAMPANHA("Dose de Campanha");

	private String descricao;

	private DoseEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
