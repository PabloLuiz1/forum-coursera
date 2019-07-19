package org.coursera.desenvagil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.coursera.desenvagil.model.EntidadeDominio;

public abstract class GerenciaDAO <E extends EntidadeDominio>{
	protected Connection conn = Conexao.conectar();
	protected PreparedStatement stm;
	
	public void inserir(E e) {
	}
	
	public E consultar(E e) {
		return null;
	}
	
	public List<E> listar() {
		return null;
	}
	public boolean editar(E e) {
		return false;
	}
	public boolean remover(E e) {
		return false;
	}
}
