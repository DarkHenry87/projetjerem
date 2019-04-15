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
 * Servlet implementation class TestServletBase
 */
public class TestServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(TestServletBase.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		  super.init(config);
		 
		}
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("fn");
//		int result = Integer.parseInt(first_name);
		
		log.info(first_name);
		IEmployeeDao dao = new EmployeeDao();
		
		
		List<Employee> listEmploye = null;
//		Employee emp = dao.getById(result);
//		out.println(emp);
		out.println("<html>");
		out.println("<body>");
			try {
				listEmploye = dao.getByName(first_name);
				for(Employee emp : listEmploye) {
					
					out.println("<p>"+emp+"</p>");
//					log.info(emp);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			out.println("</body>");
			out.println("</html>");
		
	}

}
