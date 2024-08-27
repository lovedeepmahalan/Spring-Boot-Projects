package in.pwskills.nitin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.pwskills.nitin.entity.Student;

public interface IStudentdao extends JpaRepository<Student, Integer> {

	@Query("SELECT s.studName,c.name FROM Student s INNER JOIN s.college c")
	List<Object[]> getStudentNames();
	
	@Query("SELECT s.studName,c.name FROM Student s LEFT JOIN s.college c")
	List<Object[]> getStudentNamesBYLEFTJON();
	
	@Query("SELECT s.studName,c.name FROM Student s RIGHT JOIN s.college c")
	List<Object[]> getStudentNamesBYRIGHTJOIN();
	
	@Query("SELECT s.studName,c.name FROM Student s RIGHT JOIN s.college c Where s.studName IS NULL")
	List<Object[]> getStudentNamesWhereCollegeIsNull();
	
	@Query("SELECT s.studName,c.name FROM Student s RIGHT JOIN s.college c Where c.name IS NULL")
	List<Object[]> getStudentNamesWhereStudentIsNull();
	
	@Query("SELECT s.studName,c.name FROM Student s RIGHT JOIN s.college c Where s.studName=:name")
	List<Object[]> getStudentNamesWhereStudentIsName(String name);
}
