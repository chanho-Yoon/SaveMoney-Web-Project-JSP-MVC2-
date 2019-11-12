<%@page import="com.DAO.sharesavingDAO"%>
<%@page import="com.VO.sharesavingVO"%>
<%@page import="com.VO.savememberVO"%>
<%@page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가만든 공동저축 관리</title>
<style>
* {
	margin: 0 auto;
	padding: 0;
	font-family: 'Malgun gothic', 'Sans-Serif', 'Arial';
}

a {
	text-decoration: none;
	color: #333;
}

ul li {
	list-style: none;
}

/* 공통 */
.fl {
	float: left;
}

.tc {
	text-align: center;
}

/* 게시판 목록 */
#board_area {
	width: 900px;
	position: relative;
}

.list-table {
	margin-top: 40px;
}

.list-table thead th {
	height: 40px;
	border-top: 2px solid #09C;
	border-bottom: 1px solid #CCC;
	font-weight: bold;
	font-size: 17px;
}

.list-table tbody td {
	text-align: center;
	padding: 10px 0;
	border-bottom: 1px solid #CCC;
	height: 20px;
	font-size: 14px
}

#write_btn {
	position: absolute;
	margin-top: 20px;
	right: 0;
}
</style>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<body>
	<%
		savememberVO vo = (savememberVO) session.getAttribute("vo");
		sharesavingDAO dao = new sharesavingDAO();
		ArrayList<sharesavingVO> svo = dao.mypagesharesavingSelect(vo.getId());
	%>
	<div id="page-wrapper">
		<!-- Nav -->
		<div id="header">
			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="mypage.jsp" id="logo">MyPage</a>
					</h1>
				</header>
			</div>

			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="left-sidebar.html">Information</a></li>
					<%
						if (vo != null) {
					%>
					<li><a href="saving.jsp">Saving</a></li>
					<li><a href="mypage.jsp">My Page</a></li>
					<li><a href="Logout.do">Logout</a></li>
					<%
						}
					%>
				</ul>
			</nav>
		</div>
	</div>
	<!-- Main -->
	<div class="wrapper style1">

		<div class="container">
			<div class="row gtr-200">
				<div class="col-4 col-12-mobile" id="sidebar">
					<hr class="first" />
					<section>
						<h3>
							<a href="mypageMemberUpdate.jsp">회원정보수정</a>
						</h3>
						<br>
						<h3>
							<a href="mypageMessage.jsp">초대함</a>
						</h3>
						<br>
						<h3>
							<a href="mypageSavingOne.jsp">개인저축현황 완료내역</a>
						</h3>
						<br>
						<h3>
							<a href="mypageSavingTogether.jsp">공동저축현황 완료내역</a>
						</h3>
						<br>
						<h3>
							<a href="mypageCreateOne.jsp">개인저축 만들기</a>
						</h3>
						<br>
						<h3>
							<a href="mypageCreateShare.jsp">공동저축 만들기</a>
						</h3>
						<br>
						<h3>
							<a href="mypageMyCreateShare.jsp">내가만든 공동저축 관리</a>
						</h3>
					</section>
				</div>
				<div class="col-8 col-12-mobile imp-mobile" id="content">
					<article id="main">
						<header>
							<h3>
								<a href="#"><%=vo.getId()%> 님이 만드신 공동 목표</a>
							</h3>
							<p></p>
						</header>
						<div id="board_area">
							<table class="list-table" style="margin-left: 4em;">
								<thead>
									<tr>
										<th width="500">제목</th>
										<th width="100">작성일</th>
										<th width="90">삭제</th>
									</tr>
								</thead>
								<%
									if (svo != null) {
								%>
								<tbody>

									<%
										for (int i = 0; i < svo.size(); i++) {
									%>
									<%
										if (svo.get(i).getNo() == svo.get(i).getShareno()) {
									%>
									<tr>
										<td width="500"><a
											href="mypageMyCreateShareList.jsp?no=<%=svo.get(i).getNo()%>&title=<%=svo.get(i).getTitle()%>&target_amount=<%=svo.get(i).getTarget_amount()%>"><%=svo.get(i).getTitle()%></a>
										</td>
										<td width="120"><%=svo.get(i).getTime()%></td>
										<td width="90">
											<button type="button"
												onclick="location.href='mypageDeleteShare.do?no=<%=svo.get(i).getShareno()%>' ">삭제</button>
										</td>
									</tr>
									<%
										}
											}
									%>

								</tbody>
								<%
									}
								%>
							</table>
						</div>
					</article>
				</div>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>