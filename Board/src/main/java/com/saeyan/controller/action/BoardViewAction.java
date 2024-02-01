package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상세보기
		String url="/board/boardView.jsp";
		String num=request.getParameter("num");
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.updateReadCount(num);//조회수증가
		BoardVO bVo=bDao.selectOneBoardByNum(num); //글상세내용
		request.setAttribute("board", bVo); // board라는 이름으로 vo 전달
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
