package org.coursera.desenvagil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.coursera.desenvagil.model.EntidadeDominio;
import org.coursera.desenvagil.model.Usuario;
import org.postgresql.util.PSQLException;

public class GenericDAO<E extends EntidadeDominio> implements IGerenciaDAO {

	@Override
	public void inserir(EntidadeDominio e) {
		Connection conn = Conexao.conectar();
		PreparedStatement stm;
		if (e instanceof Usuario) {
			Usuario u = (Usuario) e;
			try {
				stm = conn.prepareStatement("INSERT INTO usuario (nome, login, email, senha) VALUES (?, ?, ?, ?)");
				stm.setString(1, u.getNome());
				stm.setString(2, u.getLogin());
				stm.setString(3, u.getEmail());
				stm.setString(4, u.getSenha());
				stm.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List consultarTodos(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return false;
	}

}
