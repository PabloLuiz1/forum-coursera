package org.coursera.desenvagil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.coursera.desenvagil.model.Topico;
import org.coursera.desenvagil.model.Usuario;

public class TopicoDAO extends GerenciaDAO<Topico>{
	
	@Override
	public void inserir(Topico t) {
		try {
			stm = conn.prepareStatement("INSERT INTO topico (titulo, conteudo, login) VALUES (?, ?, ?)");
			stm.setString(1, t.getTitulo());
			stm.setString(2, t.getConteudo());
			stm.setString(3, t.getUsuario().getLogin());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Topico> listar() {
		List<Topico> topicos = null;
		try {
			stm = conn.prepareStatement("SELECT id_topico, titulo, conteudo, login FROM topico");
			ResultSet rs = stm.executeQuery();
			topicos = new ArrayList<Topico>();
			while (rs.next()) {		
				Topico topico = new Topico();
				topico.setId(rs.getLong("id_topico"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setConteudo(rs.getString("conteudo"));
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				topico.setUsuario(usuario);
				topicos.add(topico);
			}
			return topicos;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return topicos;
	}

	@Override
	public Topico consultar(Topico t) {
		Topico topico = null;
		try {
			stm = conn.prepareStatement("SELECT id_topico, titulo, conteudo, login FROM topico WHERE id_topico = ?");
			stm.setLong(1, t.getId());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				topico = new Topico();
				Usuario usuario = new Usuario();
				topico.setId(rs.getLong("id_topico"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setConteudo(rs.getString("conteudo"));
				usuario.setLogin(rs.getString("login"));
				topico.setUsuario(usuario);
				return topico;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topico;
	}
	
	@Override
	public boolean editar(Topico t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(Topico t) {
		// TODO Auto-generated method stub
		return false;
	}

}
