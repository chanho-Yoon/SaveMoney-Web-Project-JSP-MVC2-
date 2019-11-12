package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.VO.savememberVO;

public class savememberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	String url = "jdbc:mysql://localhost:3306/db";
	String driver = "com.mysql.jdbc.Driver";
	String dbid = "chanho";
	String dbpw = "1234";
	String sql = null;
	ResultSet rs = null;

	public savememberDAO() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkId(String id) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("Login DAO 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT id FROM savemember";

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				if (rs.getString(1).equals(id)) {
					System.out.println("중복된 ID가 있습니다.");
					cnt = 1;
					JOptionPane.showMessageDialog(null, "중복된 아이디 존재, 실패", "", JOptionPane.ERROR_MESSAGE);

				}

			}
		} catch (Exception e) {

		}
		return cnt;
	}
	//로그인 처리 
	public savememberVO Login(savememberVO vo) {

		savememberVO vo_1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("Login DAO 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM savemember WHERE id=? and pw=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("로그인 성공 dao login");
				vo_1 = new savememberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} else {
				System.out.println("로그인 실패 dao login");

			}
		} catch (Exception e) {

		}
		return vo_1;
	}
	//회원가입 처리
	public void Join(savememberVO vo) {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!!  & DB load success!!");

			sql = "INSERT INTO savemember(id,pw,gender,age) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());
			pst.setString(3, vo.getGender());
			pst.setString(4, vo.getAge());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//회원 업데이트 처리
	public void mypageMemberUpdate(String id, String pw, String age) {
		int cnt = 0;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!!  & DB load success!!");

			sql = "UPDATE savemember SET pw=?,age=? WHERE id=? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, age);
			pst.setString(3, id);
			
			cnt = pst.executeUpdate();
			
			if(cnt > 0)
				System.out.println("mypageMemberUpdate DAO 성공");
			else
				System.out.println("mypageMemberUpdate DAO 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
