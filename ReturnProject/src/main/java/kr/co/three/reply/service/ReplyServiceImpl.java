package kr.co.three.reply.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.reply.dao.ReplyDAO;
import kr.co.three.reply.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired 
	private ReplyDAO replyDao;

	//댓글 등록
	@Override
	public int CommentRegist(ReplyDTO reply) {
		return replyDao.CommentRegist(sqlSession, reply);
		
	}
	//댓글 리스트 불러오기
	@Override
	public List<ReplyDTO> getList(int ask_no) {
		return replyDao.getList(sqlSession,ask_no);
	}
	//댓글 삭제(미구현)
	@Override
	public int commentDelete(ReplyDTO reply) {
		return replyDao.commentDelete(sqlSession, reply);
	}
	

	
}

