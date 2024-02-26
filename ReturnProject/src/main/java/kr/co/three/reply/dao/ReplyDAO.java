package kr.co.three.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.reply.dto.ReplyDTO;

@Repository
public class ReplyDAO {

//	댓글 등록
	public int CommentRegist(SqlSessionTemplate sqlSession, ReplyDTO reply) {
		return sqlSession.insert("replyMapper.CommentRegist", reply);
	}

//	목록 요청
	public List<ReplyDTO> getList(SqlSessionTemplate sqlSession, int ask_no) {
		return sqlSession.selectList("replyMapper.getList", ask_no);
	}
}
