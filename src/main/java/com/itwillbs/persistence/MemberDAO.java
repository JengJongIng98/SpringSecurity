package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository("memberDao")
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	public MemberVO getMemberAuth(String userid) throws Exception{
		
		return sqlSession.selectOne("com.itwillbs.mappers.MemberMapper.getMemberAuth",userid);
		
	}
	
}
