package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.College;

public interface ICollegedao extends JpaRepository<College, Integer> {

}
