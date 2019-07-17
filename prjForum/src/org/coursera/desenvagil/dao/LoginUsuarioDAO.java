package org.coursera.desenvagil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.coursera.desenvagil.model.Usuario;

public class LoginUsuarioDAO {
	public Usuario logar(Usuario u) {
		Usuario usuario = null;
		Connection conn = Conexao.conectar();
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT nome, login, email, senha, pontos FROM usuario WHERE login = ? AND senha = ?");
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPontos(rs.getInt("pontos"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
}
