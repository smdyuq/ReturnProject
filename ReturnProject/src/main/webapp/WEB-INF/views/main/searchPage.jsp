<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
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
			<c:forEach var="item" items="${search}">
				<div id="searchWord${item.searchNo}">
					<ul id="searchWord">
						<li>${item.searchWord}</li>
						<button onclick="deleteSearchWord(${item.searchNo})"
							data-searchno="${item.searchNo}">삭제</button>
					</ul>
					<hr>
				</div>
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

<script>
function deleteSearchWord(searchNo) {
    $.ajax({
        url: '/main/deleteSearch.do',
        type: 'POST',
        data: { searchNo: searchNo },
        success: function(response) {
            // 삭제 요청이 성공한 경우, 화면에서 해당 검색어를 제거합니다.
            if (response == 'success') {
            	 // var liElement = document.querySelector(`ul#searchWord li[data-searchno="${searchNo}"]`);
            	 let divElement = $('#searchWord'+searchNo);
          	        divElement.remove();
            }
        },
        error: function(xhr) {
            console.error('검색어 삭제에 실패했습니다.', xhr.status);
        }
    });
}
</script>