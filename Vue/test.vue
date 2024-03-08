            <template>

            </template>

            <script>
            // 택배 거래 script
            // 카카오 결제

            var IMP = window.IMP;
            IMP.init("imp32178125");

            var today = new Date();
            var hours = today.getHours(); // 시
            var minutes = today.getMinutes();  // 분
            var seconds = today.getSeconds();  // 초
            var milliseconds = today.getMilliseconds();
            var makeMerchantUid = hours + minutes + seconds + milliseconds;


            function kakaoPay() {

                var buyer_addr = document.getElementById("sample6_address").value;
                var buyer_postcode = document.getElementById("sample6_postcode").value;
                var salesCount = document.getElementById("purchaseQuantity").value;
                var salesCountHidden = document.getElementById("salesCountHidden");

                salesCountHidden.value = salesCount;


                IMP.request_pay({
                    pg: 'kakaopay.TC0ONETIME',
                    pay_method: "card",
                    merchant_uid: "IMP" + makeMerchantUid,
                    name: '${salesCheck.salesName}',
                    amount: (${ salesCheck.salesPrice } * salesCountHidden.value) + ${ salesCheck.salesDelivery },
                buyer_id: '${member.memberId}',
                    buyer_name : '${member.memberName}',
                        buyer_tel : '${member.memberPhone}',
                            buyer_addr : buyer_addr,
                                buyer_postcode : buyer_postcode

            }, function(response) {

                const { status, err_msg } = response;
                if (err_msg) {
                    alert(err_msg);
                }
                if (status === "paid") {
                    $.ajax({
                        url: "/paySmsController", // 이 URL은 paySmsController의 실제 경로를 나타내야 합니다.
                        type: "POST", // 또는 "GET", "PUT" 등이 될 수 있습니다. 이는 서버 측 설정에 따라 달라집니다.
                        success: function (response) {
                            // 서버에서 응답이 올 경우 이 함수가 호출됩니다.
                            // 필요하다면 여기에 로직을 추가할 수 있습니다.
                            if (response === "success") {
                                document.getElementById("salesCountHidden").value = salesCountHidden.value;
                                document.getElementById("payForm").submit();

                            }
                            /*  window.location.href = "/pay/payComplete"; */
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
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
            $(document).ready(function () {
                $('#purchaseQuantity').on('input', function () {
                    var max = parseInt($(this).attr('max'));
                    var min = parseInt($(this).attr('min'));
                    var curr = parseInt($(this).val());

                    if (curr > max) {
                        $(this).val(max);
                    } else if (curr < min) {
                        $(this).val(min);
                    }
                });
            });
            $(document).ready(function () {
                $('#purchaseQuantity').on('input', function () {
                    var max = parseInt($(this).attr('max'));
                    var min = parseInt($(this).attr('min'));
                    var curr = parseInt($(this).val());

                    if (curr > max) {
                        $(this).val(max);
                    } else if (curr < min) {
                        $(this).val(min);
                    }

                    var salesPrice = ${ salesCheck.salesPrice }; // 상품 가격
                    var salesDelivery = ${ salesCheck.salesDelivery }; // 배송비
                    var totalValue = (salesPrice * curr) + salesDelivery; // 합계 계산

                    $('#totalValue').text(totalValue); // 합계 업데이트
                });
            });/* 주문 수량 */
            /* 주소 api */
            function sample6_execDaumPostcode() {
                new daum.Postcode({
                    oncomplete: function (data) {
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
                        if (data.userSelectedType === 'R') {
                            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                extraAddr += data.bname;
                            }
                            // 건물명이 있고, 공동주택일 경우 추가한다.
                            if (data.buildingName !== '' && data.apartment === 'Y') {
                                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                            }
                            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                            if (extraAddr !== '') {
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
            }

            </script>