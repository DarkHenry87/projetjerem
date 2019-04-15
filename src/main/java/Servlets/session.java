package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class session
 */
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(session.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public session() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
//		UserInfo user = new UserInfo();

		if (login.equals("root") && pass.equals("123456")) {

			session.setAttribute("login", login);
			log.info("Connection réussite");
			String logi = (String) session.getAttribute("login");			
			response.sendRedirect("choix.html");
			isConnected(request, response);
		}

		else {

			response.sendRedirect("afficherTable.html");

		}

	}
	public static void isConnected(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login,pwd;
        if(session != null) {
            login = (String) session.getAttribute("login");
            pwd = (String) session.getAttribute("pwd");

            if (!"root".equals(login)) 
                request.getRequestDispatcher("/afficherTable.html").forward(request, response);
        }

    }

}
