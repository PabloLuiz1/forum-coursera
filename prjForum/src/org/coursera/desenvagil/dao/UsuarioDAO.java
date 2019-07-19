package org.coursera.desenvagil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.coursera.desenvagil.model.AcaoDoUsuarioEnum;
import org.coursera.desenvagil.model.Usuario;

public class UsuarioDAO extends GerenciaDAO<Usuario> {
	
	@Override
	public void inserir(Usuario u) {
			try {
				stm = conn.prepareStatement("INSERT INTO usuario (nome, login, email, senha) VALUES (?, ?, ?, ?)");
				stm.setString(1, u.getNome());
				stm.setString(2, u.getLogin());
				stm.setString(3, u.getEmail());
				stm.setString(4, u.getSenha());
				stm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = null;
		try {
			stm = conn.prepareStatement("SELECT nome, login, pontos FROM usuario ORDER BY pontos DESC");
			ResultSet rs = stm.executeQuery();
			usuarios = new ArrayList<Usuario>();
			while (rs.next()) {		
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setPontos(rs.getInt("pontos"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarios;
	}
	
	@Override
	public Usuario consultar(Usuario u) {
		Usuario usuario = null;
		try {
			stm = conn.prepareStatement("SELECT nome, login, email, senha, pontos FROM usuario WHERE login = ? AND senha = ?");
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

	@Override
	public boolean editar(Usuario e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(Usuario e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atualizarPontos(Usuario u, AcaoDoUsuarioEnum acao) {
		try {
			stm = conn.prepareStatement("UPDATE usuario SET pontos = pontos + ? WHERE login = ?");
			if (acao.equals(AcaoDoUsuarioEnum.NOVOTOPICO)) {
				stm.setInt(1, AcaoDoUsuarioEnum.NOVOTOPICO.pontos);
			}
			if (acao.equals(AcaoDoUsuarioEnum.NOVOCOMENTARIO)) {
				stm.setInt(1, AcaoDoUsuarioEnum.NOVOCOMENTARIO.pontos);
			}
			stm.setString(2, u.getLogin());
			return stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
