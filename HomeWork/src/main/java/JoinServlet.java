

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/register")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		request.setCharacterEncoding("utf-8");// 폼에 입력된 한글 깨짐 방지
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String job=request.getParameter("job");
		String[] hobby=request.getParameterValues("hobby");
		String recep=request.getParameter("emailReception");
		String who=request.getParameter("who");
		
		
		  if(recep.equals("y")){
			  recep="메일을 받습니다.";
		  }else {
		      recep = "메일을 안받습니다.";
		   }

		
	  response.setContentType("text/html; charset=utf-8");
	  PrintWriter out = response.getWriter();
	  out.append("<html>");
	  out.append("	<head>");
	  out.append("		<title>회원정보</title>");
	  out.append("	</head>");
	  out.append("	<body>");
	  out.append(		"아이디 : "+id);
	  out.append(		"<br>");
	  out.append(		"비밀번호 : "+pw);
	  out.append(		"<br>");
	  out.append(		"이메일주소 : "+email);
	  out.append(		"<br>");
	  out.append(		"이름 : "+name);
	  out.append(		"<br>");
	  out.append(		"전화번호 : "+phone);
	  out.append(		"<br>");
	  out.append(		"직업 : "+job);
	  out.append(		"<br>");
	  out.append(		"취미 : "+hobby);
	  out.append(		"<br>");
	  out.append(		"이메일 발송 : "+recep);
	  out.append(		"<br>");
	  out.append(		"자기소개 : "+who);
	  out.append(		"<br>");
	  out.append("	</body>");
	  out.append("</html>");
	  
   }

}
