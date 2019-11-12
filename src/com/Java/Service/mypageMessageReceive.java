package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.sharesavingDAO;

public class mypageMessageReceive implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypageMessage.jsp";
		
		String no = request.getParameter("no");
		String loginid = request.getParameter("loginid");
		String masterid = request.getParameter("masterid");
		String title = request.getParameter("title");
		String target_amount = request.getParameter("target_amount");
		System.out.println("mypageMessageReceive 실행");
		System.out.println("no "+no);
		System.out.println("loginid "+loginid);
		System.out.println("title " +title);
		System.out.println("target_amount " +target_amount);
		
		sharesavingDAO dao = new sharesavingDAO();
		
		dao.sharesavingWriteReceiveMember(no,masterid,loginid,title,target_amount);
		
		
		return url;
	}

}
