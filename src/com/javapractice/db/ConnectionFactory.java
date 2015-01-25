/**
 * 
 */
package com.javapractice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author feng
 *
 */
public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	private static final String URL = "jdbc:mysql://localhost/employee_manager";
	private static final String USER = "root";
	private static final String PASS = "admin123";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
