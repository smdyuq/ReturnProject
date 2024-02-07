<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">로고</a>
	<hr>
	<main class="flex-shrink-0">
		<div class="container">
			<h3>내상점</h3>
			<hr>
			<p>상점 이미지</p>
			<p>
				<img src="/resources/uploads/303x310/${member.memberImageName }">
			</p>
			<c:if test="${sessionScope.memberId == member.memberId }">
				<button onclick="location.href='/member/storeImageUpdateForm.do'">이미지
					수정</button>
			</c:if>
			<hr>
			<p>상점 아이디</p>
			<p>${sessionScope.memberId }</p>
			<hr>
			<p>상점 방문수</p>
			<p>${member.memberVisit }</p>
			<hr>
			<p>소개글</p>
			<p>${member.memberContent }</p>
			<button>소개글 수정</button>


			<table class="table table-hover">
				<thead>
					<h2>상품 관리</h2>
					<tr>
						<td>번호</td>
						<td>사진</td>
						<td>상품명</td>
						<td>가격</td>
						<td>최근수정일</td>
						<td>기능</td>
					</tr>
				</thead>
				<tbody>

					<c:choose>
						<c:when test="${empty sales}">
							<tr>
								<td colspan="6">
									<h3 class="text-center">등록된 상품이 없습니다.</h3>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${sales }">
								<tr
									onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">
									<td><img src="${item.salesImageName}"></td>
									<td>${item.salesName}</td>
									<td>${item.salesPrice}</td>
									<td>${item.salesUpdateDate}</td>
									<td><button
											onclick="location.href='/sales/updateSalesForm.do?salesNo=${item.salesNo}'">수정</button>
										<button
											onclick="location.href='/sales/deleteSales.do?salesNo=${item.salesNo}'">삭제</button></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>



				</tbody>
			</table>

			<table class="table table-hover">
				<thead>
					<h2>찜</h2>
					<tr>
						<td>번호</td>
						<td>사진</td>
						<td>상품명</td>
						<td>가격</td>
						<td>최근수정일</td>
						<td>기능</td>
					</tr>
				</thead>
				<tbody>

					<c:choose>
						<c:when test="${empty like}">
							<tr>
								<td colspan="6">
									<h3 class="text-center">등록된 상품이 없습니다.</h3>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${like }">
								<tr
									onclick="location.href='/sales/detailSales.do?salesNo=${item.salesNo}'">
									<td><img src="${item.salesImageName}"></td>
									<td>${item.salesName}</td>
									<td>${item.salesPrice}</td>
									<td>${item.salesUpdateDate}</td>
									<td><button
											onclick="location.href='/sales/updateSalesForm.do?salesNo=${item.salesNo}'">수정</button>
										<button
											onclick="location.href='/sales/deleteSales.do?salesNo=${item.salesNo}'">삭제</button></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>



				</tbody>
			</table>
</body>
</html>