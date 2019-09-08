package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException {

		Connection conn = null;
		try {
			String url = "jdbc:sqlite:database.db";

			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			throw new SQLException("Conexao nao realizada");

		}
		return conn;

	}
}
