package kr.co.three.pay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayDTO {
	private int payNo;
	private String payReceipt;
	private String payAddress;
	private String payMethod;
	private String paySubAddress;
	private int payAllPrice;
	private int memberNo;
	private int salesNo;
}