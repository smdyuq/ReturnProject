<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>


</head>
<body>

	<h2>직거래</h2>
	<hr>

	<div>
		<p>상품 이미지</p>
		<img src="/resources/uploads/${salesCheck.salesImageName}">
		<p>${salesCheck.salesImageName}</p>
		<hr>
		<p>상품 명</p>
		<p>${salesCheck.salesName }</p>
		<hr>
		<hr>
		<label>거래 방법:</label> <a>직접 거래</a>
		<hr>
		<div id="productDiv">
			<p>상품 가격</p>
			<p>${salesCheck.salesPrice }</p>
			<hr>
			<input type="hidden" value="${salesCheck.salesDelivery }">
			<hr>
			<!-- 합계 = 상품가격+배송비 -->
			<p id="total">합계: ${salesCheck.salesPrice + salesCheck.salesDelivery }</p>

			<p id="address">거래 지역 : ${salesCheck.salesAddress }</p>
			<hr>
			<p id="PAY_METHOD">결제 수단:</p>
		</div>
	</div>

	<div class="box-footer text-center">
		<button onclick="kakaoPay()">카카오 페이 결제</button>
		<!-- <button onclick="tossPay()">토스 결제</button> -->
		<button type="button" id="btnCancel" class="btn btn-primary">주문취소</button>
	</div>


	<!-- 	<form action="/pay/paying.do" method="POST">

		<button type="submit">결제</button>
	</form> -->
</body>
</html>
<script>
        var IMP = window.IMP; 
        IMP.init("imp32178125"); 
      
        var today = new Date();   
        var hours = today.getHours(); // 시
        var minutes = today.getMinutes();  // 분
        var seconds = today.getSeconds();  // 초
        var milliseconds = today.getMilliseconds();
        var makeMerchantUid = hours +  minutes + seconds + milliseconds;
        

        function kakaoPay() {
            IMP.request_pay({
                pg : 'kakaopay.TC0ONETIME',
                pay_method: "card",
                merchant_uid: "IMP"+makeMerchantUid, 
                name : '${salesCheck.salesName}',
                amount : ${salesCheck.salesPrice + salesCheck.salesDelivery },
                buyer_id : '개똥이',
                buyer_name : '개똥이',
                buyer_tel : '010-1234-5678',
                buyer_addr : '직거래',
                buyer_postcode : '123-456'
            }, function(response){
            	const {status, err_msg} = response;
            	if(err_msg){
            		alert(err_msg);
            	}
            	if(status === "paid"){
            		const {imp_uid} = response;
            		verifyPayment(imp_uid);
            	}
            }
            )};
/*             function tossPay() {
                IMP.request_pay({
                    pg : 'tosspay.tosstest',
                    pay_method : 'card',
                    merchant_uid: makeMerchantUid, //상점에서 생성한 고유 주문번호
                    name : '${salesCheck.salesName}:결제테스트',   //필수 파라미터 입니다.
                    amount : ${salesCheck.salesPrice + salesCheck.salesDelivery },
                    buyer_email : 'iamport@siot.do',
                    buyer_name : '구매자이름',
                    buyer_tel : '010-1234-5678',
                    buyer_addr : '서울특별시 강남구 삼성동',
                    buyer_postcode : '123-456',
                    m_redirect_url : '{결제 완료 후 리디렉션 될 URL}'
                }, function(response){
                	const {status, err_msg} = response;
                	if(err_msg){
                		alert(err_msg);
                	}
                	if(status === "paid"){
                		const {imp_uid} = response;
                		verifyPayment(imp_uid);
                	}
                }); */
    </script>

