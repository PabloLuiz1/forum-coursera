package org.coursera.desenvagil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static 
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection
					("jdbc:postgresql://127.0.0.1:5432/dbforum", "postgres", "admin");
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível exceutar o acesso", e);
		}
		return conn;
	}
	
	public static void desconectar(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
