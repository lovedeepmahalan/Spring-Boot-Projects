package in.pwskills.nitin;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.pwskills.nitin.controller.EmployeeControllerImpl;
import in.pwskills.nitin.controller.IEmployeeController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext context= SpringApplication.run(Application.class, args);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the Designation number");
		int descNo=sc.nextInt();
		
		String[] desc =null;
		
		if(descNo<=0) {
			System.out.println("You have entered Wrong descNo");
		}else {
			desc=new String[descNo];
		}
		
		for(int a=0;a<descNo;a++) {
			System.out.print("Enter the designation job ");
			desc[a]=sc.next();
		}
		
		IEmployeeController controller=context.getBean(EmployeeControllerImpl.class);
		controller.getEmployee(desc).forEach(System.out::println);
		
		((ConfigurableApplicationContext)context).close();
	}

}
