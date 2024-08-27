package in.pwskills.nitin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

//if we have both runner then which will then on the base of order then will run
@SpringBootApplication
public class Application {

	static{
		System.out.println("Spring Container is Loading");
	}
	//
	public Application() {
		System.out.println("SpringContainer is Initializing");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Container is Starting");
		ApplicationContext context= SpringApplication.run(Application.class, args);
		System.out.println("Container is closing");
		((ConfigurableApplicationContext)context).close();
	}

}
