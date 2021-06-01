package hi_choi.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hi_choi.spring.vo.Member;
import hi_choi.spring.vo.SungJuk;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

	//API를 사용하기 위한 스프링 JDBC Template를 불러올 변수 선언
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//삽입
	@Override
	public void insertMember(Member mb) {
		String sql = " insert into member (userid, passwd, name, email) values (?,?,?,?) ";
		
		// 전달받은 값을 params에 저장
		Object[] params = new Object[] {
			mb.getUserid(), mb.getPasswd(), mb.getName(), mb.getEmail()
		};
		
		// sql에 전달해 DB에 반영
		int cnt = jdbcTemplate.update(sql, params);
		if(cnt>0) System.out.println("회원이 새로 추가되었습니다.");
		
	}

	//전체조회
	@Override
	public List<Member> selectAllMember() {
		String sql = " select mno, userid, name, joindate from member ";
		
		RowMapper<Member> mapper = new MemberMapper();
		
		
		return jdbcTemplate.query(sql, mapper);
	}
	
	private class MemberMapper implements RowMapper<Member>{

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String joindate = rs.getString("joindate").substring(0,10);
			Member mb = new Member(mno, userid, "", name, "", joindate);
			
			return mb;
		}
		
	}

	@Override
	public Member selectOneMember(int mno) {
		String sql = " select * from member where mno = ? ";

		Object[] params = new Object[] { mno };
		
		RowMapper<Member> mapper = new MemberOneMapper();
		
		return jdbcTemplate.queryForObject(sql, params, mapper);
	}

	protected class MemberOneMapper implements RowMapper<Member>{

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String email = rs.getString("Email");
			String joindate = rs.getString("joindate");
			
			Member mb = new Member(mno,userid,"",name,email,joindate);
			
			return mb;
		}
		
	}

	@Override
	public void updateMember(Member mb) {
		String sql = " update member set passwd = ?, name = ?, email= ? where mno = ? ";
		
		//매개변수 지정
		Object[] params = new Object [] {
			mb.getPasswd(), mb.getName(), mb.getEmail(), mb.getMno()};
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if (cnt > 0) System.out.println("데이터 수정이 완료되었습니다.");
		
	}

	@Override
	public void deleteMember(int mno) {
		String sql = " delete from member where mno = ? ";
		Object[] params = new Object[] {mno};
		
		int cnt = jdbcTemplate.update(sql,params);
		if(cnt>0) System.out.println("데이터 삭제가 완료되었습니다.");
				
		
	}
	


}
