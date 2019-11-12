
<%@page import="com.VO.messageVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.messageDAO"%>
<%@page import="com.VO.savememberVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body>
	<%
		savememberVO vo = (savememberVO) session.getAttribute("vo");
		String loginid = vo.getId();
		messageDAO mdao = new messageDAO();
		ArrayList<messageVO> mvo = mdao.selectMessageAllId(loginid);
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
								<a href="#"><%=vo.getId()%> 님의 메시지 초대함</a>
							</h3>
							<p></p>
						</header>
						<div id="board_area">
							<table class="list-table" style="margin-left: 4em;">
								<thead>
									<tr>
										<th width="70">번호</th>
										<th width="100">보낸 사람</th>
										<th width="100">메시지</th>
										<th width="90">받기</th>
										<th width="90">삭제</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < mvo.size(); i++) {
									%>

									<tr>
										<td width="70"><%=mvo.get(i).getNo()%></td>
										<td width="180"><%=mvo.get(i).getSend_id()%></td>
										<td width="400"><%=mvo.get(i).getContent()%></td>
										<td width="100">
											<button type="button"
												onclick="location.href='mypageMessageReceive.do?no=<%=mvo.get(i).getShareno()%>&title=<%=mvo.get(i).getTitle()%>&target_amount=<%=mvo.get(i).getTarget_amount()%>&loginid=<%=loginid%>&masterid=<%=mvo.get(i).getSend_id()%>' ">받기</button>
										</td>
										<td width="100">
											<button type="button"
												onclick="location.href='mypageMessageDelete.do?no=<%=mvo.get(i).getNo()%>' ">삭제</button>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
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