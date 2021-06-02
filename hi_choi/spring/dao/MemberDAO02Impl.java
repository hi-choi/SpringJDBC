package hi_choi.spring.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import hi_choi.spring.vo.Member;


@Repository("mdao02")
public class MemberDAO02Impl implements MemberDAO{


	@Autowired
	private SqlSession sqlsession;

	//삽입
	@Override
	public void insertMember(Member mb) {
		
		int cnt = sqlsession.insert("member.insertMember",mb);
		if(cnt>0) System.out.println("회원이 새로 추가되었습니다.");
		
	}

	//전체조회
	@Override
	public List<Member> selectAllMember() {
		
		return sqlsession.selectList("member.selectMember");
	}
	


	@Override
	public Member selectOneMember(int mno) {
	
		return sqlsession.selectOne("member.selectOneMember",mno);
	}

	

	@Override
	public void updateMember(Member mb) {
		int cnt = sqlsession.update("member.updateMember",mb);
		if(cnt>0) System.out.println("회원 정보가 변경되었습니다.");
		
	}

	@Override
	public void deleteMember(int mno) {
		int cnt = sqlsession.delete("member.deleteMember",mno);
		if(cnt>0) System.out.println("회원 정보가 삭제되었습니다.");
		
	}
	


}
