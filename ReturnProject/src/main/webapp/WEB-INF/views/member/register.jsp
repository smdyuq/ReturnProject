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
	<main>
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4"
				src="https://getbootstrap.kr/docs/5.2/assets/brand/bootstrap-logo.svg"
				alt="" width="72" height="57">
			<h2>회원가입</h2>
		</div>

		<div class="row g-3">
			<div class="">
				<form action="/member/register.do" method="POST"
					class="needs-validation" novalidate="">
					<div class="row g-3">
						<div class="col-12">
							<label for="memberId" class="form-label">아이디</label> <input
								type="text" class="form-control" id="memberId" name="memberId"
								onkeyup="checkId()" placeholder="">
							<div class="invalid-feedback">아이디</div>
							<span id="idMsg"></span>
						</div>

						<div class="col-12">
							<label for="password" class="form-label">비밀번호</label> <input
								type="password" class="form-control" id="password"
								name="memberPwd" onkeyup="validatePassword()" value=""
								required="">
							<div class="invalid-feedback">비밀번호</div>
							<span id="pwdMsg"></span>
						</div>

						<div class="col-12">
							<label for="passwordChk" class="form-label">비밀번호 확인</label> <input
								type="password" class="form-control" id="passwordChk"
								onkeyup="validatePassword()" required="">
							<div class="invalid-feedback">비밀번호 확인</div>
							<span id="pwdChkMsg"></span>
						</div>

						<div class="col-12">
							<label for="name" class="form-label">이름</label> <input
								type="text" class="form-control" id="name" name="memberName"
								placeholder="" required="">
							<div class="invalid-feedback">이름</div>
						</div>

						<label for="member-phone">휴대폰 번호</label>
						<div class="input-wrapper">
							<input type="number" id="memberPhone" name="memberPhone"
								onkeyup="" placeholder="숫자만 입력해주세요." required>
							<button type="button" id="sendPhoneNumber">인증요청</button>
						</div>

						<!-- 인증 요청 성공하면 보이게  -->
						<div id="verificationSection" style="display: none;">
							<input type="number" placeholder="인증번호를 입력해주세요."
								id="verificationCode">
							<button type="button" id="sendPhoneNumber"
								onclick="randomExample()">인증하기</button>

						</div>

						<button class="w-100 btn btn-primary btn-lg" type="submit"
							id="submit-btn" disabled>등록</button>
				</form>
			</div>
		</div>
	</main>
</body>
</html>

<script>
	let pwdFlag = false;
	let pwdCheckFlag = false;
	let idFlag = false;
	let phoneFlag = false;

	var verificationCode = "";

	function flagCheck() {
		let submitBtn = document.getElementById('submit-btn');
		if (pwdFlag && idFlag && pwdCheckFlag && phoneFlag) {
			submitBtn.removeAttribute("disabled");
		} else {
			submitBtn.setAttribute("disabled", "true");
		}
	}

	// 아이디 중복 확인 Ajax
	function checkId() {
		const memberId = $("#memberId").val();
		const idMsg = $("#idMsg");
		/* 아이디는 영문 대소문자와 숫자로만 구성되어야 하며 4자 이상 16자 이하여야 합니다. */
		const idRegex = /^[A-Za-z0-9]{4,16}$/;

		if (idRegex.test(memberId)) {
			$.ajax({
				type : "POST",
				url : "/member/checkId.do",
				data : {
					memberId : memberId
				},
				success : function(response) {
					if (response == "available") {
						idMsg.html("사용 가능한 아이디입니다.").css("color", "green");
						idFlag = true;
					} else {
						console.log(response);
						idMsg.html("이미 사용중인 아이디입니다.").css("color", "red");
						idFlag = false;
					}
				},
				error : function() {
				}
			});
		} else {
			idMsg.html("아이디 형식이 맞지 않습니다.").css("color", "red");
			idFlag = false;
		}

		flagCheck();
	}

	// 비밀번호 유효성 검사
	function validatePassword() {
		/* 비밀번호는 영문 대소문자, 숫자, 특수 문자만 사용하여 8자 이상 20자 이하여야 합니다. */
		const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[@$!%*?&\#])[A-Za-z\d@$!%*?&\#]{8,20}$/;
		const password = document.getElementById("password").value;
		const msg = document.getElementById("pwdMsg");

		const passwordChk = document.getElementById("passwordChk").value;
		const pwdChkMsg = document.getElementById("pwdChkMsg");

		if (passwordRegex.test(password)) {
			msg.innerHTML = "사용 가능한 비밀번호입니다.";
			msg.style.color = "green";
			pwdFlag = true;
		} else {
			msg.innerHTML = "패스워드 정책에 맞지 않습니다.";
			msg.style.color = "red";
			pwdFlag = false;
		}

		if (password === passwordChk) {
			pwdChkMsg.innerHTML = "패스워드가 동일합니다.";
			pwdChkMsg.style.color = "green";
			pwdCheckFlag = true;
		} else {
			pwdChkMsg.innerHTML = "패스워드가 동일하지 않습니다.";
			pwdChkMsg.style.color = "red";
			pwdCheckFlag = false;
		}

		flagCheck();
	}

	//	인증번호
	$('#sendPhoneNumber').click(function(e) {
		e.preventDefault(); // 기본 이벤트를 막음 (페이지 리로드 방지)

		let phoneNumber = $('#memberPhone').val();

		$.ajax({
			type : "POST",
			url : "/send-one",
			data : {
				"memberPhone" : phoneNumber
			},
			success : function(res) {
				// 인증번호 발송 성공 시 처리
				alert("인증번호를 발송하였습니다.");
				verificationCode = res; // verificationCode 값을 res로 받음
				console.log(verificationCode);
			},
			error : function(err) {
				// 인증번호 발송 실패 시 처리
				alert("인증번호 발송에 실패하였습니다.");
				console.log("err");
			}
		})
	});

	// 인증 요청 버튼 클릭 시 처리
	document
			.getElementById("sendPhoneNumber")
			.addEventListener(
					"click",
					function() {
						// 여기에 인증 요청 처리하는 코드 작성
						// 인증 요청 성공 시 아래의 코드를 사용하여 인증 섹션을 보여줌
						document.getElementById("verificationSection").style.display = "block";
					});

	// 인증하기 버튼 클릭 시 처리
	function randomExample() {
		var enteredCode = document.getElementById("verificationCode").value; // 입력한 인증번호 가져오기

		// 서버에서 받은 랜덤 문자열을 verificationCode 변수에 할당하는 코드 작성

		if (enteredCode === verificationCode) {
			// 인증번호가 일치하는 경우
			// 성공 처리를 여기에 작성
			alert("인증에 성공하였습니다.")
			phoneFlag = true;

		} else {
			// 인증번호가 일치하지 않는 경우
			// 실패 처리를 여기에 작성
			alert("인증에 실패하였습니다.")
			phoneFlag = false;
		}
		flagCheck();
	}
</script>