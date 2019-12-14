package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Java.Service.DeleteSavingOne;
import com.Java.Service.JoinService;
import com.Java.Service.LoginService;
import com.Java.Service.LogoutService;
import com.Java.Service.SavingWriteMoney;
import com.Java.Service.SavingWriteService;
import com.Java.Service.deleteShare;
import com.Java.Service.mypageCreateShare;
import com.Java.Service.mypageDeleteSavingOne;
import com.Java.Service.mypageDeleteShare;
import com.Java.Service.mypageMemberUpdate;
import com.Java.Service.mypageMessageDelete;
import com.Java.Service.mypageMessageReceive;
import com.Java.Service.mypageSendMessage;
import com.Java.Service.sharesavingInputOne;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("FrontController 호출");

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		System.out.println("uri : " + uri);
		System.out.println("path : " + path);
		
		uri = uri.substring(path.length() + 1);
		
		System.out.println("last path : " + uri);
		String command = uri;
		String nextPage = "";
		
		// --------------------------------로그인-------------------------------------------
		if (command.equals("Login.do")) {

			System.out.println("로그인 컨트롤로 실행");
			LoginService login = new LoginService();
			nextPage = login.execute(request, response);
		}

		// ---------------------------------회원가입-----------------------------------------
		else if (command.equals("Join.do")) {

			JoinService join = new JoinService();
			nextPage = join.execute(request, response);
		}

		// ---------------------------------로그아웃-----------------------------------------
		else if (command.equals("Logout.do")) {

			LogoutService logout = new LogoutService();
			nextPage = logout.execute(request, response);

		}
		// -------------------------------saving 개인 등록-----------------------------------
		else if (command.equals("SavingWrite.do")) {
			SavingWriteService write = new SavingWriteService();
			nextPage = write.execute(request, response);
		}
		// ------------------------------saving 개인 돈 저금----------------------------------
		else if(command.equals("SavingWriteOne.do")) {
			
			SavingWriteMoney moneyInput = new SavingWriteMoney();
			nextPage = moneyInput.execute(request, response);
		}
		
		// ------------------------------saving 개인 카테고리 삭제------------------------------
		else if(command.equals("DeleteSavingOne.do")) {
			DeleteSavingOne delete = new DeleteSavingOne();
			nextPage = delete.execute(request, response);
		}
		// ------------------------------mypage 개인저축현황에서 완료 목록 삭제 ----------------------------
		else if(command.equals("mypageDeleteSavingOne.do")) {
			mypageDeleteSavingOne delete = new mypageDeleteSavingOne();
			nextPage = delete.execute(request, response);
		}
		//-------------------------------회원정보수정--------------------------------------
		else if(command.equals("mypageMemberUpdate.do")) {
			mypageMemberUpdate update = new mypageMemberUpdate();
			nextPage = update.execute(request, response);
		}
		//------------------------------mypage 에서 공동저축 만들기 -------------------------------
		else if(command.equals("mypageCreateShare.do")) {
			mypageCreateShare create = new mypageCreateShare();
			nextPage = create.execute(request, response);
		}
		//-------------------------------mypage 내가만든 공동저축 관리에서 게시글 삭제---------------------
		else if(command.equals("mypageDeleteShare.do")) {
			mypageDeleteShare delete = new mypageDeleteShare();
			nextPage = delete.execute(request, response);
			
		//-------------------------------mypage에서 메시지 보내기-----------------------------------------
		} else if(command.equals("mypageSendMessage.do")) {
			mypageSendMessage sendmessage = new mypageSendMessage();
			nextPage = sendmessage.execute(request, response);
			
		//------------------------------mypage에서 받은 초대 수락---------------------------------------
		} else if(command.equals("mypageMessageReceive.do")) {
			mypageMessageReceive messageAccept = new mypageMessageReceive();
			nextPage = messageAccept.execute(request, response);
			
		//-----------------------------mypage에서 받은 초대 삭제------------------------------------------
		} else if(command.equals("mypageMessageDelete.do")) {
			mypageMessageDelete messageDelete = new mypageMessageDelete();
			nextPage = messageDelete.execute(request,response);
			
		//----------sharesavingList(공동목표) 게시판에서 로그인한 사용자 게시글 삭제-------------------------
		} else if(command.equals("deleteShare.do")) {
			deleteShare delete = new deleteShare();
			nextPage = delete.execute(request, response);
			
		//---------------sharesavingList(공동목표) 게시판에 로그인한 사용자 게시글 돈 입금-----------------
		} else if(command.equals("sharesavingInputOne.do")) {
			sharesavingInputOne input = new sharesavingInputOne();
			nextPage = input.execute(request, response);
		}
			
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}
}
