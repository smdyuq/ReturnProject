package kr.co.three.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class boardDTO {
	
	private int ASK_NO;
	private String ASK_TITLE;
	private String ASK_CONTENT;
	private String ASK_DATE;
	private String ASK_IMAGE_PATH;
	private String ASK_IMAGE_NAME;
	private int MEMBER_NO;
	
	
	private String searchText = "";
	private String searchCategory = "";
	
//	private String uploadPath; // 파일 경로
//	private String uploadName; // 수정된 파일 이름
//	private String uploadOriginName; // 원본 파일 이름
}
