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
	<h2>결제 완료 페이지</h2>
	<p>상품 이미지</p>
	<img src="/resources/uploads/303x310/${payInfo.imageName }">
	<p>상품 가격</p>
	<p>${payInfo.salesPrice }</p>
	
</body>
</html>