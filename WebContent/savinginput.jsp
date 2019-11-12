<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String no = request.getParameter("no");
	%>
	<form method="post" action="SavingWriteOne.do?no=<%=no%>">
		<table>
			<tr>
				<td>&nbsp;</td>
				<td align="center">저축할 금액 입력</td>
				<td><input type="text" name="current_amount" size="50"
					maxlength="50"></td>
				<td>&nbsp;</td>
			</tr>
			<tr height="1" bgcolor="#dddddd">
				<td colspan="4"></td>
			</tr>
			<tr align="center">
				<td>&nbsp;</td>
				<td colspan="2"><input type="submit" value="등록"> <input
					type="reset" value="취소">
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>