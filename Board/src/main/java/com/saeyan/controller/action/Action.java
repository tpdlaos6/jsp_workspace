package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//추상메서드 선언. doGet() 메서드와 같은 역할을 하게 됨.
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
}
// 프로젝트 규모가 커질수록 여기 인터페이스 파일에 insert, delete 등등을 다 만들어 두는 게 나음.
// 그 뒤 인터페이스의 추상메서드로 이름이 적혀있으면, 전체적으로 이런 메서드들이 있구나라고 파악한 뒤,
// 상세한 코드는 상속받은 자식 파일로 들어가서 파악하는 게 훨씬 수월함
