package kr.co.three.pay.service;

import kr.co.three.pay.dto.PayDTO;

public interface PayService {

//	직거래용 페이 테이블 인설트
	int insertDirectPay(PayDTO pay);

//	택배거래용 페이 테이블 인설트
	int insertDeliveryPay(PayDTO pay);

}