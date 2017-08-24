package br.edu.ifpb.tcc.entity;

public enum Tipo {
	PSQ("PESQUISA"),
	INV("INOVA��O"),
	TRB("TRABALHADOR"),
	EST("EST�GIO");
	
	private String nome;

	Tipo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
