package data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection connection; // a ser utilizado no dao

	private final String URL = "jdbc:mysql://localhost:3306/prova";

	private final String USER = "root";

	private final String PASSWORD = "123m4ciqr12";

	private final String TPCONEXAO = "com.mysql.jdbc.Driver";

	public Connection abrir() {
		try {
			Class.forName(TPCONEXAO);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("funcionou");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	public void fechar() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
