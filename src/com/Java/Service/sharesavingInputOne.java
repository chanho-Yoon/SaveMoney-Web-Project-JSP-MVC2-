package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.sharesavingDAO;

public class sharesavingInputOne implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cnt = 0;
		String no = request.getParameter("no");
		String shareno = request.getParameter("shareno");
		String money = request.getParameter("current_amount");
		String url ="sharesavingList.jsp?no="+shareno;
		
		sharesavingDAO dao = new sharesavingDAO();
		
		cnt = dao.sharesavingInputOne(no, money);
		
		if(cnt > 0) 
			System.out.println("돈 입금하는 sharesavingInputOne DAO() 성공");
		else 
			System.out.println("돈 입금하는 sharesavingInputOne DAO() 실패 ㅠㅠ");
		
		return url;
	}
	

}
