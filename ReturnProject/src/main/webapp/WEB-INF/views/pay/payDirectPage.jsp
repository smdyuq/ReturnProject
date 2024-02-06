<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>


</head>
<body>

	<h2>직거래</h2>
	<hr>

	<div>
		<p>상품 이미지</p>
		<img src="/resources/uploads/${salesCheck.salesImageName}">
		<p>${salesCheck.salesImageName}</p>
		<hr>
		<p>상품 명</p>
		<p>${salesCheck.salesName }</p>
		<hr>
		<hr>
		<label>거래 방법:</label> <a>직접 거래</a>
		<hr>
		<div id="productDiv">
			<p>상품 가격</p>
			<p>${salesCheck.salesPrice }</p>
			<hr>
			<input type="hidden" value="${salesCheck.salesDelivery }">
			<hr>
			<!-- 합계 = 상품가격+배송비 -->
			<p id="total">합계: ${salesCheck.salesPrice + salesCheck.salesDelivery }</p>

			<p id="address">거래 지역 : ${salesCheck.salesAddress }</p>
			<hr>
			<p id="PAY_METHOD">결제 수단:</p>
		</div>
	</div>
<form>
    <input type="checkbox" id="option1" name="option" value="kakaoPay">
    <label for="option1">카카오 페이</label><br>
    <input type="checkbox" id="option2" name="option" value="2">
    <label for="option2">옵션 2</label><br>
    <input type="checkbox" id="option3" name="option" value="3">
    <label for="option3">옵션 3</label><br>
    <!-- <input type="submit" value="제출"> -->
</form>

<h1>카카오 페이 테스트</h1>
    <input type="button" id="check" value="kakao">결제하기</input>


<!-- 	<form action="/pay/paying.do" method="POST">

		<button type="submit">결제</button>
	</form> -->
</body>
</html>
