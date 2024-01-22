package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenmarket.dao.MemberDao;




public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/idcheck.jsp";
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		int message = mdao.confirmID(id);  // 이게 실행되서 그 값이 message에 와야돼
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);  // 그래서 최종적으로 값을 받으면 그걸  url로 보내니까 idcheck.jsp를 보여주는거
		
	}

}
