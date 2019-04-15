package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.beans.Employee;
import fr.formation.dao.EmployeeDao;
import fr.formation.dao.IEmployeeDao;

/**
 * Servlet implementation class FUpdateEmployee
 */
public class FUpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FUpdateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IEmployeeDao dao = new EmployeeDao();
		String i = request.getParameter("id");
		String fn = request.getParameter("first_name");
		String ln = request.getParameter("last_name");
		String t = request.getParameter("title");
		String sd = request.getParameter("start_Date");
		Employee emp = new Employee();
		Integer id = Integer.parseInt(i);

		try {

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf1.parse(sd);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

			emp.setEmpId(id);
			emp.setFirstName(fn);
			emp.setLastName(ln);
			emp.setTitle(t);
			emp.setStartDate(sqlStartDate);
			dao.updateEmployee(emp);
			response.sendRedirect("choix.html");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
