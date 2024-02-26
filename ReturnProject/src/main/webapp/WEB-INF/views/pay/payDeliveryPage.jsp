<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>택배거래 결제 확인 페이지</title>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<!-- 주소 api -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form action="/pay/payDeliveryComplete.do" method="POST" id="payForm">
		<h2>택배거래</h2>
		<hr>

		<div>
			<input type="hidden" value="${salesCheck.salesNo }" name="salesNo">
			<input type="hidden" value="1" id="salesCountHidden"
				name="salesCount">
			<p>상품 이미지</p>
			<img src="/resources/uploads/${salesCheck.imageName}">
			<hr>

			<p>상품 명</p>
			<p>${salesCheck.salesName }</p>

			<hr>
			<hr>
			<label>거래 방법:</label> <a>택배 거래</a>
			<hr>
			<div id="productDiv">
				<p>상품 가격</p>
				<input value="${salesCheck.salesPrice }" name="salesPrice">
				<hr>
				<p>구매 수량</p>
				<input type="number" id="purchaseQuantity" min="1"
					max="${salesCheck.salesCount}" value="1" name="salesCount">

				<p>배송비</p>
				<input value="${salesCheck.salesDelivery }" name="salesDelivery">
				<hr>
				<!-- 합계 = 상품가격 * 구매 수량 + 배송비 -->
				<p id="total">
					합계: <span id="totalValue">${salesCheck.salesPrice + salesCheck.salesDelivery }</span>
				</p>

				<p id="deliveryAddress">배송지 :</p>
				<input type="text" id="sample6_postcode" placeholder="우편번호">
				<input type="button" onclick="sample6_execDaumPostcode()"
					value="우편번호 찾기"><br> <input type="text"
					id="sample6_address" placeholder="주소" name="payAddress"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소"
					name="paySubAddress"> <input type="text"
					id="sample6_extraAddress" placeholder="참고항목">
	</form>
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
/* 카카오 결제 */
        var IMP = window.IMP; 
        IMP.init("imp32178125"); 
      
        var today = new Date();   
        var hours = today.getHours(); // 시
        var minutes = today.getMinutes();  // 분
        var seconds = today.getSeconds();  // 초
        var milliseconds = today.getMilliseconds();
        var makeMerchantUid = hours +  minutes + seconds + milliseconds;
        

        function kakaoPay() {

            var buyer_addr = document.getElementById("sample6_address").value;
            var buyer_postcode = document.getElementById("sample6_postcode").value;
            var salesCount = document.getElementById("purchaseQuantity").value;
            var salesCountHidden = document.getElementById("salesCountHidden");
            
            salesCountHidden.value = salesCount;
            

            IMP.request_pay({
                pg : 'kakaopay.TC0ONETIME',
                pay_method: "card",
                merchant_uid: "IMP"+makeMerchantUid, 
                name : '${salesCheck.salesName}',
                amount : (${salesCheck.salesPrice} * salesCountHidden.value) + ${salesCheck.salesDelivery },
                buyer_id : '${member.memberId}',
                buyer_name : '${member.memberName}',
                buyer_tel : '${member.memberPhone}',
                buyer_addr : buyer_addr,
                buyer_postcode : buyer_postcode

            }, function(response){
            	
            	const {status, err_msg} = response;
            	if(err_msg){
            		alert(err_msg);
            	}
            	if(status === "paid"){
            		  $.ajax({
            	            url: "/paySmsController", // 이 URL은 paySmsController의 실제 경로를 나타내야 합니다.
            	            type: "POST", // 또는 "GET", "PUT" 등이 될 수 있습니다. 이는 서버 측 설정에 따라 달라집니다.
            	            success: function(response) {
            	                // 서버에서 응답이 올 경우 이 함수가 호출됩니다.
            	                // 필요하다면 여기에 로직을 추가할 수 있습니다.
            	                if(response === "success") {
            	                	document.getElementById("salesCountHidden").value = salesCountHidden.value;
            	                	document.getElementById("payForm").submit();
            	                	
            	                }
            	               /*  window.location.href = "/pay/payComplete"; */
            	            },
            	            error: function(jqXHR, textStatus, errorThrown) {
            	                // 서버에서 오류 응답이 올 경우 이 함수가 호출됩니다.
            	                // 필요하다면 여기에 오류 처리 로직을 추가할 수 있습니다.
            	                /* console.error(textStatus, errorThrown); */
            	            	window.location.href = "/pay/payError.do";
            	            }
            	})
            }
            })
           }; /* 카카오 결제 */
        
            /* 주문 수량 */
            $(document).ready(function(){
                $('#purchaseQuantity').on('input', function(){
                    var max = parseInt($(this).attr('max'));
                    var min = parseInt($(this).attr('min'));
                    var curr = parseInt($(this).val());

                    if(curr > max) {
                        $(this).val(max);
                    } else if(curr < min) {
                        $(this).val(min);
                    }
                });
            });
            $(document).ready(function(){
                $('#purchaseQuantity').on('input', function(){
                    var max = parseInt($(this).attr('max'));
                    var min = parseInt($(this).attr('min'));
                    var curr = parseInt($(this).val());

                    if(curr > max) {
                        $(this).val(max);
                    } else if(curr < min) {
                        $(this).val(min);
                    }

                    var salesPrice = ${salesCheck.salesPrice}; // 상품 가격
                    var salesDelivery = ${salesCheck.salesDelivery}; // 배송비
                    var totalValue = (salesPrice * curr) + salesDelivery; // 합계 계산

                    $('#totalValue').text(totalValue); // 합계 업데이트
                });
            });/* 주문 수량 */
            /* 주소 api */
            function sample6_execDaumPostcode() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                        var addr = ''; // 주소 변수
                        var extraAddr = ''; // 참고항목 변수

                        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                            addr = data.roadAddress;
                        } else { // 사용자가 지번 주소를 선택했을 경우(J)
                            addr = data.jibunAddress;
                        }

                        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                        if(data.userSelectedType === 'R'){
                            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                extraAddr += data.bname;
                            }
                            // 건물명이 있고, 공동주택일 경우 추가한다.
                            if(data.buildingName !== '' && data.apartment === 'Y'){
                                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                            }
                            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                            if(extraAddr !== ''){
                                extraAddr = ' (' + extraAddr + ')';
                            }
                            // 조합된 참고항목을 해당 필드에 넣는다.
                            document.getElementById("sample6_extraAddress").value = extraAddr;
                        
                        } else {
                            document.getElementById("sample6_extraAddress").value = '';
                        }

                        // 우편번호와 주소 정보를 해당 필드에 넣는다.
                        document.getElementById('sample6_postcode').value = data.zonecode;
                        document.getElementById("sample6_address").value = addr;
                        // 커서를 상세주소 필드로 이동한다.
                        document.getElementById("sample6_detailAddress").focus();
                    }
                }).open();
            }/* 주소 api */
            
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

