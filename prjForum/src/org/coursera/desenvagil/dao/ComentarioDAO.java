package org.coursera.desenvagil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.coursera.desenvagil.model.Comentario;
import org.coursera.desenvagil.model.Topico;
import org.coursera.desenvagil.model.Usuario;

public class ComentarioDAO extends GerenciaDAO<Comentario>{
	
	@Override
	public void inserir(Comentario comentario) {
		try {
			stm = conn.prepareStatement("INSERT INTO comentario (comentario, login, id_topico) VALUES (?, ?, ?)");
			stm.setString(1, comentario.getComentario());
			stm.setString(2, comentario.getUsuario().getLogin());
			stm.setLong(3, comentario.getTopico().getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Comentario> listar(Topico topico) {
		List<Comentario> comentarios = null;
		try {
			stm = conn.prepareStatement("SELECT comentario, login, id_topico FROM comentario WHERE id_topico = ?");
			stm.setLong(1, topico.getId());
			ResultSet rs = stm.executeQuery();
			comentarios = new ArrayList<Comentario>();
			while (rs.next()) {
				Comentario c = new Comentario();
				Topico t = new Topico();
				Usuario u = new Usuario();
				c.setComentario(rs.getString("comentario"));
				u.setLogin(rs.getString("login"));
				t.setId(rs.getLong("id_topico"));
				c.setUsuario(u);
				c.setTopico(t);
				comentarios.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comentarios;
	}
}
