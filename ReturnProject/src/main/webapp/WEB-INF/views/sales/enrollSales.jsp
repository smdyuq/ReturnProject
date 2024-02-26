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
			<h3>판매 등록</h3>
			<hr>
			<div class="">
				<form action="/sales/enrollSales.do" method="POST"
					class="needs-validation" enctype="multipart/form-data">

					<div>
						<input type="file" name="uploads" id="files"
							class="files form-control form-control-sm" multiple>
					</div>
					<div class="file_drag">
						<div class="file_list_header" style="display: none;">
							<div class="file_list_header_task">
								<button type="button" class="button_svg_delete">
									<span class="blind">전체 삭제</span>
								</button>
							</div>
							<div class="file_list_header_title">
								<span class="text">파일명</span>
							</div>
							<div class="file_list_header_volume">
								<span class="text">용량</span><span id="fileSize">0</span>
							</div>
						</div>
						<ul id="fileList"></ul>
					</div>


					<div class="row g-3">
						<div class="col-12">
							<label for="salesName" class="form-label">상품명</label> <input
								type="text" class="form-control" id="salesName" name="salesName">
						</div>

						<div class="col-12">
							<label for="salesCategory" class="form-label">카테고리</label> <select
								class="form-select" aria-label="Default select example"
								name="salesCategory">
								<option selected hidden disabled>카테고리를 선택해주세요.</option>
								<option value="가전">가전</option>
								<option value="의류">의류</option>
								<option value="뷰티">뷰티</option>
								<option value="푸드">푸드</option>
								<option value="주얼리">주얼리</option>
							</select>
						</div>

						<div class="col-12">
							<label for="salesAddress" class="form-label">거래지역</label> <input
								type="text" class="form-control" id="salesAddress"
								name="salesAddress" placeholder="ex)경기도 안양시 동안구">

						</div>

						<div class="col-12">
							<label for="salesCondition" class="form-label">상품 상태</label> <input
								type="text" class="form-control" id="salesCondition"
								name="salesCondition" placeholder="ex)최상">

						</div>

						<div class="col-12">
							<label for="salesPrice" class="form-label">상품 가격</label> <input
								type="text" class="form-control" id="salesPrice"
								name="salesPrice">

						</div>

						<div class="col-12">
							<label for="salesDelivery" class="form-label">배송비</label> <input
								type="text" class="form-control" id="salesDelivery"
								name="salesDelivery" value="0">

						</div>

						<div class="col-12">
							<label for="salesComment" class="form-label">상품 설명</label> <input
								type="text" class="form-control" id="salesComment"
								name="salesComment">

						</div>

						<div class="col-12">
							<label for="salesCount" class="form-label">상품 수량</label> <input
								type="text" class="form-control" id="salesCount"
								name="salesCount" value="1">

						</div>

						<div class="col-12">
							<label for="salesChatLink" class="form-label">상품 채팅 링크</label> <input
								type="text" class="form-control" id="salesChatLink"
								name="salesChatLink">

						</div>

						<button class="w-100 btn btn-primary btn-lg" type="submit"
							id="submit-btn">등록</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>

<script>
	const dataTransfer = new DataTransfer();

	$("#files")
			.change(
					function() {

						let fileArr = document.getElementById("files").files

						if (fileArr != null && fileArr.length > 0) {

							// =====DataTransfer 파일 관리========
							for (var i = 0; i < fileArr.length; i++) {
								dataTransfer.items.add(fileArr[i])
							}
							document.getElementById("files").files = dataTransfer.files;
							console.log("dataTransfer =>", dataTransfer.files)
							console.log("input FIles =>", document
									.getElementById("files").files)
							// ==========================================

						}

					})
</script>