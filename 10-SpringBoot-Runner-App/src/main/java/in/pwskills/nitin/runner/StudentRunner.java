package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.beans.Student;

@Component
//if we have two runners then which will run first
//it is decided by below annotation if order value is less then high priorty
//but if we have used Ordered interface also then this will be prefered both order and ordered will same work
@Order(1)
public class StudentRunner implements CommandLineRunner,Ordered{
	
	static {
		System.out.println("StudentRunner Class is loading");
	}
	
	public StudentRunner() {
		System.out.println("StudentRunner instatiation is created");
	}
	
	@Autowired
	Student student;
	
	@Autowired
	Employee employee;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("StudentRunner run");
		System.out.println(student);
		System.out.println();
		System.out.println(employee);
		
		for(String name:args) {
			System.out.println(name);
		}
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	/* The @Order annotation and the Ordered interface in Spring both serve to define the order in which beans are processed, but they are used in slightly different contexts and offer different levels of control.

@Order Annotation
The @Order annotation is primarily used to define the execution order of components such as aspect advices, filters, interceptors, and runners.
It is applied directly to the component classes or methods, specifying the order in which they should be processed relative to each other.
Lower values have higher priority (e.g., @Order(1) is executed before @Order(2)).
Ordered Interface
The Ordered interface provides the same ordering capability but is implemented by the class itself.
Implementing the Ordered interface gives you the flexibility to dynamically determine the order at runtime through a method (getOrder()).
This is useful when the order of the bean might depend on some logic or external configuration. */
	
}
