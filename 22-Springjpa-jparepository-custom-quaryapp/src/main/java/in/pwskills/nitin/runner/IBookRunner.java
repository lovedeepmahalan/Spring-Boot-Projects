package in.pwskills.nitin.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IBookdao;
import in.pwskills.nitin.entity.Book;

@Component
public class IBookRunner implements CommandLineRunner {

	@Autowired
	IBookdao dao;
	@Override
	public void run(String... args) throws Exception {
		/*dao.saveAll(Arrays.asList(new Book("CoreJava", "Misker", 2599.0,"BackEnd"),new Book("HTML", "SOHIMAK", 1200.0, "frontend")
				,new Book("Hibernate","Comberk",1100.0,"BackEnd"),new Book("Microservices","Nicromet",2300.0,"Backend")
				,new Book("MYSQL","Korth",900.0,"DataBase"),new Book("Java Script","somprhk",1400.0,"FrontEnd")));
		*/
		
		//dao.findByAuthor("Comberk").forEach(System.out::println);

		//dao.findByBookCostGreaterThanEqual(1700.0).forEach(System.out::println);;
		
		//dao.findByBookIdIn(List.of(2,4)).forEach(System.out::println);
		
		//dao.findByBookIdBetween(2,3).forEach(System.out::println);
		
		//dao.findByBookIdLessThanEqualOrBookTypeLike(2, "%Back%").forEach(System.out::println);
		
		//dao.findByBookCostNotAndAuthorNotLike(1200.0, "%B%").forEach(System.out::println);
		
		//dao.findByAuthorIsNotNull().forEach(System.out::println);
		
		//dao.findByAuthorIsNull().forEach(System.out::println);
		
		dao.findByBookId(3).ifPresentOrElse(System.out::println, ()->System.out.println("Data Notfound"));
;	}

}
