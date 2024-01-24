package kr.co.three.sales.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesDTO {
	private int salesNo;
	private String salesName;
	private String salesCategory;
	private String salesAddress;
	private String salesCondition;
	private int salesPrice;
	private int salesDelivery;
	private String salesComment;
	private int salesCount;
	private String salesImageName;
	private String salesImagePath;
	private Date salesDate;
	private Date salesUpdateDate;
	private Date salesDeleteDate;
	private int salesComplete;
	private int memberNo;

	private String searchText = "";
}
