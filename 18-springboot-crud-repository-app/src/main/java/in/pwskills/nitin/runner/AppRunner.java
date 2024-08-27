package in.pwskills.nitin.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IStudentDao;
import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.exception.StudentRecordNotFoundException;

@Component
public class AppRunner implements CommandLineRunner{

	@Autowired
	IStudentDao dao;
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(dao.getClass().getName());
		
		//dao.save(new Student(10,"Lovedeep","Charkhi Dadri",21));
		
		/*Student s1=new Student(11, "Nitin", "Charkhi Dadri", 19);
		Student s2=new  Student(20,"Abhishek","Hissar",21);
		Student s3=new Student(14,"praveen","Rewari",19);
		dao.saveAll(List.of(s1,s2,s3)).forEach(System.out::println);*/
		
		//dao.findAll().forEach(System.out::println);
		
		/*dao.findAllById(List.of(10,11)).forEach(System.out::println);
		 * 
		if(dao.existsById(10))//to check that Entity exist or not {
			System.out.println(dao.findById(10).get());// To get the id by id
		}*/
		
		//Student stude=dao.findById(17).orElseThrow(()->new StudentRecordNotFoundException("Student Not Found"));
		//System.out.println(stude);
		
		//long count=dao.count();
		//System.out.println("Number of entities in Student table "+count);
	}

}
