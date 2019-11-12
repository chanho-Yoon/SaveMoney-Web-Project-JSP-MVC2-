package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.Command.Command;
import com.DAO.savememberDAO;
import com.VO.savememberVO;

public class JoinService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cnt; // Join 성공 실패여부 판단 할 변수
		// Join할 객체를 디비 보내주기 위해 DAO 객체 생성
		savememberDAO dao = new savememberDAO();
		
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		String gender = (String) request.getParameter("gender");
		String age = (String) request.getParameter("age");

		String nextPage = "index.jsp";

		// Join할 객체를 만듬
		savememberVO vo = new savememberVO(id, pw, gender, age);

		// 중복된 ID 있는지 확인 
		cnt = dao.checkId(id);

		if (cnt == 1) {
			System.out.println("회원가입 실패 service");
		} else if(cnt == 0) {
			dao.Join(vo);
			System.out.println("회원가입 성공 service");
		}
		return nextPage;
	}

}
