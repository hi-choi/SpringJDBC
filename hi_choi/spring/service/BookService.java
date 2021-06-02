package hi_choi.spring.service;

import java.util.List;

import hi_choi.spring.vo.Book;

public interface BookService {

	void newBook();

	List<Book> readBook();

	Book readOneBook(int i);

	void modifyBook(Book b);

	void removeBook(int bookid);

}
