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
	
		//dao.fatchBook(1400.0).forEach(System.out::println);
		//dao.fetchBookNames().forEach(System.out::println);
		//dao.fetchBookDetalis(1399.0).forEach(System.out::println);
		//dao.fetchAllBook().forEach(System.out::println);
		/*dao.fetchBookObject(3).forEach((obj)->{
			for(Object ob:obj) {
				System.out.println(ob);
			}
		});*/
		System.out.println(dao.deleteRecord(4));;
		System.out.println(dao.updateRecord("somfiker", 2));;
	}
	

}
