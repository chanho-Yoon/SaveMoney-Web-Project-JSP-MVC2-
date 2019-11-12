package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.savememberDAO;
import com.VO.savememberVO;

public class LoginService implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
				
		savememberDAO dao = new savememberDAO();		
		savememberVO vo = new savememberVO(id,pw);
		
		vo = dao.Login(vo);
		
		if(vo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			
		}		
		return "index.jsp";
	}

}
