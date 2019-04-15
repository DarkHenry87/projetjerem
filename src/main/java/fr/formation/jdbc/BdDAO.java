package fr.formation.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BdDAO {

	public static void main(String[] str) throws SQLException {
		getAll();

	}

	public static void getAll() throws SQLException {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();

		// create statement

		Statement statement = connection.createStatement();

		// requete
		String sql = "select emp_id,FIRST_NAME from employee";

		ResultSet rs = statement.executeQuery(sql);
//		statement.executeUpdate(sql);
		// 
		while (rs.next()) {
			int empId = rs.getInt("emp_id");
			String firstName = rs.getString(2);
			System.out.println("---------------------------");
			System.out.println("EmpId :" + empId);
			System.out.println("FirstName :" + firstName);
		}
		//close connection
		connection.close();
	}
	

}
