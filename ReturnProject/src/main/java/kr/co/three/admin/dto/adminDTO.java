package kr.co.three.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class adminDTO {

	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int memberType;
	private String memberPhone;
	
	
	public adminDTO() {
		super();
	}
}
