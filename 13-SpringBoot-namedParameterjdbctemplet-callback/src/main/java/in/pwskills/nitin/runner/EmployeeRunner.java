package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.service.IEmployeeSeervicee;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	IEmployeeSeervicee service;
	
	@Autowired
	JdbcTemplate templet;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(service.getEmployeeName(21));
		
		service.getEmployeeByDesc("Batsman").forEach(System.out::println);
		
		EmployeeDTO dto=new EmployeeDTO();
		dto.setDeptNo(9);
		dto.setEname("Sharukh");
		dto.seteNo(76);
		dto.setJob("Batsman");
		dto.setMgrNo(1);
		dto.setSalary(12000.0f);
		System.out.println(service.saveEmployee(dto));
	}

}
