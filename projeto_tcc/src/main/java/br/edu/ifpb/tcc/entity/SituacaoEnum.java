package br.edu.ifpb.tcc.entity;

public enum SituacaoEnum {
	
	ANALISE("Em análise"),
	DEFERIDO("Deferido"),
	INDEFERIDO("Indeferido"),
	FINALIZADO("Finalizado");
	
	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
