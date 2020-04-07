package br.com.ies.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection connection;

	public ConnectionFactory(String url, String user, String password) {
		createConnection(url, user, password);
	}

	private void createConnection(String url, String user, String password) {
		try {
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
}
