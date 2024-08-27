package in.pwskills.nitin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.entity.Developer;

public interface IDeveloperDap extends JpaRepository<Developer, Integer> {

}
