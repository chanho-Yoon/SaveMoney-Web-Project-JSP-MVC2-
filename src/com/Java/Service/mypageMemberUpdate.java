package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.savememberDAO;

public class mypageMemberUpdate implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "mypage.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String age = request.getParameter("age");
		
		savememberDAO dao = new savememberDAO();
		dao.mypageMemberUpdate(id, pw, age);
		return url;
	}

}
