package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.savingDAO;
import com.VO.savememberVO;
import com.VO.savingVO;

public class SavingWriteService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("  SavingWriteService 실행");
		//write.jsp에서 작성한 title , targer_amount(목표금액) 값 받기 
		String title = request.getParameter("title");
		String money = request.getParameter("target_amount");   //목표금액 받아오기
		String url = "saving.jsp";
		int target_money;
		//현재 로그인 중인 id값을 가져오기 위해 세션생성
		HttpSession session = request.getSession();
		savememberVO vo = (savememberVO)session.getAttribute("vo");  
		//db에 목표 (target_amonut) 값을 넣어주기 위해 정수형으로 변환해야함
		
		target_money = Integer.parseInt(money);
		
		//입력 받은 값을 디비에 넣어주기 위해 savingDAO 생성
		savingDAO dao = new savingDAO();
		
		dao.inputNew(vo.getId(), title, target_money);
		
		
		return url;
	}

}
