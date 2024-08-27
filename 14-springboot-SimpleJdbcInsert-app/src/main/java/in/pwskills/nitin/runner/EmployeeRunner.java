package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.service.IEmployeeSeervicee;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	IEmployeeSeervicee service;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		EmployeeDTO dto=new EmployeeDTO();
		dto.setDeptNo(5);
		dto.setEname("Shardul");
		dto.seteNo(32);
		dto.setJob("Bowler");
		dto.setMgrNo(3);
		dto.setSalary(22000.0f);
		System.out.println(service.saveEmployee(dto));
	}

}
