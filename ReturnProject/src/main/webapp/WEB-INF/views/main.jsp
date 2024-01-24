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
	<p>${member.memberId }</p>
	<a href="/member/loginForm.do">로그인</a>
	<a href="/member/registerForm.do">회원가입</a>
	<a href="/sales/enrollSalesForm.do">판매하기</a>
</body>
</html>