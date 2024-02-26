<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Fixed navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li calss="nav-item"><a id="member-information" color="white">
							${sessionScope.memberId}님</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#">홈</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/inquiry/boardList.do">문의 게시판</a></li>
				</ul>
				<a href="/admin/logout.do">로그아웃</a> <a href="/admin/registerForm.do">관리자
					등록</a>
				<form action="${sessionScope.action}" method="GET" class="d-flex"
					role="search">
					<input class="form-control me-2" name="searchText" type="search"
						placeholder="Search" aria-label="Search">
					<div class="btn-group">
						<button class="btn btn-outline-success" type="submit">Search</button>
						<select class="btn btn-outline-success" name="searchCategory"
							id="dropdownMenuButton" aria-haspopup="true"
							aria-expanded="false">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="writer">작성자</option>
						</select>
					</div>
				</form>
			</div>
		</div>
	</nav>
</header>