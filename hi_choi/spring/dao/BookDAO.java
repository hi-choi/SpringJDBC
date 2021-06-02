package hi_choi.spring.dao;

import java.util.List;

import hi_choi.spring.vo.Book;

public interface BookDAO {

	int insertBook(Book b);

	List<Book> selectAllBook();

	Book selectOneBook(int i);

	int updateBook(Book b);

	int deleteBook(int i);



}
