package org.coursera.desenvagil.dao;

import java.util.List;

import org.coursera.desenvagil.model.EntidadeDominio;

public interface IGerenciaDAO <E extends EntidadeDominio>{
	public void inserir(E e);
	public List<E> consultarTodos(E e);
	public boolean editar(E e);
	public boolean remover(E e);
}
