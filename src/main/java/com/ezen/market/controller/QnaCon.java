package com.ezen.market.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.market.dto.MemberVo;
import com.ezen.market.dto.QnaVo;
import com.ezen.market.service.QnaSer;

@Controller
public class QnaCon {
	
	@Autowired
	QnaSer qs;
	
	@RequestMapping(value="qna_delete")
	public String qna_delete(Model model, HttpServletRequest request) {		
		String url = "redirect:/qna_my_list";
		Integer num = Integer.parseInt(request.getParameter("num") ) ;		
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");       
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    }else{	    		    	    	
	    	qs.deleteQna(num);
	    }
	    return url;
	}
	
	@RequestMapping(value="qna_update")
	public String qna_update(Model model, HttpServletRequest request) {		
		String url = "redirect:/qna_my_list";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    }else{
	    	QnaVo qvo = new QnaVo();
	    	qvo.setNum(Integer.parseInt(request.getParameter("num")));
	    	qvo.setTitle(request.getParameter("title"));
	    	qvo.setContent(request.getParameter("content"));	    	
	    	qs.updateQna(qvo);
	    }	   
	    return url;
	}
	
	@RequestMapping(value="qna_update_form")
	public String qna_update_form(Model model, HttpServletRequest request) {		
		String url = "qna/qnaUpdate";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");    
	    Integer num = Integer.parseInt(request.getParameter("num") ) ;	   
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    }else{    	  	
	    	QnaVo qvo = qs.getQna(num);
	    	model.addAttribute("qnaUpdate", qvo);
	    }
	   
	    return url;
	}
	
	@RequestMapping(value="qna_view")
	public String qna_view(Model model, HttpServletRequest request) {		
		String url = "qna/qnaView";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    } else {
	    	int num = Integer.parseInt(request.getParameter("num"));	    	
	    	QnaVo qvo = qs.getQna(num);
	    	model.addAttribute("qnaVO", qvo);
	    }
	    return url;
	}
	
	@RequestMapping(value="qna_my_list")
	public String qna_my_list(Model model, HttpServletRequest request) {		
		String url = "qna/qnaMyList";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    } else {	    	
	    	ArrayList<QnaVo> list = qs.myList(mvo.getId());	    	
	    	model.addAttribute("myqnaList", list);
	    }
	    
	
	    return url;
	}
	
	@RequestMapping(value="qna_write")
	public String qna_write(Model model, HttpServletRequest request) {		
		String url = "redirect:/qna_my_list";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");    
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    }else{
	    	QnaVo qvo = new QnaVo();
	    	qvo.setTitle(request.getParameter("title"));
	    	qvo.setContent(request.getParameter("content"));	    	
	    	qs.insertQna(qvo, mvo.getId());
	    }
	    return url;
	}
	
	@RequestMapping(value="qna_write_form")
	public String qna_write_form(Model model, HttpServletRequest request) {		
		String url = "qna/qnaWrite";
		HttpSession session = request.getSession();
	    MemberVo mvo= (MemberVo) session.getAttribute("loginUser"); 
	    if (mvo == null)  	url ="redirect:/login_form";
	    return url;
	}
	
	@RequestMapping(value="qna_list")
	public String qna_list(Model model, HttpServletRequest request) {		
		String url = "qna/qnaList";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url ="redirect:/login_form";
	    } else {	    	
	    	ArrayList<QnaVo> list = qs.listQna(mvo.getId());
	    	model.addAttribute("qnaList", list);
	    }
	    return url;
	}

}
