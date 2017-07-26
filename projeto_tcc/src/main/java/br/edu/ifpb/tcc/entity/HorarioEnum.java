package br.edu.ifpb.tcc.entity;

import java.time.LocalTime;

public enum HorarioEnum {
	
	M1(LocalTime.of(7,00),LocalTime.of(7, 50)),
	M2(LocalTime.of(7,50),LocalTime.of(8, 40)),
	M3(LocalTime.of(8,40),LocalTime.of(9, 30)),
	M4(LocalTime.of(9,50),LocalTime.of(10,40)),
	M5(LocalTime.of(10,40),LocalTime.of(11, 30)),
	M6(LocalTime.of(11,30),LocalTime.of(12, 20)),
	T1(LocalTime.of(13,00),LocalTime.of(13, 50)),
	T2(LocalTime.of(13,50),LocalTime.of(14, 40)),
	T3(LocalTime.of(14,40),LocalTime.of(15, 30)),
	T4(LocalTime.of(15,50),LocalTime.of(16, 40)),
	T5(LocalTime.of(16,40),LocalTime.of(17, 30)),
	T6(LocalTime.of(17,30),LocalTime.of(18, 20)),
	N1(LocalTime.of(18,20),LocalTime.of(19, 10)),
	N2(LocalTime.of(19,10),LocalTime.of(20, 00)),
	N3(LocalTime.of(20,00),LocalTime.of(20, 50)),
	N4(LocalTime.of(20,50),LocalTime.of(21, 40)),
	N5(LocalTime.of(21,40),LocalTime.of(22, 30));
	
	
	private LocalTime inicio;
	private LocalTime fim;
	
	private HorarioEnum(LocalTime inicio, LocalTime fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getFim() {
		return fim;
	}

	public void setFim(LocalTime fim) {
		this.fim = fim;
	}
	
	

}
