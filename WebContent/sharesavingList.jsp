<%@page import="com.DAO.sharesavingDAO"%>
<%@page import="com.VO.sharesavingVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.VO.savememberVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Left Sidebar - Helios by HTML5 UP</title>
<style>
*, :before, :after {
	box-sizing: border-box;
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
	function savingInputOne() {
		window.open("savinginput.jsp", "a",
				"width=500, height=100, left=150, top=50");
	}
</script>
<!-- /Script -->
<script>
function inputmoney(no, shareno) { 
    money = prompt("얼마를 저금하시겠습니까??");	
   	if(money<0) {
   		alert("0미만은 입력할 수 없습니다.")
   	} else if(money != null) {
   		alert("완료");
    	document.location.href='sharesavingInputOne.do?no='+no+'&current_amount='+money+'&shareno='+shareno;
   	} else {
   		alert("취소하셨습니다")
   		document.location.href='sharesavingList.jsp?no='+shareno;
   		
   	}
    
    }

</script>

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
		String shareno = request.getParameter("no");
		String masterid = null;
		savememberVO vo = (savememberVO) session.getAttribute("vo");
		sharesavingDAO dao = new sharesavingDAO();
		ArrayList<sharesavingVO> svo = dao.sharesavingSelectNo(shareno);
		//만든이를 알기위해
		for (int i = 0; i < svo.size(); i++)
			masterid = svo.get(i).getMasterid();
	%>
	<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Inner -->
			<div class="inner">
				<header>
					<h1 style="margin-bottom: 0.6em;">
						<a href="saving.jsp" id="logo"><%=vo.getId()%> 님이 참여중인 공동목표</a>
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
			<header style="text-align: center;">
				<h1>
					만든이 :
					<%=masterid%></h1>
			</header>
			<div class="container" style="text-align: center;">
				<div class="row" style="text-align: center;">
					<%
						double aa;
						int a;
						for (int i = 0; i < svo.size(); i++) {
							aa = ((double) svo.get(i).getCurrent_amount() / (double) svo.get(i).getTarget_amount()) * (double) 100;
							a = (int) aa;
					%>

					<article class="col-4 col-12-mobile special">
						<!--현재 로그인한 사용자와 참여자 아이디가 같을 경우 삭제 버튼 활성화 -->
						<%
							if (vo.getId().equals(svo.get(i).getId())) {
						%>
						<a id="img-link" href="deleteShare.do?no=<%=svo.get(i).getNo()%>"><img
							src="images/cancel.png"></a>
						<%
							}
						%>
						<a href="#" class="image featured"
							style="text-align: center; margin: 0 0 0.2em 0"> <svg
								class="radial-progress" data-percentage="<%=a%>"
								viewBox="0 0 80 80">
								<circle class="incomplete" cx="40" cy="40" r="35"></circle>
								<circle class="complete" cx="40" cy="40" r="35"
									style="stroke-dashoffset: 39.58406743523136;"></circle>
								<text class="percentage" x="50%" y="57%"
									transform="matrix(0, 1, -1, 0, 80, 0)"><%=a%>%</text>
							</svg>
						</a>
						<header>
							<h3 style="margin-bottom: 0.3em">
								<%
									if (vo.getId().equals(svo.get(i).getId())) {
								%>
								<button type="button"
									onclick="inputmoney(<%=svo.get(i).getNo()%>,<%=svo.get(i).getShareno()%>)">저금</button>
								<%-- 임시<button type="button" onclick="location.href='sharesavinginput.jsp?no=<%=svo.get(i).getNo()%>' ">저금</button> --%>
								<%
									}
								%>
							</h3>
							<h3 style="margin-top: 0.9em">
								<a href="#"><%=svo.get(i).getTitle()%></a>
							</h3>
						</header>
						<p>
							참여자 :
							<%=svo.get(i).getId()%>
						</p>
						<p>
							현재 금액 :
							<%=svo.get(i).getCurrent_amount()%></p>
						<p>
							목표 금액 :
							<%=svo.get(i).getTarget_amount()%></p>
						<p>
							등록 날짜 :
							<%=svo.get(i).getTime()%>
						</p>
						<%
							if (svo.get(i).getComtime() != null) {
						%>
						<p>
							완료 날짜 :
							<%=svo.get(i).getComtime()%>
						</p>
						<%
							}
						%>

					</article>

					<%
						}
					%>
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