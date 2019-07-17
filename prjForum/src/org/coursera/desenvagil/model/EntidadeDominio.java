package org.coursera.desenvagil.model;

public class EntidadeDominio {
	private String nomeClasse;

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nome) {
		this.nomeClasse = nome.toLowerCase();
	}
}
