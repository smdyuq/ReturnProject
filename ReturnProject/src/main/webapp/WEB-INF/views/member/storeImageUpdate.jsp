<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/member/storeImageUpdate.do" method="POST"
		class="needs-validation" enctype="multipart/form-data">
		<div class="row g-3">
			<div class="col-12">
				<img src="/resources/uploads/303x310/${member.memberImageName }">
				<label for="memberImageName" class="form-label">상품이미지</label> <input
					type="file" class="form-control" id="memberImageName" name="upload">
			</div>

			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>