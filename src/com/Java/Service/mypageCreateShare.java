package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.sharesavingDAO;
import com.VO.sharesavingVO;

public class mypageCreateShare implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypageCreateShare.jsp";
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String tmpamount = request.getParameter("target_amount");
		int target_amount = Integer.parseInt(tmpamount);
		
		System.out.println(id + title + tmpamount);
		sharesavingDAO dao = new sharesavingDAO();
		// 공동목록 작성자는 작성과 동시에 공동목록멤버에 들어갈 수 있게 sharesaving no를 가져와야함
		//int no = dao.sharesavingSearchNo(title);
		
		//System.out.println("mypageCreateShare 서비스에서 no 값 : " + no);

		
		sharesavingVO vo = new sharesavingVO(id,title,target_amount);
		System.out.println("mypageCreateShare 서비스에서 vo.no 값 : " + vo.getNo());
		

		dao.sharesavingWrite(vo, title);
		
		
		
		//로직 잘못짬 테이블 먼저 생성하고 sharesavingSearchNo를 했어야함
		
		return url;
	}

}
