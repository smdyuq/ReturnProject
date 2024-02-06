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
<!-- <script>
	$(document).ready(function() {
		$('#productDiv').hide();

		$("#option").change(function() {
			$('#productDiv').show();
			var selectedOption = $(this).children("option:selected").val();
			console.log("aaaa")
			console.log(selectedOption)
			if (selectedOption == 'deliveryTransaction') {
				$('#deliveryCost').show();
				$('#total1').show();
				$('#total2').hide();
				$('#address').hide();
			} else if (selectedOption == 'directTransaction') {
				$('#deliveryCost').hide();
				$('#total1').hide();
				$('#total2').show();
				$('#address').show();
			}
		});
	});
</script> -->
</head>
<body>

	<h2>택배 거래</h2>
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
		<p>거래 방법:</p>
		<div class="RadioButton">
			<input id="other" type="checkbox" value="kakao">
			<option value="direct">직접 거래</option>
		</div>
		<hr>
		<div id="productDiv">
			<p>상품 가격</p>
			<p>${salesCheck.salesPrice }</p>
			<hr>
			<p id="deliveryCost">배송비 : ${salesCheck.salesDelivery }</p>
			<hr>
			<p id="total">합계: ${salesCheck.salesPrice + salesCheck.salesDelivery }</p>

			<p id="address">거래 지역 : ${salesCheck.salesAddress }</p>
			<hr>
		</div>
	</div>

<form action="yourAction.do" method="post">
    <input type="checkbox" id="option1" name="option" value="1">
    <label for="option1">옵션 1</label><br>
    <input type="checkbox" id="option2" name="option" value="2">
    <label for="option2">옵션 2</label><br>
    <input type="checkbox" id="option3" name="option" value="3">
    <label for="option3">옵션 3</label><br>
    <input type="submit" value="제출">
</form>



	<form action="/pay/paying.do" method="POST">

		<button type="submit">결제</button>
	</form>
</body>
</html>