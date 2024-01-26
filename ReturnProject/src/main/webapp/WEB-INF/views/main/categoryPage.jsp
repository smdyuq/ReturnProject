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
	<h1>카테고리 페이지</h1>
	<hr>

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