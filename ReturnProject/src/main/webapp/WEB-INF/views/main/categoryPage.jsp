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

	<c:forEach var="item" items="${sales }">
		<div class="popula-img"
			onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">
			<a href="#"><img class="popular_img"
				src="/resources/uploads/121x96/${item.imageName }"></a>

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