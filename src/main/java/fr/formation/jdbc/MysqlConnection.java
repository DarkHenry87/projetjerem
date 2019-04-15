package fr.formation.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	private final static String dbURL = "jdbc:mysql://localhost:3306/bd";
	private final static String username = "root";
	private final static String password = "123456";

	public static Connection conn;
	public static void seConnecter()  {
		try {
			
			conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				System.out.println("ConnectÃ©");
			} else {
				System.out.println(" Connection Ã©chouÃ©e");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}

}
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DriverManager.getConnection(dbURL, username, password);
			
			if (conn != null) {
				System.out.println("Connecté");
			} else {
				System.out.println("Connection échouée");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return conn;

}
}
