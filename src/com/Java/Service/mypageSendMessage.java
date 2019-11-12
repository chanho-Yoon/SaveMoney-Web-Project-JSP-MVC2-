package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.messageDAO;
import com.VO.savememberVO;

public class mypageSendMessage implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cnt = 0;
		String url = "mypageMyCreateShareList.jsp";
		HttpSession session = request.getSession();	
		System.out.println("mypageSendMessage 서비스 실행");
		savememberVO vo = (savememberVO) session.getAttribute("vo");
		
		
		String shareno = request.getParameter("no"); //해당하는 게시글의 초대 sharno을 가져옴 보내줄 때 같이 보내줌
		String sendid = vo.getId();
		String receiveid = request.getParameter("id");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String target_amount = request.getParameter("target_amount");
		
		messageDAO dao = new messageDAO();
		cnt = dao.sendMessage(shareno, sendid, receiveid, content, title, target_amount);
		if(cnt > 0) {
			System.out.println("message 보내기 성공!! 쉬바!!");
		} else
			System.out.println("message 보내기 실패!! ㅠㅠ");
		
		return url;
	}

}
