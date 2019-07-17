package org.coursera.desenvagil.model;

public class Usuario extends EntidadeDominio{
	private long id;
	private String nome;
	private String login;
	private String email;
	private String senha;
	private int pontos = 0;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", email=" + email + ", senha=" + senha + ", pontos=" + pontos
				+ "]";
	}
	
	
}
