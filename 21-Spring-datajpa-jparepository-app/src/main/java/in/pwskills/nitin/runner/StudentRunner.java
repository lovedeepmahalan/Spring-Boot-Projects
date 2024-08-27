package in.pwskills.nitin.runner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IStudentDao;
import in.pwskills.nitin.entity.Student;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		dao.saveAll(
					Arrays.asList(new Student("sachin", 300.0, new Date()), new Student("dhoni", 400.0, new Date()),
							new Student("kohli", 300.0, new Date()), new Student("rohith", 400.0, new Date()))
				);
		
		Student stud=new Student();
		stud.setStdFee(300.0);
		stud.setStdName("Kohli");
		dao.findAll(Example.of(stud)).forEach(System.out::println);

	}

}
