package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.savingDAO;

public class mypageDeleteSavingOne implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("DeleteSavingOne 서비스 실행");
		String url = "mypageSavingOne.jsp";
		int cnt=0;
		
		String no = (String)request.getParameter("no");
		System.out.println("num : " + no);
		savingDAO dao = new savingDAO();
		cnt = dao.DeleteSavingOne(no);
		
		if(cnt>0) {
			System.out.println("DeleteSavingOne 게시글 삭제 성공");
		} else {
			System.out.println("DeleteSavingOne 게시글 삭제 실패");
		}
		
		
		return url;
	}

}
