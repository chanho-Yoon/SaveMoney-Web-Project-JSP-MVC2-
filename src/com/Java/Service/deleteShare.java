package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.sharesavingDAO;

public class deleteShare implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "saving.jsp";	
		String no = request.getParameter("no");	
		sharesavingDAO dao = new sharesavingDAO();		
		dao.deleteShare(no);		
		return url;
	}

}
