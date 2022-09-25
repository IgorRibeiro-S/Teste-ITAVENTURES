package com.teste.Controle.entities.enums;


public enum Acesso {

	ADMIN(1), COLABORADOR(2);

	private int code;

	private Acesso(int code) {
		this.code = code;

	}

	public int getCode() {
		return code;
	}

	//@JsonCreator
	public static Acesso valueOf(int code) {
		for (Acesso values : Acesso.values()) {
			if (values.getCode() == code) {
				return values;
			}
		}
		throw new IllegalArgumentException("Invalid AcessType Code");

	}

}