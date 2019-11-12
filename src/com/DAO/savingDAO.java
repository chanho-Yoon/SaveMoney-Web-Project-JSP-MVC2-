package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.VO.savememberVO;
import com.VO.savingVO;

public class savingDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	String url = "jdbc:mysql://localhost:3306/db";
	String driver = "com.mysql.jdbc.Driver";
	String dbid = "chanho";
	String dbpw = "1234";
	String sql = null;
	ResultSet rs = null;
	int cnt;

	public savingDAO() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 새로운 저축 카테고리 생성 메서드
	public int inputNew(String id, String title, int money) {
		int cnt = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "INSERT INTO saving(id,title,current_amount,target_amount,time) values(?,?,?,?,now())";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, title);
			pst.setInt(3, 0);
			pst.setInt(4, money);

			cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("입력성공!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 로그인 한 회원의 saving 테이블 보여주기
	public ArrayList<savingVO> selectMember(String id) {

		ArrayList<savingVO> vos = new ArrayList<savingVO>();

		int cnt = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			
			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM saving WHERE id = ?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				savingVO vo = new savingVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6),rs.getString(7));
				vos.add(vo);
				cnt = 1;
			}

			if (cnt > 0) {
				System.out.println("입력성공!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vos;
	}

	// 선택한 카테고리에 돈 입금 하는 메서드
	public int savingInputOne(String no, String money) {
		int cnt = 0;
		String tmpmoney = null;
		
		cnt = savingInputOneCheck(no, money);  //목표금액보다 돈이 더 들어가느지 확인하는 메서드
		tmpmoney = Integer.toString(cnt);
		if (cnt == 0) {
			System.out.println("목표금액 초과!!");
			return cnt;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("savingInputOne db 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "UPDATE saving SET current_amount=? WHERE no = ?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, tmpmoney);
			pst.setString(2, no);

			cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("돈 추가 성공!!");
			} else {
				System.out.println("돈 추가 실패!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 돈 입금할때 목표금액 초과하지 않게 확인하는 메서드
	public int savingInputOneCheck(String no, String money) {
		int cnt = 0;
		int tmoney = 0;
		int maxMoney = 0; // 목표금액을 초과하는지 안하는지 확인
		int minMoney = 0;
		String tmpminMoney = null;
		String tmpmaxMoney = null;
		tmoney = Integer.parseInt(money);
		System.out.println("tmoney " + tmoney);

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("savinginputMoneyCheck 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT current_amount, target_amount FROM saving WHERE no=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, no);

			rs = pst.executeQuery();
			while (rs.next()) {
				tmpminMoney = rs.getString(1);
				tmpmaxMoney = rs.getString(2);
			}
			minMoney = Integer.parseInt(tmpminMoney);
			maxMoney = Integer.parseInt(tmpmaxMoney);

			System.out.println("minMoney + tmoney : " + (minMoney+tmoney));

			if (maxMoney < minMoney + tmoney) {
				System.out.println("입력한 금액이 목표한 금액을 초과합니다.");
				return cnt;
			} else if(maxMoney == minMoney+tmoney) {
				System.out.println("목표금액 달성, 완료날짜 추가");
				sql = "UPDATE saving SET comtime=now() WHERE no=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, no);
				pst.executeUpdate();
				cnt = tmoney+minMoney;
			} else {
				cnt = tmoney+minMoney;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}
	//개인저축현황 삭제 메서드
	public int DeleteSavingOne (String no) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("savinginputMoneyCheck 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "DELETE FROM saving WHERE no = ?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, no);

			cnt = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cnt;
	}
}
