package com.ezen.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.market.dto.LocationVo;
import com.ezen.market.dto.MemberVo;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.RentVo;
import com.ezen.market.dto.RentcartVo;
import com.ezen.market.service.ProductSer;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@Controller
public class ProductCon {
	
	@Autowired
	ProductSer ps;
	
	@RequestMapping(value="product_search_list")
	public String product_search_list(Model model, HttpServletRequest request) {		
		String url = "product/productList";
		
		String pname = request.getParameter("product");
		String gu = request.getParameter("gu");		
		ArrayList<ProductVo> productSearchList = ps.productSearchList(pname,gu);
		model.addAttribute("productSearchList",productSearchList);
		model.addAttribute("pname", pname);		
		System.out.print(productSearchList);
		return url;
	}
	
	@RequestMapping(value="product_update")
	public String product_update(Model model, HttpServletRequest request) {		
		String url = "redirect:/mypage";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		
		if( id == null) { url = "index"; }
		else {
			ServletContext context = session.getServletContext();
			// 현재 서블릿의 경로 얻음
			String uploadFilePath = context.getRealPath("product/productimage");
			// 현재 서블릿의 절대경로 얻고 그 아래에 저장 폴더 "product_images" 생성 또는 유무 확인
			try {
				MultipartRequest multi = new MultipartRequest(
						request, // 1. 요청 객체
				        uploadFilePath, // 2. 업로드될 파일이 저장될 파일 경로명
				        10*1024*1024 , // 3. 업로드될 파일의 최대 크기(5Mb)
				        "UTF-8", // 4. 인코딩 타입 지정
				        new DefaultFileRenamePolicy() // 5. 동일 이름 파일 덮어쓰기를 방지 위한 부분. 동명 이름 변경
				);
				ProductVo pvo = new ProductVo();
				pvo.setId(multi.getParameter("id"));				
				pvo.setTitle(multi.getParameter("name"));								
				pvo.setNum(Integer.parseInt(multi.getParameter("pseq")));
				String kind=multi.getParameter("kind");				
				
			    pvo.setCategory(Integer.parseInt(kind));
			    pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			    pvo.setTitle(multi.getParameter("title"));
			   	pvo.setName(multi.getParameter("pname"));	    
			    String addr = (String)multi.getParameter("location");
								/* int k1 = mvo.getAddress().indexOf(" ") + 1; */
				int k1 = addr.indexOf(" ");  // 첫번째 공백의 위치 찾음
				int k2 = addr.indexOf(" ", k1+1);   // 첫번째 공백 위치의 다음 위치부터 두번째 공백 위치 찾음
				int k3 = addr.indexOf("점", k2+1);   // 두번째 공백 위치 다음 위치부터 "점"의 위치 찾음
				// 서울시 마포구 대현동 115-15 세번째 공백 위치 k3 : 11(0부터 시작)
		 		String location = addr.substring(k2+1, k3);  // 맨앞부터 세번째 공백 위치 바로 전까지... 주소 앞부분		 		
			    pvo.setLocationname(location);
			    pvo.setContent(multi.getParameter("content"));
			    pvo.setImg(multi.getFilesystemName("img"));			    
			    
			    ps.updateProduct(pvo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return url;
	}
	
	@RequestMapping(value="product_update_form")
	public String product_update_form(Model model, HttpServletRequest request) {		
		String url = "product/productUpdate.jsp";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		if( id == null) { url = "redirect:/login_form"; }
		else {
			String pseq=request.getParameter("pseq");						
			ProductVo pvo = ps.getProduct(pseq);
			ArrayList<LocationVo> locationList = ps.locationList();
			int index = pvo.getCategory();			
			String kindList[] = { "컴퓨터", "카메라", "음악악기", "스포츠", "도서", "육아", "의류잡화" ,"게임용품"};
			request.setAttribute("productVo", pvo);
		    request.setAttribute("kindList", kindList);
			request.setAttribute("kind", kindList[index]);
			request.setAttribute("locationList", locationList);			
		}
		
		return url;
	}
		
	@RequestMapping(value="product_detail")
	public String product_detail(Model model, HttpServletRequest request) {		
		String url="product/productDetail";
		String pseq = request.getParameter("pseq");
		/*ProductVo pvo2= new ProductVo();
		ProductDao pdao2 = ProductDao.getInstance();
		pvo2 = pdao2.addView(pseq);*/
		
		//ProductVo pvo = new ProductVo();
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");       
	    if (mvo == null) {
	    	url = "redirect:/login_form";
	    }else {
	    	ProductVo pvo = ps.getProduct(pseq);
			request.setAttribute("productVo", pvo);
					
			
			ArrayList<ProductVo> nlist = new ArrayList<ProductVo>();
			nlist = ps.listNewProduct();
			request.setAttribute("newProductList", nlist);
	    }
		System.out.print("여긴가?");
		return url;
	}
	
	@RequestMapping(value="rent_delete")
	public String rent_delete(Model model, HttpServletRequest request) {		
		String url = "mypage/rentList";			
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");       
	    if (mvo == null) {
	    	url = "redirect:/login_form";
	    }else{
	    	String[] num = request.getParameterValues("num");
			// 체크된 체크박스의 밸류들을 파라미터로 전달받음						
			for(String n : num) {				
				ps.deleteRent(Integer.parseInt(n));
			}   	    	
	    }		
		return url;		
	}
	
	@RequestMapping(value="rent_list")
	public String rent_list(Model model, HttpServletRequest request) {		
		String url = "mypage/rentList";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
			url = "redirect:/login_form";
	    }else {	    	
	    	ArrayList<RentVo> list = ps.rentList(mvo.getId()); 
			//아이디로 검색한 장바구니 물건들을 검색하여 리스트로 받음			
	    	model.addAttribute("rentList", list);				
	    }
		return url;		
	}
	
	@RequestMapping(value="mypage")
	public String mypage(Model model, HttpServletRequest request) {		
		String url = "mypage/uploadList";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
				url = "redirect:/login_form";
		}else {				
				ArrayList<ProductVo> list = ps.listProduct(mvo.getId()); 
				//아이디로 검색한 장바구니 물건들을 검색하여 리스트로 받음
				model.addAttribute("productList", list);						
		}
		return url;		
	}
	
	@RequestMapping(value="write_product")
	public String write_product(Model model, HttpServletRequest request) {		
		String url = "mypage";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");		
		if( id == null) { url = "redirect:/login_form"; }
		else {
			ServletContext context = session.getServletContext();
			// 현재 서블릿의 경로 얻음
			String uploadFilePath = context.getRealPath("resources/images/product");
			// 현재 서블릿의 절대경로 얻고 그 아래에 저장 폴더 "product_images" 생성 또는 유무 확인
			MultipartRequest multi;
			try {
				multi = new MultipartRequest(
						request, // 1. 요청 객체
				        uploadFilePath, // 2. 업로드될 파일이 저장될 파일 경로명
				        10*1024*1024 , // 3. 업로드될 파일의 최대 크기(5Mb)
				        "UTF-8", // 4. 인코딩 타입 지정
				        new DefaultFileRenamePolicy() // 5. 동일 이름 파일 덮어쓰기를 방지 위한 부분. 동명 이름 변경
				);
				ProductVo pvo = new ProductVo();
				pvo.setId(multi.getParameter("id"));			
				pvo.setTitle(multi.getParameter("name"));
				
				String kind=multi.getParameter("kind");			
				
			    pvo.setCategory(Integer.parseInt(kind));
			    pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			    pvo.setTitle(multi.getParameter("title"));
			   	pvo.setName(multi.getParameter("pname"));	    
			    String addr = (String)multi.getParameter("location");
								/* int k1 = mvo.getAddress().indexOf(" ") + 1; */
				int k1 = addr.indexOf(" ");  // 첫번째 공백의 위치 찾음
				int k2 = addr.indexOf(" ", k1+1);   // 첫번째 공백 위치의 다음 위치부터 두번째 공백 위치 찾음
				int k3 = addr.indexOf("점", k2+1);   // 두번째 공백 위치 다음 위치부터 "점"의 위치 찾음
				// 서울시 마포구 대현동 115-15 세번째 공백 위치 k3 : 11(0부터 시작)
		 		String location = addr.substring(k2+1, k3);  // 맨앞부터 세번째 공백 위치 바로 전까지... 주소 앞부분	 		
			    pvo.setLocationname(location);
			    pvo.setContent(multi.getParameter("content"));
			    pvo.setImg(multi.getFilesystemName("img"));
			    ps.insertProduct(pvo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    
		}		
		return url;		
	}
	
	@RequestMapping(value="write_product_form")
	public String write_product_form(Model model, HttpServletRequest request) {		
		String url = "product/productWrite";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");
		if( mvo == null) { url = "redirect:/login_form"; }
		else {
			String kindList[] = { "컴퓨터", "카메라", "음악악기", "스포츠", "도서", "육아", "의류잡화" ,"게임용품"};
			
			ArrayList<LocationVo> locationList = ps.locationList();
			model.addAttribute("locationList", locationList);
			model.addAttribute("kindList", kindList);
		}	
		
		return url;		
	}
	
	@RequestMapping(value="/")
	public String index(Model model, HttpServletRequest request) {		
		ArrayList<ProductVo> nlist = new ArrayList<ProductVo>();
		ArrayList<ProductVo> blist = new ArrayList<ProductVo>();			
		
		nlist = ps.listNewProduct();
		blist = ps.listBestProduct();		
		
		model.addAttribute("newProductList", nlist);
		model.addAttribute("bestProductList", blist);
				
		return "main";		
	}

}
