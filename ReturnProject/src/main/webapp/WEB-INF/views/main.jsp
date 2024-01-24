<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">로고</a>
	<hr>
	<p>${sessionScope.memberId }님안녕하세요!</p>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/registerForm.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="/member/alarm.do">알림</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">판매하기</a>
		</c:when>
		<c:otherwise>
			<a href="/sales/enrollSalesForm.do">판매하기</a>
		</c:otherwise>
	</c:choose>
</body>
</html>