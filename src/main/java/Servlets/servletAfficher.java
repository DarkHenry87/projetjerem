package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.beans.Employee;
import fr.formation.dao.EmployeeDao;
import fr.formation.dao.IEmployeeDao;

/**
 * Servlet implementation class servletAfficher
 */
public class servletAfficher extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(servletAfficher.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletAfficher() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.isConnected(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int curentEmpId;

		IEmployeeDao dao = new EmployeeDao();

		List<Employee> listEmploye = null;
//		UserInfo user = (UserInfo) request.getAttribute("user");
		out.println("<html>");
		out.println("<style>\r\n" + "table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "}\r\n" + "</style>");
		out.println("<body>");
		out.print("<table>" + "<tr>" + "<td>Emp id</td> " + "<td>First name</td> " + "<td>Last Name</td>"
				+ "<td>Title</td>" + "<td>Start Date</td>" + "<td>Delete</td>" + "<td>Update</td>" + " </tr>");
		listEmploye = dao.getAll();
		for (Employee emp : listEmploye) {

			out.println("<tr>");
			out.print("<td>" + emp.getEmpId() + "</td>");
			out.print("<td>" + emp.getFirstName() + "</td>");
			out.print("<td>" + emp.getLastName() + "</td>");
			out.print("<td>" + emp.getTitle() + "</td>");
			out.print("<td>" + emp.getStartDate() + "</td>");
			curentEmpId = emp.getEmpId();
			out.print("<td> <form action='DeleteEmployee' method='post'> <input type='hidden' name='id'	 value ="
					+ curentEmpId + ">");
			out.print("<input type='submit' value ='Delete'></form> </td>");

			out.print("<td> <form action='UpdateEmployee' method='post'><input type='hidden' name='id'	 value ="
					+ curentEmpId + ">");
			out.print("<input type='submit' value ='Update'></form> </td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.print("<br>");
		out.println("<br/><form action=\"choix.html\" method=\"post\">\r\n"
				+ "		<input type=\"submit\" value=\"Retour\">\r\n" + "	</form>");
		out.print("<br>");
		out.print("<form action =\"/ProjectWebMaven\" method=\"post\">\r\n"
				+ "		<input type=\"submit\" value =\"Se Deconnecter\">\r\n" + "	</form>");
//		out.print("Bienvenue " + user);
		out.println("</body>");
		out.println("</html>");

	}
}
