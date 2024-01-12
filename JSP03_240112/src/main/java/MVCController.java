

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MVCController
 */
@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MVCController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MVC m=new MVC();
		m.setFname(request.getParameter("firstname"));
		m.setLname(request.getParameter("lastname"));
		m.setCountry(request.getParameter("country"));
		m.setSubjcet(request.getParameter("subject"));
		
		request.setAttribute("fnameResult", m.getFname());
		request.setAttribute("lnameResult", m.getLname());
		request.setAttribute("countryResult", m.getCountry());
		request.setAttribute("subjectResult", m.getSubjcet());
		
		getServletContext().getRequestDispatcher("/MVCResult.jsp").forward(request, response);
		
	}

}
