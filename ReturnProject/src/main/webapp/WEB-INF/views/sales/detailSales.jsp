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
	<h2>상품 상세</h2>
	<hr>

	<div>
		<p>상품 이미지</p>
		<img src="${sales.salesImageName}">
		<hr>
		<p>상품 명</p>
		<p>${sales.salesName }</p>
		<hr>
		<p>상품 가격</p>
		<p>${sales.salesPrice }</p>
		<hr>
		<p>상품 상태</p>
		<p>${sales.salesCondition }</p>
		<hr>
		<p>배송비</p>
		<p>${sales.salesDelivery }</p>
		<hr>
		<p>거래지역</p>
		<p>${sales.salesAddress }</p>
		<hr>
		<c:choose>
			<c:when test="${sessionScope.memberNo == sales.memberNo }">
				<a href="/member/storeForm.do">내 상점 관리</a>
			</c:when>
			<c:otherwise>
				<p>찜</p>
				<a href="">채팅</a>
				<a href="">구매하기</a>
			</c:otherwise>
		</c:choose>
		<hr>
		<p>상품 설명</p>
		<textarea cols=30 rows=10>
		${sales.salesComment }
		</textarea>
		<hr>
		<p>거래 지역</p>
		<p>${sales.salesAddress }</p>
		<hr>
		<p>카테고리</p>
		<p>${sales.salesCategory }</p>
	</div>
</body>
</html>