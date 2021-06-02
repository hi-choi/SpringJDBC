package hi_choi.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hi_choi.spring.vo.Book;

@Repository("bdao02")
public class BookDAO02Impl implements BookDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertBook(Book b) {
		
		return sqlSession.insert("book.insertBook",b);
		
	}

	@Override
	public List<Book> selectAllBook() {
		return sqlSession.selectList("book.selectAllBook");
	}

	@Override
	public Book selectOneBook(int i) {
		return sqlSession.selectOne("book.selectOneBook",i);
	}

	@Override
	public int updateBook(Book b) {
		return sqlSession.update("book.updateBook",b);
		

	}

	@Override
	public int deleteBook(int i) {
		return sqlSession.delete("book.deleteBook",i);
		
		
	}
	
	

}
