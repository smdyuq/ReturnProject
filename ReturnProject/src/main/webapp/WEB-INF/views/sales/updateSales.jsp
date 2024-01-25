<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko" class="h-100">
<head>
<%@ include file="../common/head.jsp"%>
<link rel="canonical"
	href="https://getbootstrap.kr/docs/5.2/examples/checkout-rtl/">
<!-- Custom styles for this template -->
<link href="/resources/css/auth/registerForm.css" rel="stylesheet">
</head>

<body class="text-center">
	<a href="/">로고</a>
	<main>
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4"
				src="https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg"
				alt="" width="72" height="57">
			<h2>
				<a href="/sales/enrollSalesForm.do">판매 등록</a>
			</h2>
			<h2>
				<a href="/sales/manageSalesForm.do">상품 관리</a>
			</h2>
		</div>

		<div class="row g-3">
			<h3>수정</h3>
			<div class="">
				<form action="/sales/updateSales.do" method="POST"
					class="needs-validation" novalidate="">
					<input type="hidden" name="salesNo" value="${sales.salesNo }">
					<div class="row g-3">
						<div class="col-12">
							<label for="salesName" class="form-label">상품명</label> <input
								type="text" class="form-control" id="salesName" name="salesName"
								value="${sales.salesName }">

						</div>

						<div class="col-12">
							<label for="salesCategory" class="form-label">카테고리</label> <select
								class="form-select" aria-label="Default select example"
								name="salesCategory">
								<option selected hidden disabled>카테고리를 선택해주세요.</option>
								<option value="가전">가전</option>
								<option value="의류">의류</option>
								<option value="뷰티">향수·뷰티</option>
								<option value="푸드">푸드</option>
								<option value="주얼리">주얼리</option>
								<option value="크리스마스">크리스마스</option>
							</select>
						</div>

						<div class="col-12">
							<label for="salesAddress" class="form-label">거래지역</label> <input
								type="text" class="form-control" id="salesAddress"
								name="salesAddress" value="${sales.salesAddress }">

						</div>

						<div class="col-12">
							<label for="salesCondition" class="form-label">상품 상태</label> <input
								type="text" class="form-control" id="salesCondition"
								name="salesCondition" value="${sales.salesCondition }">

						</div>

						<div class="col-12">
							<label for="salesPrice" class="form-label">상품 가격</label> <input
								type="text" class="form-control" id="salesPrice"
								name="salesPrice" value="${sales.salesPrice }">

						</div>

						<div class="col-12">
							<label for="salesDelivery" class="form-label">배송비</label> <input
								type="text" class="form-control" id="salesDelivery"
								name="salesDelivery" value="${sales.salesDelivery }">

						</div>

						<div class="col-12">
							<label for="salesComment" class="form-label">상품 설명</label> <input
								type="text" class="form-control" id="salesComment"
								name="salesComment" value="${sales.salesComment }">

						</div>

						<div class="col-12">
							<label for="salesCount" class="form-label">상품 수량</label> <input
								type="text" class="form-control" id="salesCount"
								name="salesCount" value="${sales.salesCount }">

						</div>

						<button class="w-100 btn btn-primary btn-lg" type="submit"
							id="submit-btn">수정</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>