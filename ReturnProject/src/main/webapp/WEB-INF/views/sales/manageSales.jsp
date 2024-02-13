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

		<main class="flex-shrink-0">
			<div class="container">
				<h3>상품 관리</h3>
				<hr>
				<br />
				<form action="${sessionScope.action }" method="GET" class="d-flex"
					role="search">
					<input class="form-control me-2" type="search" name="searchText"
						placeholder="Search" aria-label="Search">
					<div class="btn-group">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</div>
				</form>
				<hr>
				<br>
				<table class="table table-hover">
					<thead>
						<tr>
							<td>번호</td>
							<td>사진</td>
							<td>상품명</td>
							<td>가격</td>
							<td>찜</td>
							<td>최근수정일</td>
							<td>기능</td>
						</tr>
					</thead>
					<tbody>

						<c:choose>
							<c:when test="${empty list}">
								<tr>
									<td colspan="7">
										<h3 class="text-center">등록된 상품이 없습니다.</h3>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list }">
									<tr>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">${row}</td>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'"><img
											src="/resources/uploads/194x194/${item.salesImageName}"></td>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">${item.salesName}</td>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">${item.salesPrice}</td>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">${item.salesLikesCount}</td>
										<td
											onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">${item.salesUpdateDate}</td>
										<td><button
												onclick="location.href='/sales/updateSalesForm.do?salesNo=${item.salesNo}'">수정</button>
											<button
												onclick="location.href='/sales/deleteSales.do?salesNo=${item.salesNo}'">삭제</button></td>
									</tr>
									<c:set var="row" value="${row-1}" />
								</c:forEach>
							</c:otherwise>
						</c:choose>



					</tbody>
				</table>
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-center">

						<c:choose>
							<c:when test="${pi.cpage eq 1}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list.do?cpage=${pi.cpage-1}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
							<li class="page-item"><a class="page-link"
								href="list.do?cpage=${page}">${page}</a></li>
						</c:forEach>

						<c:choose>
							<c:when test="${pi.cpage eq pi.maxPage}">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list.do?cpage=${pi.cpage+1}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
				</nav>
			</div>
		</main>

	</main>
</body>
</html>