package com.ezenmarket.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.controller.action.Action;
import com.ezenmarket.dao.AdminDao;
import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.Paging;
import com.ezenmarket.dto.QnaVo;


public class AdminQnaListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaList.jsp";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if( mvo == null) { url = "market.do?command=login_form"; }
		else {
			int page=1;	
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			Paging paging = new Paging();
			paging.setPage(page);			
			QnaDao qdao = QnaDao.getInstance();
			AdminDao adao = AdminDao.getInstance();
			int count = qdao.getAllcount();
			paging.setTotalCount(count);
			
			ArrayList<QnaVo> qnaList = adao.listAllQna(paging);
			request.setAttribute("qnaList", qnaList);
			request.setAttribute("paging", paging);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
