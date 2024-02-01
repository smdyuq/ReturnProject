package kr.co.three.board.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class boardDTO {
	
	private int ask_no;
	private String ask_title;
	private String ask_content;
	private Date ask_date;
	private String ask_image_path;
	private String ask_image_name;
	private int member_no;
	
	
	private String searchText = "";
	private String searchCategory = "";
	
//	private String uploadPath; // 파일 경로
//	private String uploadName; // 수정된 파일 이름
//	private String uploadOriginName; // 원본 파일 이름
}
