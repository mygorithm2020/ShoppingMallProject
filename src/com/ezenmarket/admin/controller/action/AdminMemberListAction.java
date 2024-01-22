package com.ezenmarket.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.controller.action.Action;
import com.ezenmarket.dao.AdminDao;
import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.Paging;



public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/memberList.jsp";
		HttpSession session = request.getSession();		
		
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if (mvo == null) {url = "market.do?command=login_form"; }
		else {
			int page=1;	
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			MemberDao mdao = MemberDao.getInstance();
			AdminDao adao = AdminDao.getInstance();
			String key = request.getParameter("key");
		    int count = adao.getAllCount(key);
		    Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(count);
			ArrayList<MemberVo> memberList = adao.listMember(paging, key);
			request.setAttribute("memberList", memberList);
			request.setAttribute("paging", paging);
			 
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}







