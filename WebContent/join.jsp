
<%@page import="com.DAO.savememberDAO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Helios by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/join.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<style>

</style>
<body>
	<div id="content">
		<a href="index.jsp" id="logo">Saving or Not</a> <br>
		<p style="font-size: 2.2em">Join</p>
		<form action="Join.do" method="post">
			<p>
				<input type="text" class="inputform" name="id" placeholder="ID"
					autofocus="autofocus">
			</p>
			<p>
				<input type="password" class="inputform" name="pw"
					placeholder="PASSWORD">
			</p>
			<span style="text-align: center;"> <label for="male">남자</label>
				<input type="radio" id="male" name="gender" value="male"
				style="height: auto;"> <label for="female"
				style="padding-left: 20px">여자</label> <input type="radio"
				id="password" name="gender" value="female" style="height: auto;">
			</span>
			<p>
				<input type="text" class="inputform" name="age" placeholder="Age">
			</p>
			<input type="submit" value="Join"> <input type="reset" value="Reset">
		</form>
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