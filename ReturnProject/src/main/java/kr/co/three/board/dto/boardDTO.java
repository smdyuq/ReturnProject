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
	private int member_no;
	private String member_id;
	private String searchText = "";
	private String searchCategory = "";
	private int commentCount;
}
