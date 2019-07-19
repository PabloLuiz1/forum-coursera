package org.coursera.desenvagil.model;

public enum AcaoDoUsuarioEnum {
	NOVOTOPICO(10),
	NOVOCOMENTARIO(3);
	
	public int pontos;
	
	private AcaoDoUsuarioEnum(int pontos) {
		this.pontos = pontos;
	}
}
