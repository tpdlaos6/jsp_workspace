package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter(); // 출력 객체
		out.append("<!doctype html>");
		out.append("<html>");
		out.append("	<head>");
		out.append("		<title>Hello World Servlet</title>");
		out.append("	</head>");
		out.append("	<body>");
		out.append("		<h1>hello world - 안녕하세요?</h1>");
		out.append("	</body>");
		out.append("</html>");
		
//		out.println("<!doctype html>");
//		out.println("<html>");
//		out.println("	<head>");
//		out.println("		<title>Hello World Servlet</title>");
//		out.println("	</head>");
//		out.println("	<body>");
//		out.println("		<h1>hello world - 안녕하세요?</h1>");
//		out.println("	</body>");
//		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
