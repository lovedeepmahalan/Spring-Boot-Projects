package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.beans.Student;

@Component
@Order(10)
public class EmployeeRunner implements CommandLineRunner,Ordered{

	static {
		System.out.println("EmployeeRunner is loading");
	}
	
	public EmployeeRunner() {
	System.out.println("EmployeeRunner object is created");
	}
	
	@Autowired
	Employee employee;
	
	@Autowired
	Student student;

	// Called by the container automatically
		// After creation of all object of singleton scope
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Employee Run");
		System.out.println(employee);
		System.out.println();
		System.out.println(student);
		
		System.out.println("Argument passes are");
		for(String name:args) {
			System.out.println(name);
		}
		
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
