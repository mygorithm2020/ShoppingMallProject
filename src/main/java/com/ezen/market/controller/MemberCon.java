package com.ezen.market.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.market.dto.MemberVo;
import com.ezen.market.service.MemberSer;

@Controller
public class MemberCon {
	
	@Autowired
	MemberSer ms;
	
	@RequestMapping(value="Member_Update")
	public String Member_Update(Model model, HttpServletRequest request) {		
		String url = "redirect:/";
		MemberVo mvo = new MemberVo();
		mvo.setId(request.getParameter("id"));
		mvo.setPw(request.getParameter("pw"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZipcode(request.getParameter("zipcode"));
		mvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setGender(request.getParameter("gender"));		
		
		mvo.setBirth(Integer.parseInt(request.getParameter("birth")));	
		ms.updateMember(mvo);
		
		return url;
	}
	
	@RequestMapping(value="Member_Delete")
	public String Member_Delete(Model model, HttpServletRequest request) {		
		String url="redirect:/";
		HttpSession session = request.getSession();			
		String id2 =request.getParameter("loginid") ;
		MemberVo id = (MemberVo)session.getAttribute("loginUser");		
		if( id == null) { url = "redirect:/login_form";}
		else {		
			ms.deleteMember(id2);			
		}
		
		if(session!=null) session.invalidate();
		return url;
	}
	
	@RequestMapping(value="Member_Delete_Form")
	public String Member_Delete_Form(Model model, HttpServletRequest request) {		
		String url="member/delete";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");       
	    if (mvo == null) {
	    	url = "redirect:/login_form";
	    }    	
	    	
		return url;
	}
	
	@RequestMapping(value="Member_Update_Form")
	public String Member_Update_Form(Model model, HttpServletRequest request) {	
		String url="member/updateForm";
		String id = request.getParameter("id");  // id를 갖고 와야돼
		MemberVo mvo = ms.getMember(id);
		String addr;
		
		addr = (String)mvo.getAddress();
		System.out.println(addr);					/* int k1 = mvo.getAddress().indexOf(" ") + 1; */
		int k1 = addr.indexOf(" ");  // 첫번째 공백의 위치 찾음
		int k2 = addr.indexOf(" ", k1+1);   // 첫번째 공백 위치의 다음 위치부터 두번째 공백 위치 찾음
		int k3 = addr.indexOf(" ", k2+1);   // 두번째 공백 위치 다음 위치부터 세번째 공백 위치 찾음
		// 서울시 마포구 대현동 115-15 세번째 공백 위치 k3 : 11(0부터 시작)
 		String addr1 = addr.substring(0, k3);  // 맨앞부터 세번째 공백 위치 바로 전까지... 주소 앞부분
		String addr2 = addr.substring(k3+1);  // 세번째 공백 뒷글자부터 맨끝까지... 주소 뒷부분
		
		model.addAttribute("member", mvo); 
		model.addAttribute("addr1", addr1);
		model.addAttribute("addr2", addr2);
		
		return url;		
	}
	
	@RequestMapping(value="logout")
	public String logout(Model model, HttpServletRequest request) {	
		String url = "redirect:/";		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return url;		
	}
	
	@RequestMapping(value="Id_Check_Form")
	public String Id_Check_Form(Model model, HttpServletRequest request) {
		
		String url="member/idcheck";
		String id = request.getParameter("id");
		
		int message = ms.confirmID(id);  // 이게 실행되서 그 값이 message에 와야돼
		model.addAttribute("message", message);
		model.addAttribute("id", id);		
		
		return url;		
	}
	
	@RequestMapping(value="join")
	public String join(Model model, HttpServletRequest request) {
		String url="member/login";
		MemberVo mvo = new MemberVo();
		mvo.setId(request.getParameter("id"));
		mvo.setPw(request.getParameter("pw"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZipcode(request.getParameter("zipcode"));
		mvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setGender(request.getParameter("gender"));
		
		String birth=request.getParameter("year")+request.getParameter("month")+request.getParameter("day");		
		mvo.setBirth(Integer.parseInt(birth));		
		ms.insertMember(mvo);			
		
		return url;		
	}
	
	@RequestMapping(value="join_form")
	public String join_form(Model model, HttpServletRequest request) {	
		String url = "member/join";		
		
		return url;		
	}
	
	@RequestMapping(value="contract")
	public String contract(Model model, HttpServletRequest request) {		
		String url = "member/contract";		
		
		return url;		
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		
		String url = "member/login";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");		
			
		MemberVo mvo = ms.getMember(id);
		HttpSession session = request.getSession();
		if(mvo != null) {
			if(mvo.getPw().equals(pw)) {
				//session.removeAttribute("id");				
				url="redirect:/";
				session.setAttribute("loginUser", mvo);
				if(mvo.getAdmin()==1) {
					url="redirect:/admin";					
				}
			}
		}
		
		return url;		
	}
	
	@RequestMapping(value="login_form")
	public String login_form(Model model, HttpServletRequest request) {
		
		return "member/login";		
	}

}
