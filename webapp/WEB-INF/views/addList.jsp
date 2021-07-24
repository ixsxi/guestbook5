<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="/guestbook4/insert" method="get">
		<table border='1'>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan='4'><textarea name="content" style="width: 470px; height: 100px"></textarea></td>
			</tr>
			<tr>
				<td colspan='4'><button type="submit">확인</button></td>
			</tr>

		</table>


	</form>
	<br>
	<!-- 리스트 출력 -->

	<c:forEach items="${guestList }" var="guestbookList">

		<table border='1' style="width: 485px;">

			<tr>
				<td>${guestbookList.no}</td>
				<td>${guestbookList.name}</td>
				<td>${guestbookList.reg_date}</td>
				<td><a href="/guestbook4/deleteForm?no=${guestbookList.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan='4'>${guestbookList.content }</td>
			</tr>
		</table>

		<br>

	</c:forEach>


</body>
</html>