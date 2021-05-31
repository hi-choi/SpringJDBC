package hi_choi.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hi_choi.spring.vo.SungJuk;

//SungJukDAO 인터페이스의 메서드를 구체화하는 클래스
@Repository("sjdao")
public class SungJukDAOImpl implements SungJukDAO {

	//API를 사용하기 위한 스프링 JDBC Template를 불러올 변수 선언
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertSungJuk(SungJuk sj) {
		String sql = "insert into sungjuk (name, kor, eng, mat, tot, mean, grd) values (?,?,?,?,?,?,?)";
		Object[] params = new Object[] {
			sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(),
			sj.getTot(), sj.getAvg(), sj.getGrd()+""
		};
		
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if (cnt >0) System.out.println("성적 추가됨!");
	}

}
