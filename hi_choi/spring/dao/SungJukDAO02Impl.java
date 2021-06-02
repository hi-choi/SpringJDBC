package hi_choi.spring.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import hi_choi.spring.vo.SungJuk;

//SungJukDAO 인터페이스의 메서드를 구체화하는 클래스
@Repository("sjdao02")
public class SungJukDAO02Impl implements SungJukDAO {


	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertSungJuk(SungJuk sj) {
		int cnt = sqlSession.insert("sungjuk.insertSungjuk",sj);
		if(cnt>0) System.out.println("회원 정보가 등록되었습니다.");
	}
		

	@Override
	public List<SungJuk> selectAllSungJuk() {
		return sqlSession.selectList("sungjuk.selectSungjuk");
	}

	@Override
	public SungJuk selectOneSungJuk(int sjno) {
		
		return sqlSession.selectOne("sungjuk.selectOneSungjuk",sjno);
	}


	@Override
	public void updateSungJuk(SungJuk sj) {
		int cnt = sqlSession.update("sungjuk.updateSungjuk",sj);
		if(cnt>0) System.out.println("회원 정보가 수정되었습니다.");
		
	}

	@Override
	public void deleteSungJuk(int sjno) {
		int cnt = sqlSession.delete("sungjuk.deleteSungjuk",sjno);
		if(cnt>0) System.out.println("회원 정보가 삭제되었습니다.");
	
}
}
