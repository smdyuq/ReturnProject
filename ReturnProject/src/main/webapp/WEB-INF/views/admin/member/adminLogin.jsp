<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko" class="h-100">
<head>
<%@ include file="../common/adminHead.jsp"%>
<link rel="canonical"
	href="https://getbootstrap.kr/docs/5.2/examples/sign-in/">
<!-- Custom styles for this template -->
</head>

<body class="text-center">
	<main class="form-signin w-100 m-auto">

		<form action="/admin/login.do" method="post">
			<img class="mb-4"
				src="https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg"
				alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">로그인</h1>
			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput" name="memberId">
				<label for="floatingInput">아이디</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					name="memberPwd"> <label for="floatingPassword">비밀번호</label>
			</div>

			<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
			
			<a href="/admin/registerForm.do">관리자
					등록</a>

		</form>
	</main>
</body>
</html>