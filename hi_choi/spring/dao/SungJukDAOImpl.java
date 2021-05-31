package hi_choi.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = " insert into sungjuk (name, kor, eng, mat, tot, mean, grd) values (?,?,?,?,?,?,?) ";
		Object[] params = new Object[] {
			sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(),
			sj.getTot(), sj.getAvg(), sj.getGrd()+""
		};
		
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if (cnt >0) System.out.println("성적 추가됨!");
	}

	@Override
	public List<SungJuk> selectAllSungJuk() {
		String sql= " select name, kor, eng, mat from sungjuk " + " order by sjno desc ";
		RowMapper<SungJuk> mapper = new SungJukMapper();
		// 콜백 클래스만 등록하고 호출/실행은 따로하지 않음
		// 단, query 메서드가 실행하는 동안
		// rs.next가 참인 경우 IoC컨테이너가 mapper 객체의 
		// mapRow를 호출함
		
		return jdbcTemplate.query(sql, mapper);
	}
	// 성적데이터를 출력하기 위한 RowMapper 클래스
	protected class SungJukMapper implements RowMapper<SungJuk>{

		@Override
		public SungJuk mapRow(ResultSet rs, int num) throws SQLException {
			
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			SungJuk sj = new SungJuk(name, kor, eng, mat);
			
			return sj;
		}
		
	}
	@Override
	public SungJuk selectOneSungJuk(int sjno) {
		String sql = " select * from sungjuk where sjno = ? ";
		
		Object[] params = new Object[] { sjno };
		
		RowMapper<SungJuk> mapper = new SungJukOneMapper();
		// 콜백 클래스만 등록하고 호출/실행은 따로하지 않음
		// 단, query 메서드가 실행하는 동안
		// rs.next가 참인 경우 IoC컨테이너가 mapper 객체의 
		// mapRow를 호출함	
		
		return jdbcTemplate.queryForObject(sql, params, mapper);
	}

	protected class SungJukOneMapper implements RowMapper<SungJuk>{

			
		
		@Override
		public SungJuk mapRow(ResultSet rs, int arg1) throws SQLException {
			
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			
			SungJuk sj = new SungJuk(name, kor, eng, mat);
			sj.setTot(rs.getInt("tot"));
			sj.setAvg(rs.getInt("mean"));
			sj.setGrd(rs.getString("grd").charAt(0));
			
			return sj;
		}
	}
	@Override
	public void updateSungJuk(SungJuk sj) {
		String sql = " update sungjuk set kor = ?, eng = ?, mat= ?, tot = ?, mean = ?, grd = ? where sjno = ? ";
		
		//매개변수 지정
		Object[] params = new Object [] {
			sj.getKor(), sj.getEng(), sj.getMat(), sj.getTot(), sj.getAvg(), sj.getGrd()+"", sj.getSjno()
		};
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if (cnt > 0) System.out.println("수정완료!!");
		
	}

	@Override
	public void deleteSungJuk(int sjno) {
		String sql = " delete from sungjuk where sjno = ? ";
		Object[] params = new Object[] {sjno};
		
		int cnt = jdbcTemplate.update(sql,params);
		if(cnt>0) System.out.println("데이터 삭제 완료");
				
		
	}
	
}
