package hi_choi.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hi_choi.spring.dao.BookDAO;
import hi_choi.spring.vo.Book;

@Service("bsrv02")
public class BookService02Impl implements BookService {

	@Autowired
	private BookDAO bdao02;
	
	
	@Override
	public void newBook() {
		Book b = new Book(75,"스프링","한울빛",35000);
		int cnt= bdao02.insertBook(b);
		if (cnt>0)System.out.println("도서 등록이 완료되었습니다.");
		
	}

	@Override
	public List<Book> readBook() {
		StringBuffer sb = new StringBuffer();
		List<Book> blist = bdao02.selectAllBook();
		
		for (Book b : blist) {
			sb.append(b);
		}
		System.out.println(sb);
		
		return null;
			
	}

	@Override
	public Book readOneBook(int i) {
		Book b = bdao02.selectOneBook(i);
		System.out.println(b);
		
		return null;
		
	}

	@Override
	public void modifyBook(Book b) {
		int cnt=bdao02.updateBook(b);
		if(cnt>0) System.out.println("도서 정보가 수정되었습니다.");
		
	}

	@Override
	public void removeBook(int bookid) {
		int cnt=bdao02.deleteBook(bookid);
		if(cnt>0) System.out.println("회원 정보가 삭제되었습니다.");
		
	}



}
