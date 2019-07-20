package org.coursera.desenvagil.test.usuario;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.coursera.desenvagil.dao.UsuarioDAO;
import org.coursera.desenvagil.model.AcaoDoUsuarioEnum;
import org.coursera.desenvagil.model.Usuario;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

public class TesteUsuarioDAO {

	JdbcDatabaseTester jdt;

	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/dbforum", "postgres",
				"admin");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = dao.listar();
		assertEquals(2, usuarios.size());
		assertEquals("pablo", usuarios.get(0).getLogin());
	}

	@Test
	public void inserir() throws Exception {
		Usuario u = new Usuario();
		u.setNome("João Henrique");
		u.setLogin("joaohenrique");
		u.setEmail("joaohenrique@gmail.com");
		u.setSenha("123456");
		UsuarioDAO dao = new UsuarioDAO();
		dao.inserir(u);

		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("usuario");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("org/coursera/desenvagil/xml/verificaUsuario.xml");
		ITable expectedTable = expectedDataSet.getTable("usuario");

		Assertion.assertEquals(expectedTable, currentTable);
	}

	@Test
	public void consultar() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("pablo");
		Usuario u = dao.consultar(usuario);
		assertEquals("pablo", u.getLogin());
	}

	@Test
	public void atualizarPontos() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("pablo");
		Usuario u = dao.consultar(usuario);
		dao.atualizarPontos(u, AcaoDoUsuarioEnum.NOVOTOPICO);
		assertEquals(10, dao.listar().get(0).getPontos());
	}
}
