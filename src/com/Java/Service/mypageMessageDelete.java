package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.messageDAO;

public class mypageMessageDelete implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypageMessage.jsp";
		
		String no = request.getParameter("no"); //mypageMessage.jsp에서 받아옴
		
		messageDAO dao = new messageDAO();
		
		dao.messageDelete(no);
		
		
		return url;
	}

}
