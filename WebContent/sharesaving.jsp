<%@page import="com.VO.sharesavingVO"%>
<%@page import="com.DAO.sharesavingDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.savingDAO"%>
<%@page import="com.VO.savememberVO"%>
<%@page import="java.util.Random"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>공동 저축 현황</title>
<style>
*, :before, :after {
	box-sizing: border-box;
}

body {
	background-color: #1d1f20;
	color: #e5e5e5;
	font: 16px/1.25 'Raleway', sans-serif;
	margin: auto 0;
	background: linear-gradient(to top right, #060628, #1F245A, #682359);
}

.row {
	margin-left: auto;
	margin-right: auto;
	max-width: 80em;
	padding: 1em;
}

section {
	text-align: center;
}

h1, h2, h3, h4, h5, h6 {
	font-family: 'Oswald', sans-serif;
	font-weight: 400;
	text-align: center;
}

p {
	margin-left: auto;
	margin-right: auto;
	max-width: 36em;
	text-align: center;
}

/*** RADIAL PROGRESS ***/
/* Circumference = 2πr */
/* π = 3.1415926535898 */
/* r = 35 */
svg.radial-progress {
	height: auto;
	max-width: 200px;
	padding: 1em;
	transform: rotate(-90deg);
	width: 100%;
}

svg.radial-progress circle {
	fill: rgba(0, 0, 0, 0);
	stroke: #fff;
	stroke-dashoffset: 219.91148575129; /* Circumference */
	stroke-width: 10;
}

svg.radial-progress circle.incomplete {
	opacity: 0.25;
}

svg.radial-progress circle.complete {
	stroke-dasharray: 219.91148575129; /* Circumference */
}

svg.radial-progress text {
	fill: #ccc;
	font: 400 1em/1 'Oswald', sans-serif;
	text-anchor: middle;
}

/*** COLORS ***/
/* Primary */
article:nth-of-type(5n+1) circle {
	stroke: #a2ed56;
}

/* Secondary */
article:nth-of-type(5n+2) circle {
	stroke: #83e4e2;
}

/* Tertiary */
article:nth-of-type(5n+3) circle {
	stroke: #fd6470;
}

/* Quaternary */
article:nth-of-type(5n+4) circle {
	stroke: #fca858;
}

/* Quinary */
article:nth-of-type(5n+5) circle {
	stroke: #fddc32;
}
</style>
<!-- Script -->

<script type="text/javascript"
	src="https://pagead2.googlesyndication.com/pagead/show_ads.js">
	
</script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT"
	crossorigin="anonymous"></script>

<script>
	$(function() {

		// Remove svg.radial-progress .complete inline styling
		$('svg.radial-progress').each(function(index, value) {
			$(this).find($('circle.complete')).removeAttr('style');
		});

		// Activate progress animation on scroll
		$(window)
				.scroll(
						function() {
							$('svg.radial-progress')
									.each(
											function(index, value) {
												// If svg.radial-progress is approximately 25% vertically into the window when scrolling from the top or the bottom
												if ($(window).scrollTop() > $(
														this).offset().top
														- ($(window).height() * 0.75)
														&& $(window)
																.scrollTop() < $(
																this).offset().top
																+ $(this)
																		.height()
																- ($(window)
																		.height() * 0.25)) {
													// Get percentage of progress
													percent = $(value).data(
															'percentage');
													// Get radius of the svg's circle.complete
													radius = $(this)
															.find(
																	$('circle.complete'))
															.attr('r');
													// Get circumference (2πr)
													circumference = 2 * Math.PI
															* radius;
													// Get stroke-dashoffset value based on the percentage of the circumference
													strokeDashOffset = circumference
															- ((percent * circumference) / 100);
													// Transition progress for 1.25 seconds
													$(this)
															.find(
																	$('circle.complete'))
															.animate(
																	{
																		'stroke-dashoffset' : strokeDashOffset
																	}, 1250);
												}
											});
						}).trigger('scroll');

	});
</script>

<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
	_gaq.push([ '_setDomainName', 'jqueryscript.net' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
<script>
	
</script>
<!-- /Script -->


<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="left-sidebar is-preload">

	
	<%
	savememberVO vo = (savememberVO) session.getAttribute("vo");
	sharesavingDAO dao = new sharesavingDAO();
	ArrayList<sharesavingVO> svo = dao.sharesavingSelect(vo.getId());
	//아래 만들어야함
	String masterid = (String)session.getAttribute("masterid");
	
	%>
	
	<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Inner -->
			<div class="inner">
				<header>
					<h1 style="margin-bottom: 0.6em;">
						<a href="saving.jsp" id="logo"><%=vo.getId()%>님의 공동 저축 현황</a>
					</h1>
					<button type="button" onclick="location.href='saving.jsp' "
						style="text-align: center; margin-right: 2em;">개인</button>
					<button type="button" onclick="location.href='sharesaving.jsp' ">공동</button>
				</header>
			</div>

			<!-- Nav -->
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

		<!-- Main -->
		<div class="wrapper style1">
			<div class="col-8 col-12-mobile imp-mobile" id="content">
				<article id="main">
					<header>
						<h3>
							<a href="#"><%=vo.getId()%> 님이 참여중인 공동목표</a>
						</h3>
						<p></p>
					</header>
					<div id="board_area">
						<table class="list-table" style="margin-left: 4em;">
							<thead>
								<tr>
									<th width="80">방장</th>
									<th width="500">제목</th>
									<th width="100">작성일</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (int i = 0; i < svo.size(); i++) {
										
								%>
								<tr>
									<td width="70"><%=svo.get(i).getMasterid()%></td>
									<td width="500"><a
										href="sharesavingList.jsp?no=<%=svo.get(i).getShareno()%>&masterid=<%=svo.get(i).getMasterid()%>"><%=svo.get(i).getTitle()%></a>
									</td>
									<td width="120"><%=svo.get(i).getTime()%></td>
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