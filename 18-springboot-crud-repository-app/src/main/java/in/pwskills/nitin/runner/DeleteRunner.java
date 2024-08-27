package in.pwskills.nitin.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IStudentDao;
import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.exception.StudentRecordNotFoundException;

@Component
public class DeleteRunner implements CommandLineRunner{

	@Autowired
	public IStudentDao dao;
	@Override
	public void run(String... args) throws Exception {
		//first check wheather that the student for given id is present or not if present then delete else do nothing
		dao.deleteById(10);//intrnallay use dao.delete refer it implementation
		
		
		/*Student student = new Student();
		student.setSid(10);
		student.setSname("Lovedeep");
		student.setSage(21);
		student.setSaddress("Charkhi Dadri");
		dao.delete(student);*/
		
		//dao.delete(dao.findById(7).orElseThrow(() -> new StudentRecordNotFoundException(String
			//	.format("Record for %s object not avaialable for the given id %d", Student.class.getName(), 100))));

		
		//dao.deleteAllById(List.of(18, 7));

	}

	
}
