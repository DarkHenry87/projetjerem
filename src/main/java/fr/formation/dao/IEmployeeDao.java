package fr.formation.dao;

import java.sql.SQLException;
import java.util.List;

import fr.formation.beans.Employee;

public interface IEmployeeDao {
	// Lecture
	public Employee getById(Integer id);

	public List<Employee> getByName(String firstName) throws SQLException;

	public List<Employee> getAll();

	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);

	public void deleteEmployees(List<Employee> emps);

	public int AddEmployeeIdemp(Employee emp);

}
