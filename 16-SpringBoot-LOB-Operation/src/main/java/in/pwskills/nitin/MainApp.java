package in.pwskills.nitin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		System.out.println("container is starting");
		ApplicationContext context= SpringApplication.run(MainApp.class, args);
		System.out.println("container is closing");
		((ConfigurableApplicationContext)context).close();
		
		
	}

}
