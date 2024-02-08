<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
	<a href="/">로고</a>
	<hr>
	<p>${sessionScope.memberId }님안녕하세요!</p>
	<hr>
	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/registerForm.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="/member/alarm.do">알림</a>
		</c:otherwise>
	</c:choose>

	<hr>

	<form action="/main/search.do" method="POST">
		<input type="hidden" value="${searchNo }"> <input
			class="form-control me-2" type="search" name="searchWord"
			placeholder="Search" aria-label="Search">
		<div class="btn-group">
			<button class="btn btn-outline-success" type="submit">Search</button>
		</div>
	</form>

	<hr>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">판매하기</a>
		</c:when>
		<c:otherwise>
			<a href="/sales/enrollSalesForm.do">판매하기</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">내상점</a>
		</c:when>
		<c:otherwise>
			<a href="/member/storeForm.do?memberNo=${sessionScope.memberNo }">내상점</a>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${sessionScope.memberNo == null }">
			<a href="/member/loginForm.do">채팅</a>
		</c:when>
		<c:otherwise>
			<a href="/">채팅</a>
		</c:otherwise>
	</c:choose>
	<hr>
	<p>카테고리</p>
	<ul>
		<li><p
				onclick="location.href='/main/categorySales.do?salesCategory=homeAppliances'">가전</p></li>
		<li><p
				onclick="location.href='/main/categorySales.do?salesCategory=clothes'">의류</p></li>
		<li><p
				onclick="location.href='/main/categorySales.do?salesCategory=perfume'">향수</p></li>
		<li><p
				onclick="location.href='/main/categorySales.do?salesCategory=food'">푸드</p></li>
		<li><p
				onclick="location.href='/main/categorySales.do?salesCategory=jewelry'">주얼리</p></li>
	</ul>
</header>
<body>
	<hr>
	<h2>배너 이미지</h2>
	<a href="/main/bannerPage.do"><img src=""></a>
	<hr>
	<h2>상품 리스트</h2>
	<hr>
	<div class=populaPage_List>
		<div class="Popula-card-wrapper">
			<c:forEach var="item" items="${sales }">
				<div class="popula-img"
					onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">
					<p>상품이미지</p>
					<a href="#"><img class="popular_img"
						src="/resources/uploads/303x310/${item.salesImageName }"></a>

					<div class="projectCardDetail">

						<input type="hidden" value=${item.salesNo }>
						<p>상품명</p>
						<a href="#">${item.salesName }</a>
						<p>상품가격</p>
						<a href="#">${item.salesPrice }</a>
						<hr>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>