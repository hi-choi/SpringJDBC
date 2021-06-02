package hi_choi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hi_choi.spring.service.MemberService;


public class MemberSpringJDBCApp02 {


	public static void main(String[] args) {
		
		// 컨트롤러 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springjdbc02.xml");

		// 빈 호출
		MemberService msrv = (MemberService) ctx.getBean("msrv02");
		
		// 회원 데이터 생성 후 DB에 저장
		//msrv.newMember();
		
		// 회원 데이터 전체 조회
		//msrv.readAllMember();
		
		// 회원 데이터 상세 조회
		//msrv.readOneMember(7);
		
		// 회원 데이터 수정
		msrv.modifyMember();
		
		// 회원 데이터 삭제
		//msrv.removeMember();
		
}
}