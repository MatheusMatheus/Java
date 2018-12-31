package farmacia.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String ip = "jdbc:mysql://localhost/";
	private final static String user = "root";
	private final static String senha = "root";
	private final static String banco = "Farmacia";

	public static Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(ip + banco, user, senha);
			if(connection != null) {
				System.out.println("Conexão realizada");
				return connection;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
