package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.service.IEmployeeSeervicee;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	IEmployeeSeervicee service;
	
	@Autowired
	JdbcTemplate templet;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(templet);
		System.out.println(service.getEmployee(21));
		service.getAllEmployee().forEach(emp->{
			System.out.println(emp);
		});
		
		service.getEmployeeByDesg("Bowler").forEach(emp->{
			System.out.println(emp);
		});
	}

}
