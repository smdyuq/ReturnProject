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

	
	@Override
	public int CommentRegist(ReplyDTO reply) {
		return replyDao.CommentRegist(sqlSession, reply);
		
	}

	@Override
	public List<ReplyDTO> getList(int ask_no) {
		return replyDao.getList(sqlSession,ask_no);
	}

	@Override
	public int commentDelete(ReplyDTO reply) {
		return replyDao.commentDelete(sqlSession, reply);
	}
	
}

