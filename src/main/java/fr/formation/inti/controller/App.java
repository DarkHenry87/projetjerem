package fr.formation.inti.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.beans.Employee;
import fr.formation.dao.EmployeeDao;
import fr.formation.dao.IEmployeeDao;

public class App {

	private static final Log log = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		
		IEmployeeDao dao = new EmployeeDao();
		
		
		List<Employee> listEmploye = null;
		try {
			listEmploye = dao.getByName("Olivier");
			for(Employee emp : listEmploye) {
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		List<Employee> listEmploye = dao.getAll();
//		for(Employee emp : listEmploye) {
//			log.info(emp);
//		}
//		System.out.println("==== getById ============================");
//		Employee emp = dao.getById(14);
//		log.info(emp);
//		
//		System.out.println("==== addEmployee ========================");
//		emp.setFirstName("Olivier"+emp.getEmpId());
//		emp.setLastName("Yahya"+emp.getEmpId());
//		
//		Employee emp2 = dao.getById(17);
//		emp2.setFirstName("Olivier");
//		
//		 int ip =dao.AddEmployeeIdemp(emp2);
//		 log.info(ip);
//		
//		listEmploye = dao.getAll();
//		for(Employee e : listEmploye) {
//			log.info(e);
//		}
//		System.out.println("==== updateEmployee ========================");
//		emp = dao.getById(23);
//		emp.setFirstName("Clementine");
//		emp.setLastName("Margaux");
//		
//		dao.updateEmployee(emp);
//		
//		listEmploye = dao.getAll();
//		for(Employee e : listEmploye) {
//			log.info(e);
//		}
//		
//		System.out.println("==== DeleteEmployee =========================");
//		Employee e2 = dao.getById(24);		
//		dao.deleteEmployee(e2);
//		listEmploye = dao.getAll();
//		for(Employee e : listEmploye) {
//			log.info(e);
//		}
//		System.out.println("==== DeleteEmployees =======================");
//		Employee e3 = dao.getById(26);
//		Employee e4 = dao.getById(23);
//		List<Employee> emps = new ArrayList<Employee>();
//		emps.add(e3);
//		emps.add(e4);
//		dao.deleteEmployees(emps);
//		listEmploye = dao.getAll();
//		for(Employee e : listEmploye) {
//			log.info(e);
//		}
	}

}
