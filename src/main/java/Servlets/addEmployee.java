package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addEmployee
 */
public class addEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addEmployee() {
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
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		out.println("<p> Merci de remplir les informations du nouvel employée </p>");

		out.print("<table>");
		out.println("<td><form action='inscription' method='post'>");
		out.print("<tr>" + "<td>First Name </td>" + "<td>" + "<input name='first_name' type=text></td>" + "</tr>");
		out.print("<tr>" + "<td>Last Name </td>" + "<td><input name='last_name' type=texte ></td>" + "</tr>");
		out.print("<tr>" + "<td>Title </td>" + "<td><input name='title' type=texte </tr>");
		out.print("<tr>" + "<td>Start Date </td>" + "<td><input name='start_Date' type=texte v></td>" + "</tr>");
		out.print("</table>");
		out.println("<br>");
		
		out.println("<input type='submit' value='Inscription'> </form></td>");
		out.print("<p></p>");
		out.println("<br/><form action=\"choix.html\" method=\"post\">\r\n" + 
				"		<input type=\"submit\" value=\"Retour\">\r\n" + 
				"	</form>");
		out.print("<br/> <form action=\"/ProjectWebMaven\" method=\"post\">\r\n"
				+ "		<input type=\"submit\" value=\"Se Deconnecter\">\r\n" + "</form>");

		out.println("</body>");
		out.println("</html>");
		doGet(request, response);
	}

}
