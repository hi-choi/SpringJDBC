package hi_choi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hi_choi.spring.service.BookService;
import hi_choi.spring.vo.Book;

public class BookSpringApp02 {
public static void main(String[] args) {
		
		// 컨트롤러 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springjdbc02.xml");

		// 빈 호출
		BookService bsrv = (BookService) ctx.getBean("bsrv02");
		
		// 회원 데이터 생성 후 DB에 저장
		bsrv.newBook();
		
		// 회원 데이터 전체 조회
		bsrv.readBook();
		
		// 회원 데이터 상세 조회
		bsrv.readOneBook(35);
		
		// 회원 데이터 수정
		//Book b = new Book(33,"스프링기초","금빛",30000);
		//bsrv.modifyBook(b);
		
		// 회원 데이터 삭제
		//bsrv.removeBook(75);
		
}

}
