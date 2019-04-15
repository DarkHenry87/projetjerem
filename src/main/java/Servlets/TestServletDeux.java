package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class TestServletDeux
 */
@WebServlet("/t2")
public class TestServletDeux extends HttpServlet {

	private static final Log log = LogFactory.getLog(TestServletDeux.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServletDeux() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Méthode DoGet2");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Exemple de reponse get </h1>");
		out.println("</body>");
		out.println("</html>");
		log.info("Message doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String emailContact = this.getServletConfig().getInitParameter("emailContact");
		String pwdInit = this.getServletConfig().getInitParameter("pwd");
		
		out.println(pwdInit);

		out.println("<html>");
		out.println("<body>");
		if (login.equals("root") && pass.equals(pwdInit)) {
			out.println("<h1> Exemple de post " + login + " " + pass + "</h1>");
			out.println("<h1>" + emailContact + "  " + pwdInit  + "</h1>");
			log.info("succès");
		} else {
			log.info("erreur de login");
			response.sendRedirect("formulaire.html");
		}

		out.println("</body>");
		out.println("</html>");

	}

}
