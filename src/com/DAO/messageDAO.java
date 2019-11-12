package com.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.messageVO;

public class messageDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	String url = "jdbc:mysql://localhost:3306/db";
	String driver = "com.mysql.jdbc.Driver";
	String dbid = "chanho";
	String dbpw = "1234";
	String sql = null;
	ResultSet rs = null;
	int cnt;

	public messageDAO() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메시지 보내는 메서드
	public int sendMessage(String shareno, String sendid, String receiveid, String content, String title,
			String target_amount) {
		int cnt = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "INSERT INTO message(shareno, send_id, receive_id, content, title, target_amount) values(?,?,?,?,?,?)";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, shareno);
			pst.setString(2, sendid);
			pst.setString(3, receiveid);
			pst.setString(4, content);
			pst.setString(5, title);
			pst.setInt(6, Integer.parseInt(target_amount));
			cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("sendMessage DAO() 성공!!");
			} else
				System.out.println("sendMessage DAO() 실패!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 메시지 받는 메서드
	public ArrayList<messageVO> selectMessageAllId(String id) {
		ArrayList<messageVO> vos = new ArrayList<messageVO>();
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM message WHERE receive_id = ?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				messageVO vo = new messageVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));
				vos.add(vo);
				cnt = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cnt > 0)
			System.out.println("selectMessageAllId() 성공!");
		else
			System.out.println("selectMessageAllId() 실패!!");
		return vos;
	}

	// 메시지 초대 승낙 하는 메서드
	public void messageAccept(String shareno) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "INSERT INTO sharesaving(shareno, id, title, current_amount, target_amount, time) VALUES (?,?,?,0,?,now());";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, shareno);
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cnt > 0)
			System.out.println("messageAccept DAO () 성공!");
		else
			System.out.println("messageAccept DAO () 실패!!");

	}

	// 메시지 초대 거절(삭제) 하는메서드
	public void messageDelete(String no) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "DELETE FROM message WHERE no = ?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, no);
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cnt > 0)
			System.out.println("messageDelete DAO () 성공!");
		else
			System.out.println("messageDelete DAO () 실패!!");
	}
}
