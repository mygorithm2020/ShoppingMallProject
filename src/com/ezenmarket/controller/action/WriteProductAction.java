package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class WriteProductAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=mypage";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		
		if( id == null) { url = "market.do?command=index"; }
		else {
			ServletContext context = session.getServletContext();
			// 현재 서블릿의 경로 얻음
			String uploadFilePath = context.getRealPath("product/productimage");
			// 현재 서블릿의 절대경로 얻고 그 아래에 저장 폴더 "product_images" 생성 또는 유무 확인
			MultipartRequest multi = new MultipartRequest(
		    		request, // 1. 요청 객체
		            uploadFilePath, // 2. 업로드될 파일이 저장될 파일 경로명
		            10*1024*1024 , // 3. 업로드될 파일의 최대 크기(5Mb)
		            "UTF-8", // 4. 인코딩 타입 지정
		            new DefaultFileRenamePolicy() // 5. 동일 이름 파일 덮어쓰기를 방지 위한 부분. 동명 이름 변경
		    );
			
			
			
			ProductVo pvo = new ProductVo();
			pvo.setId(multi.getParameter("id"));
			System.out.println(multi.getParameter("id"));
			pvo.setTitle(multi.getParameter("name"));
			
			String kind=multi.getParameter("kind");
			System.out.println(kind);
			
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
	 		System.out.println(location);	
		    pvo.setLocationname(location);
		    pvo.setContent(multi.getParameter("content"));
		    pvo.setImg(multi.getFilesystemName("img"));
		    
		    ProductDao pdao = ProductDao.getInstance();
		    pdao.insertProduct(pvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	}


