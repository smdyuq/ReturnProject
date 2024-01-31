package kr.co.three.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.reply.dto.ReplyDTO;

@Repository
public class ReplyDAO {
	
//	댓글 등록
	public int replyEnroll(SqlSessionTemplate sqlSession, ReplyDTO reply) {
		return sqlSession.insert("replyMapper.replyEnroll", reply);
	}
	
	public List<ReplyDTO> list(SqlSessionTemplate sqlSession, int ask_no) {
		return sqlSession.selectList("replyMapper.replyList", ask_no);
	}
}
