package hi_choi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hi_choi.spring.dao.MemberDAO;
import hi_choi.spring.vo.Member;
import hi_choi.spring.vo.SungJuk;

@Service("msrv")
public class MemberServiceImpl implements MemberService{

	// MemberDAO의 함수 사용을 위한 변수 선언
	@Autowired
	private MemberDAO mdao;
	
	// 삽입
	@Override
	public void newMember() {
		
		//새로운 객체 생성
		Member mb = new Member("abc123","987xyz","Tom","abc@987");
		
		//생성한 객체를 DAO에 삽입 (why? 데이터베이스에 접근하기 위해서)
		mdao.insertMember(mb);
		System.out.println("회원가입을 완료했습니다.");
	}

	// 전체조회
	@Override
	public void readAllMember() {
		StringBuffer sb = new StringBuffer();
		List<Member> mlist = mdao.selectAllMember();
		
		for (Member m : mlist) {
			sb.append(m);
		}
		System.out.println(sb);
		
	}

	// 상세조회
	@Override
	public void readOneMember(int mno) {
		Member mb = mdao.selectOneMember(mno);
		System.out.println(mb);
		
	}

	// 수정
	@Override
	public void modifyMember() {
		Member mb = new Member("5", null,"789","Jane","hello@789",null);
		
		mdao.updateMember(mb);
		
	}

	// 삭제
	@Override
	public void removeMember() {
		mdao.deleteMember(8);
	}
	


}
