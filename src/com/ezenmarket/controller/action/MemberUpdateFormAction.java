package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;



public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/updateForm.jsp";
		String id = request.getParameter("id");  // id를 갖고 와야돼
		MemberDao mdao = MemberDao.getInstance();
		MemberVo mvo = mdao.getMember(id);
		String addr;
		
		addr = (String)mvo.getAddress();
		System.out.println(addr);					/* int k1 = mvo.getAddress().indexOf(" ") + 1; */
		int k1 = addr.indexOf(" ");  // 첫번째 공백의 위치 찾음
		int k2 = addr.indexOf(" ", k1+1);   // 첫번째 공백 위치의 다음 위치부터 두번째 공백 위치 찾음
		int k3 = addr.indexOf(" ", k2+1);   // 두번째 공백 위치 다음 위치부터 세번째 공백 위치 찾음
		// 서울시 마포구 대현동 115-15 세번째 공백 위치 k3 : 11(0부터 시작)
 		String addr1 = addr.substring(0, k3);  // 맨앞부터 세번째 공백 위치 바로 전까지... 주소 앞부분
		String addr2 = addr.substring(k3+1);  // 세번째 공백 뒷글자부터 맨끝까지... 주소 뒷부분
		
		request.setAttribute("member", mvo); 
		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
}
