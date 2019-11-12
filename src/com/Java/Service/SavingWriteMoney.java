package com.Java.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.savingDAO;
import com.VO.savingVO;
import com.mysql.fabric.Response;

public class SavingWriteMoney implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SavingWriteMoney 서비스 실행 카테고리별 입금 처리하는 메서드");
		String url = "saving.jsp";
		int cnt = 0;
		
		
		String no = request.getParameter("no");		
		String current_money = request.getParameter("current_amount");	
		
		System.out.println("SavingWriteMoney 서비스 실행 카테고리별 입금 처리하는 메서드 " +no+"  "+current_money );
		
		savingDAO dao = new savingDAO();

		cnt = dao.savingInputOneCheck(no, current_money);
		
		if(cnt == 0) {
			System.out.println("금액 초과!! SavingWriterMoney / Services");
			return url;
		} else {
			cnt = dao.savingInputOne(no, current_money);
		}

		return url;
	}

}
