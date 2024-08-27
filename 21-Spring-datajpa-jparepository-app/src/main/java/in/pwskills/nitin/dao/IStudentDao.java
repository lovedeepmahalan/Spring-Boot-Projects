package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Integer> {

}
