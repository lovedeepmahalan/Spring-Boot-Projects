package in.pwskills.nitin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pwskills.nitin.config.AppConfig;
import in.pwskills.nitin.main.service.IEmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
      IEmployeeService service=context.getBean(IEmployeeService.class);
      System.out.println("Total number of employee is "+service.getEmployeeCount());
      
      System.out.println("Salary of employee is "+service.getEmplyeeSalary("Shivam"));
      
      System.out.print("Employee details are [");
      service.getEmployeeDetails(13).entrySet().forEach(row->{
    	  System.out.print(row.getKey()+"=> ");
    	  System.out.print(row.getValue()+" ");
      });
      System.out.println("]");
      
      System.out.println("Employee Table is ");
      service.getEmployeeTable().forEach(row->{
    	  row.entrySet().forEach(Employee->{
    		  System.out.print(Employee.getKey()+"=> ");
        	  System.out.print(Employee.getValue()+" ");
    	  });
    	  System.out.println();
      });
      
      System.out.println(service.InsertNewEmployee("ADB", "Batsman", 33, 3400.0f, 6, 1));
      
      System.out.println(service.UpdateEmployee(33,34000.0f));
      System.out.println(service.deleteEmployee(18));
    }
}
