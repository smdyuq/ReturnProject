<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko" class="h-100">
<head>
<%@ include file="../../common/head.jsp"%>
<%@ include file="../common/smarteditor.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
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

			<div class="comment_Box" style="border: 1px solid gray;">
				<!-- 댓글이 들어갈 박스 -->

			</div>

			<div class="comment-box">

				<div class="comment-count">댓글</div>

				<!-- <span class="c-icon"><i class="fa-solid fa-user"></i>  -->
				<div class="comment-name">
					<span class="anonym">작성자 : <input type="text"
						class="form-control" id="com_writer" placeholder="이름"
						name="com_writer" value='관리자' readonly
						style="width: 100px; border: none;">
					</span>
				</div>

				<!-- </span> -->
				<!--<img src="/익명.jpg" width ="50px" alt="My Image"><!-->
				<div class="comment-sbox">
					<textarea class="comment-input" id="com_content" cols="80" rows="2"
						name="com_content"></textarea>
					<!-- <span class="com-function-btn" type="hidden">
                            
                            <a href="#"><i class="fa-solid fa-pen-to-square"></i></a>
                            <a href="#"><i class="fa-solid fa-trash-can"></i></a>
                         </span> -->
				</div>
				<div class="regBtn">
					<button id="Comment_regist">댓글등록</button>
				</div>
</main>
</body>
</html>

<script>
	$('#Comment_regist').click(function() {

		// Json으로 전달할 파라미터 변수 선언
		const com_bno = $
		{
			'ask_no'
		}
		;
		//	const com_writer = $('#com_writer').val();
		const com_content = $('#ask_comment_content').val();

		console.log(com_bno);
		console.log(com_content);

		if (com_writer == '') {
			alert('로그인 후 이용해주세요');
			return;
		} else if (com_content == '') {
			alert('내용을 입력하세요');
			return;
		}

		$.ajax({
			type : 'post',
			url : '<c:url value="/reply/InsertComment"/>',
			data : JSON.stringify({
				"replyDto" : {
					"ask_no" : com_bno,
					"ask_comment_content" : com_content
				}
			}),
			contentType : 'application/json',
			success : function(data) {
				console.log('통신 성공' + data);
				if (data === 'InsertSuccess') {
					alert('댓글 등록이 완료되었습니다.');
					console.log('댓글 등록 완료');
					$('#com_content').val('');
					getList();
				} else {
					alert('로그인 이후 이용해주시기 바랍니다.');
					console.log('댓글 등록 실패');
				}
			},
			error : function() {
				alert('통신 실패');
			}
		}); // 댓글 비동기 끝

	}); // 댓글 등록 이벤트 끝

	getList();

	function getList() {

		const com_bno = $
		{
			ask_no
		}
		;
		const com_content = $('#com_content').val();

		$.getJSON("<c:url value='/reply/CommentList/'/>" + com_bno, function(
				data) {

			if (data.list.length > 0) {
				var list = data.list;
				var comment_html = "<div>";

				/* $('#count').html(data.total);*/
				
				for (i = 0; i < list.length; i++) {
					var content = list[i].reply_content;
					var writer = list[i].reply_writer;
					comment_html += "<div><span id='com_writer'><strong>" + writer + "</strong></span><br/>";
					comment_html += "<span id='com-content'>" + content + "</span><br>";
					
					if (writer === $("#com_writer").val()) {
						comment_html += "<span id='delete' style='cursor:pointer;' data-id=" + content + ">[삭제]</span><br></div><hr>";
					} else {
						comment_html += "</div><hr>";
					}
				} 

				$(".comment_Box").html(comment_html);

			} else {
				var comment_html = "<div>등록된 댓글이 없습니다.</div>";
				$(".comment_Box").html(comment_html);
			}
		}); // getJson
	}
</script>