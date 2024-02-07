<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">로고</a>
	<hr>
	<h2>상품 상세</h2>
	<hr>

	<div>
		<p>상품 이미지</p>
		<img src="/resources/uploads/${sales.salesImageName}">
		<p>${sales.salesImageName}</p>
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
		<p>판매 수량</p>
		<p>${sales.salesCount }</p>
		<hr>
		<p>배송비</p>
		<p>${sales.salesDelivery }</p>
		<hr>
		<p>거래지역</p>
		<p>${sales.salesAddress }</p>
		<hr>
		<c:choose>
			<c:when
				test="${not empty sessionScope.memberNo && sessionScope.memberNo == sales.memberNo}">
				<a href="/member/storeForm.do">내 상점 관리</a>
			</c:when>
			<c:when
				test="${not empty sessionScope.memberNo && sessionScope.memberNo != sales.memberNo}">
				<button onclick="likeBtn(${sales.salesNo})">찜</button>
				<a href="">채팅</a>
				<a id="buyModal" href="#">구매하기</a>
			</c:when>
			<c:otherwise>
				<button onclick="location.href='/member/loginForm.do'">찜</button>
				<a href="/member/loginForm.do">채팅</a>
				<a href="/member/loginForm.do">구매하기</a>
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

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">구매 방법</h4>
				</div>
				<div class="modal-body">
					<p>구매 방법 선택 : 직거래 / 택배거래</p>
					<a href="/pay/payDeliveryPage.do?salesNo=${sales.salesNo}"
						class="btn btn-primary" type="delivery">택배 거래</a> 
					<a href="/pay/payDirectPage.do?salesNo=${sales.salesNo}"
						class="btn btn-primary" type="direct">직거래</a>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>

		</div>
	</div>


</body>
</html>

<script>
	function likeBtn(salesNo) {
		$.ajax({
			url : "/sales/likeBtn.do",
			type : "GET",
			data: { "salesNo": salesNo },
			success : function(response) {
				alert("찜목록에 추가되었습니다.");
			},
			failed : function(xhr, status, error) {
				console.error(error);
			}
		});
	}
	
	$(document).ready(function(){
		  $("#buyModal").click(function(e){
		    e.preventDefault();
		    $("#myModal").modal('show');
		  });
		});
		</script>