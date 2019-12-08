package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.sharesavingVO;

public class sharesavingDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	String url = "jdbc:mysql://localhost:3306/db";
	String driver = "com.mysql.jdbc.Driver";
	String dbid = "chanho";
	String dbpw = "1234";
	String sql = null;
	ResultSet rs = null;

	public sharesavingDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sharesaving no 값 가져오는 메서드
	public int sharesavingSearchNo(String title) {
		int cnt = 0;
		
		System.out.println(title + " !@#!@#!@#@@@");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("inputMoney 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM sharesaving WHERE title = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			rs = pst.executeQuery();

			while(rs.next()) {
				System.out.println("rs.next 실행한다!!! ㅅㅂ!!" + rs.getInt(1));
				cnt = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 공동목록 게시글 추가
	public int sharesavingWrite(sharesavingVO vo, String title) {
		int cnt = 0;
		sharesavingDAO dao = new sharesavingDAO();
		System.out.println("vo " + vo.getNo());
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("sharesavingWrite 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "INSERT INTO sharesaving(id,title,current_amount, target_amount, time) values(?,?,?,?,now())";

			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getTitle());
			pst.setInt(3, 0);
			pst.setInt(4, vo.getTarget_amount());
			
			
			cnt = pst.executeUpdate();
			
			int no = dao.sharesavingSearchNo(title);
			sql = "UPDATE sharesaving SET shareno=?, masterid=? WHERE id=? AND title=?"; //shareno를 넣어줘야함
			pst = conn.prepareStatement(sql);
			pst.setInt(1, no);
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getId());
			pst.setString(4, title);

			pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("입력성공!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;

	}

	// 공동 저축 현황 페이지에서 자신이 등록한 게시글 보여주기 위한 메서드
	public ArrayList<sharesavingVO> sharesavingSelect(String id) {
		int cnt = 0;
		
		ArrayList<sharesavingVO> vos = new ArrayList<sharesavingVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("sharesavingWrite 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM sharesaving WHERE id = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				sharesavingVO vo = new sharesavingVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				vos.add(vo);
			}
			if( vos != null)
				return vos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 공동목록 관리자에서 자신이 만든 저축목록을 보여주기 위한 메서드
	public ArrayList<sharesavingVO> mypagesharesavingSelect(String id) {
		int cnt = 0;
		
		ArrayList<sharesavingVO> vos = new ArrayList<sharesavingVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("sharesavingWrite 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "SELECT * FROM sharesaving WHERE masterid = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				sharesavingVO vo = new sharesavingVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				vos.add(vo);
			}
			if( vos != null)
				return vos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//공동목록 관리자에서 자신이 등록한 게시글을 삭제할 수 있는 메서드 
	public int mypageDeleteShare(String no) {
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			System.out.println("sharesavingWrite 실행");

			conn = DriverManager.getConnection(url, "chanho", "1234");

			System.out.println("DBms connection success!!");

			sql = "DELETE FROM sharesaving WHERE shareno = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, no);

			cnt = pst.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	//공동목록 페이지에서 자신이 참여한 것을 삭제(탈퇴) 가능 게시글을 삭제할 수 있는 메서드 
		public int deleteShare(String no) {
			int cnt = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				System.out.println("sharesavingWrite 실행");

				conn = DriverManager.getConnection(url, "chanho", "1234");

				System.out.println("DBms connection success!!");

				sql = "DELETE FROM sharesaving WHERE no = ?";
				
				pst = conn.prepareStatement(sql);
				pst.setString(1, no);

				cnt = pst.executeUpdate();
				
				if(cnt>0)
					System.out.println("deleteShare DAO() 성공!");
				else
					System.out.println("deleteShare DAO() 실패!");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return cnt;
		}
	// 공동목록 관리자에서 자신이 등록한 게시글 보여주기 위한 메서드
		public ArrayList<sharesavingVO> sharesavingSelectAll() {
			int cnt = 0;
			
			ArrayList<sharesavingVO> vos = new ArrayList<sharesavingVO>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				System.out.println("sharesavingWrite 실행");

				conn = DriverManager.getConnection(url, "chanho", "1234");

				System.out.println("DBms connection success!!");

				sql = "SELECT * FROM sharesaving";

				pst = conn.prepareStatement(sql);

				rs = pst.executeQuery();

				while (rs.next()) {
					sharesavingVO vo = new sharesavingVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getString(5), rs.getString(6));
					vos.add(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return vos;
		}
		
		//shareno을 가져와서 sharesaving에서 자신이 현재 참여중인 공동 저축목록을 출력해줄 수 있게
		public ArrayList<sharesavingVO> sharesavingSelectAllId(String id) {
			int cnt = 0;
			
			ArrayList<sharesavingVO> vos = new ArrayList<sharesavingVO>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				System.out.println("sharesavingWrite 실행");
				System.out.println(id + "인트형이라고??");
				conn = DriverManager.getConnection(url, "chanho", "1234");

				System.out.println("DBms connection success!!");

				sql = "SELECT * FROM sharesaving where id = ?";

				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				
				rs = pst.executeQuery();
				
				while (rs.next()) {
					sharesavingVO vo = new sharesavingVO(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),
							rs.getInt(7), rs.getString(8),rs.getString(9));
					vos.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return vos;
		}
		// 공동목록 sharesaving에서 클릭할 시 해당에 참여하고 있는 멤버 가져오기 위한 메서드
		public ArrayList<sharesavingVO> sharesavingSelectNo(String no) {
			int cnt = 0;
			
			ArrayList<sharesavingVO> vos = new ArrayList<sharesavingVO>();
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				System.out.println("sharesavingWrite 실행");

				conn = DriverManager.getConnection(url, "chanho", "1234");

				System.out.println("DBms connection success!!");

				sql = "SELECT * FROM sharesaving WHERE shareno = ?";

				pst = conn.prepareStatement(sql);
				pst.setString(1, no);

				rs = pst.executeQuery();

				while (rs.next()) {
					sharesavingVO vo = new sharesavingVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));
					vos.add(vo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return vos;
		}
		//공동저축 초대받은 사람 데이터 추가
		public int sharesavingWriteReceiveMember(String no, String masterid,String loginid, String title, String target_amount) {
			int cnt = 0;
			
			int tmpno = Integer.parseInt(no);
			int tmptarget_amount = Integer.parseInt(target_amount);
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				System.out.println("sharesavingWrite 실행");

				conn = DriverManager.getConnection(url, "chanho", "1234");

				System.out.println("DBms connection success!!");

				sql = "INSERT INTO sharesaving(shareno,id,title,current_amount,target_amount,time,masterid) values(?,?,?,?,?,now(),?)";
				
				pst = conn.prepareStatement(sql);
				pst.setInt(1, tmpno);
				pst.setString(2, loginid);
				pst.setString(3, title);
				pst.setInt(4, 0);
				pst.setInt(5, tmptarget_amount);
				pst.setString(6, masterid);
				cnt = pst.executeUpdate();
				
				//데이터를 넣고 메시지 삭제
				sql = "DELETE FROM message WHERE title=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, title);
				
				cnt = pst.executeUpdate();
				
				if (cnt > 0) {
					System.out.println("입력성공!!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return cnt;
		}
		
		// 공동 목표 카테고리에 돈 입금 하는 메서드
		public int sharesavingInputOne(String no, String money) {
			int cnt = 0;
			String tmpmoney = null;
			
			cnt = sharesavingInputOneCheck(no, money);  //목표금액보다 돈이 더 들어가느지 확인하는 메서드
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

				sql = "UPDATE sharesaving SET current_amount=? WHERE no = ?";

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
		public int sharesavingInputOneCheck(String no, String money) {
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

				sql = "SELECT current_amount, target_amount FROM sharesaving WHERE no=?";

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
					sql = "UPDATE sharesaving SET comtime=now() WHERE no=?";
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
}
