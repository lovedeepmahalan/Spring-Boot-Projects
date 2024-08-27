package in.pwskills.nitin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.pwskills.nitin.entity.Book;
import jakarta.transaction.Transactional;

public interface IBookdao extends JpaRepository<Book,Integer> {
	
	@Query("from Book WHERE bookCost>=:cost")//we have to use entity name instead of table name
	public List<Book> fatchBook(Double cost);
	
	@Query("FROM Book")
	public List<Book> fetchAllBook();
	
	@Query("select bookName from Book")
	public List<String> fetchBookNames();
	
	@Query("FROM Book WHERE bookCost>=:cost")
	public List<Book> fetchBookDetalis(@Param("cost") double bookCost);//here cost and bookCost are different so to sinc then we have to use @Param
		
	@Query("SELECT bookName,bookCost FROM Book where bookId >:id")
	public List<Object[]> fetchBookObject(Integer id);
	
	@Query("DELETE FROM Book WHERE bookId > :id")
	@Modifying//this specify that this query modify the database
	@Transactional//this is for transaction commit or Rollback
	public int deleteRecord(int id);
	
	@Query("update Book set bookName =:name where bookId=:id")
	@Modifying
	@Transactional
	public int updateRecord(String name,int id);
}
