package br.edu.ifpb.tcc.entity;

public enum Tipo {
	PSQ("PESQUISA"),
	INV("INOVAÇÃO"),
	TRB("TRABALHADOR"),
	EST("ESTÁGIO");
	
	private String nome;

	Tipo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
