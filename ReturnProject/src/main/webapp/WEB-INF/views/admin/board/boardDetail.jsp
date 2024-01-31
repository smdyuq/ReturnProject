<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko" class="h-100">
<head>
<%@ include file="../../common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="d-flex flex-column h-100" onload="replyData()">
	<!-- Fixed navbar -->
	<%@ include file="/WEB-INF/views/admin/common/header.jsp"%>
	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">
			<h3>상세보기</h3>
			<hr>
			<br />
			<!-- 타이틀 컴포넌트 : components/board/title.vue -->
			<div class="mb-3 justify-content-center">
				<input type="text" class="form-control" name="ask_title"
					id="exampleFormControlInput1" value="${board.ask_title }"
					placeholder="제목을 입력하세요." readonly>
			</div>
			<div class="row mb-3">
				<%--<div class="col-md-4">
		                    <p class="fw-bold">조회수: ${free.views}</p>
		                </div> --%>
				<div class="col-md-4">
					<p class="fw-bold">작성자: ${sessionScope.memberId}</p>
				</div>
			</div>

			<!-- 타이틀 컴포넌트 : components/board/content.vue -->
			<div>${board.ask_content }</div>

			<div class="row">
				<div class="col text-center">
					<button type="button" class="btn btn-danger"
						onclick="history.back()">취소</button>
					<%-- <c:if test="${sessionScope.memberName eq free.writer}"> --%>
					<%-- <button type="submit"
							onclick="location.href='/inquiry/editForm.do?boardIdx=${free.idx}'"
							class="btn btn-primary">수정</button> --%>
					<button type="submit"
						onclick="location.href='/inquiry/delete.do?boardIdx=${ask.ask_no}'"
						class="btn btn-primary">삭제</button>
					<%-- </c:if> --%>
				</div>
				<hr />

				<div id="modal_wrap">
					<!-- 모달 추가 -->
					<div id="first">
						<div style="width: 250px; margin: 0 auto; padding-top: 20px;">
							<form id="frm">
								<input type="hidden" name="write_num"
									value="${member.member_type}"> <b>댓글달기</b>
								<hr>
								<b>작성자 : 관리자</b>
								<hr>
								<b>제목</b><br> <input type="text" id="title" size="30"
									name="title">
								<hr>
								<b>내용</b><br>
								<textarea name="replyContent" id="content" rows="9" cols="30"></textarea>
								<hr>
								<button type="button"
									style="background: white; border-radius: 4px; border-color: white; height: 30px;"
									onclick="reply()">댓글달기</button>
								<button type="button"
									style="background: white; border-radius: 4px; border-color: white; height: 30px;"
									onclick="slide_hide()">취소</button>
							</form>
						</div>
					</div>
				</div>
	</main>
</body>
</html>
<script>
$(function(){
    $("#commentBtn").click(function(){
        $.ajax({
            url: '/comment',
            data: $('#commentForm').serialize(),
            type: 'POST',
            success: function(data){
                $("#commentList").append("<div>"+data.text+"</div>");
            },
            error: function(){
                alert("댓글 작성에 실패하였습니다.");
            }
        });
    });
});
</script>
