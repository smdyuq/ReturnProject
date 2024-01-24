package kr.co.three.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter // 게터
@AllArgsConstructor // 모든 매개변수가 있는 생성자
public class PageInfo {
	private int listCount;
	private int cpage;
	private int pageLimit;
	private int boardLimit;

	private int maxPage;
	private int startPage;
	private int endPage;
	private int offset;
}
