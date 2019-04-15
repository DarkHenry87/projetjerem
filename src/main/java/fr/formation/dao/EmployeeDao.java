package fr.formation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.beans.Employee;
import fr.formation.jdbc.MysqlConnection;

public class EmployeeDao implements IEmployeeDao {

	public Employee getById(Integer id) {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();
		// requete
		String sql = "select FIRST_NAME,LAST_NAME,TITLE,Start_date from crashtest where emp_id =?";
		// create statement
		PreparedStatement pstm;
		Employee emp = null;
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				emp = new Employee();
				emp.setEmpId(id);
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setTitle(rs.getString(3));
				emp.setStartDate(rs.getDate(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public List<Employee> getByName(String firstName) throws SQLException {
		// connection
		Connection connection = MysqlConnection.getConnection();
		connection.setAutoCommit(false);

		// create statement
		Statement statement;
		statement = connection.createStatement();

		// requete

		List<Employee> list = new ArrayList<Employee>();
		String fn = "'" + firstName + "'";

		String sql = "select emp_id,first_name, last_name, title, Start_date from employee where first_name=" + fn;

		PreparedStatement pstm;
		ResultSet rs;
		Employee emp;

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setTitle(rs.getString(4));
				emp.setStartDate(rs.getDate(5));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {

			}
			return null;

		} finally {

			if (statement != null) {

				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

		}
		return list;

	}

	/**
	 * methode qui retourn tous les employees
	 */
	public List<Employee> getAll() {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();
		// requete
		String sql = "select emp_id,FIRST_NAME,LAST_NAME,TITLE,Start_Date from crashtest";
		// create statement
		Statement statement;
		List<Employee> list = new ArrayList<Employee>();
		Employee emp;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				;
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setTitle(rs.getString(4));
				emp.setStartDate(rs.getDate(5));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addEmployee(Employee emp) {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();

		// requete
		String sql = "INSERT INTO crashtest(FIRST_NAME,LAST_NAME,START_DATE,TITLE) VALUES(?,?,?,?)";
		// create statement
		PreparedStatement pstm;

		try {
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, emp.getFirstName());
			pstm.setString(2, emp.getLastName());
			pstm.setDate(3, emp.getStartDate());
			pstm.setString(4, emp.getTitle());

			pstm.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int AddEmployeeIdemp(Employee emp) {

		// Get Connection
		Connection connection = MysqlConnection.getConnection();

		// requete
		String sql = "INSERT INTO crashtest(FIRST_NAME,LAST_NAME,START_DATE,TITLE) VALUES(?,?,?,?)";
		// create statement
		PreparedStatement pstm;
		int id = 0;

		try {
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, emp.getFirstName());
			pstm.setString(2, emp.getLastName());
			pstm.setDate(3, emp.getStartDate());
			pstm.setString(4, emp.getTitle());

			pstm.executeUpdate();

			ResultSet rs = pstm.getGeneratedKeys();

			if (rs.next()) {

				id = rs.getInt(1);
			}

			connection.commit();

			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;

	}

	public void updateEmployee(Employee emp) {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();

		// requete
		String sql = "UPDATE crashtest SET START_DATE =?,FIRST_NAME = ?,LAST_NAME = ?,TITLE=? where emp_id = ?";

		// create statement
		PreparedStatement pstm;

		try {
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);

			pstm.setDate(1, emp.getStartDate());
			pstm.setString(2, emp.getFirstName());
			pstm.setString(3, emp.getLastName());
			pstm.setString(4, emp.getTitle());
			pstm.setInt(5, emp.getEmpId());
			pstm.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteEmployee(Employee emp) {
		// Get Connection
		Connection connection = MysqlConnection.getConnection();

		// requete
		String sql = "delete from crashtest where emp_id = ?";

		// create statement
		PreparedStatement pstm;

		try {
			connection.setAutoCommit(false);
			pstm = connection.prepareStatement(sql);

			pstm.setInt(1, emp.getEmpId());
			pstm.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteEmployees(List<Employee> emps) {
		for (Employee e : emps)
			deleteEmployee(e);

	}

}
