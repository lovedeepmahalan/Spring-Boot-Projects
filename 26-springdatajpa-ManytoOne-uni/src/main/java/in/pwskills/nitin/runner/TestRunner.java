package in.pwskills.nitin.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.ICollegedao;
import in.pwskills.nitin.dao.IStudentdao;
import in.pwskills.nitin.entity.College;
import in.pwskills.nitin.entity.Student;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IStudentdao studentdao;
	
	@Autowired
	private ICollegedao collegedao;
	
	@Override
	public void run(String... args) throws Exception {
		
		College coll1=new College(121, "NiitUniversity", "Neemrana");
		College coll2=new College(232, "IIITBahagalpur", "Bihar");
		
		Student stud1=new Student(1, "Lovedeep", "CharkhiDadri", coll1);
		Student stud2=new Student(2,"Nitin","charkhi Dadri",coll2);
		Student stud3=new Student(3,"Alok","Palwal",coll1);
		Student stud4=new Student(4,"Anmika","Chandigarh",coll2);
		
		collegedao.save(coll1);
		collegedao.save(coll2);
		
		studentdao.save(stud1);
		studentdao.save(stud2);
		studentdao.save(stud3);
		studentdao.save(stud4);
		
		Optional<Student> stud=studentdao.findById(2);
		if(stud.isPresent()) {
			System.out.println(stud.get());
		}else {
			System.out.println("Data has not been inserted");
		}
	}

}
