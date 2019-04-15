package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.beans.Employee;
import fr.formation.dao.EmployeeDao;
import fr.formation.dao.IEmployeeDao;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
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
		PrintWriter out = response.getWriter();
		String p = request.getParameter("id");
		int empid = Integer.parseInt(p);

		Employee emp = dao.getById(empid);
		out.print("<table>");
		out.println("<td><form action='FUpdateEmployee' method='post'><input type='hidden' name='id'	 value ="
				+ emp.getEmpId() + " >");
		out.print("<tr>" + "<td>First Name</td>" + "<td>" + "<input name='first_name' type=text value="
				+ emp.getFirstName() + "></td>" + "</tr>");
		out.print("<tr>" + "<td>Last Name</td>" + "<td><input name='last_name' type=texte value=" + emp.getLastName()
				+ "></td>" + "</tr>");
		out.print("<tr>" + "<td>Title</td>" + "<td><input name='title' type=texte value=" + emp.getTitle() + "></td>"
				+ "</tr>");
		out.print("<tr>" + "<td>Start Date</td>" + "<td><input name='start_Date' type=texte value=" + emp.getStartDate()
				+ "></td>" + "</tr>");
		out.print("</table>");
		out.println("<input type='submit' value='Update'> </form></td>");

	}

}
