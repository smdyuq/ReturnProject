<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<a href="/">로고</a>
<hr>
<body>
	<h1>검색 페이지</h1>
	<hr>

	<div class=populaPage_List>
		<div class="Popula-card-wrapper">
			<input type="hidden" value="${sessionScope.memberNo}">
			<h2>최근 검색어</h2>
			<hr>
			<c:forEach var="item" items="${search }">
				<ul>
				<li>${item.searchWord }</li>
				</ul>
				<hr>
			</c:forEach>
			<h2>상품 리스트</h2>
			<c:forEach var="item" items="${sales }">
				<div class="popula-img"
					onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">
					<a href="#"><img class="popular_img"
						src="/resources/uploads/outerimage/300x300/${item.salesImageName }"></a>

					<div class="projectCardDetail">

						<input type="hidden" value=${item.salesNo }> <a href="#">${item.salesName }</a>
						<a href="#">${item.salesPrice }</a>
					</div>
					<hr>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>