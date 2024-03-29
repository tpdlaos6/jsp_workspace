package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		HttpSession session=request.getSession(); //session객체구하기
		if(session.getAttribute("loginUser")!=null) {//로그인상태이면
			url="main.jsp"; //main페이지로 이동
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		MemberDAO mDao=MemberDAO.getInstance();
		int result=mDao.userCheck(userid, pwd);
		if(result==1) {//pwd가 일치할 때
			MemberVO mVo=mDao.getMember(userid);
			HttpSession session=request.getSession(); //session구하기
			session.setAttribute("loginUser", mVo); // session attribute에 vo를 저장.
			url="main.jsp"; //main페이지로 이동
		}else if(result==0) {//pwd가 일치하지 않을 때
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");			
		}else if(result==-1) {//userid가 없을 때
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
