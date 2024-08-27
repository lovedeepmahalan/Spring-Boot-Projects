package in.pwskills.nitin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.Book;

public interface IBookdao extends JpaRepository<Book,Integer> {
	//select * from booktab where Author=?
	List<Book> findByAuthor(String name);
	
	//select * from booktab where bcost>=?
	List<Book> findByBookCostGreaterThanEqual(Double price);
	
	//select * from booktab where bid in(?,?)
	List<Book> findByBookIdIn(List<Integer> id);
	
	//select * from booKtab where bid between x and y
	List<Book> findByBookIdBetween(Integer a,Integer b);
	
	//select * from booKtab where bid <= ? or bType like?
	List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer a,String booktype);
	
	//select * from booKtab where bcose!=? and author not like ?
	List<Book> findByBookCostNotAndAuthorNotLike(Double cost,String author);
	
	//SELECT * FROM booktab WHERE bauth IS NULL;
	List<Book> findByAuthorIsNull();
		
	//SELECT * FROM booktab WHERE bauth IS Not NULL;
	List<Book> findByAuthorIsNotNull();
				
	//select * from booktab where bid=?
	Optional<Book> findByBookId(Integer id);
		
}
