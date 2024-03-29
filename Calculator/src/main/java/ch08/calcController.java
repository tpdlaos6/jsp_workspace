package ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch07.Calculator;

/**
 * Servlet implementation class calcController
 */
@WebServlet("/calcControl")
public class calcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcController() {
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
		//view에서 전달된 데이터를 Model에 담는다.
		Calculator c=new Calculator();
		c.setN1(Integer.parseInt(request.getParameter("n1")));
		c.setN2(Integer.parseInt(request.getParameter("n2")));
		c.setOp(request.getParameter("op"));
		long result=c.calc();
		
		//result라는 attribute명으로 결과값을 Calculator.sjp 
		request.setAttribute("answer", result);
		getServletContext().getRequestDispatcher("/calcResult.jsp")
		.forward(request, response);
	}

}
