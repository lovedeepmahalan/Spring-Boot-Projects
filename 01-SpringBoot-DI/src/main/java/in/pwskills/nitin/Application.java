package in.pwskills.nitin;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.pwskills.nitin.beans.WishMessageGenerator;

@SpringBootApplication
public class Application {

	static{
		System.out.println("Spring Container is Loading");
	}
	
	public Application() {
		System.out.println("SpringContainer is Initializing");
	}
	
	@Bean
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}
	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Application.class, args);
		WishMessageGenerator wmg=context.getBean(WishMessageGenerator.class);
		System.out.println(wmg.wishMessage("Lovedeep"));
		
		((ConfigurableApplicationContext)context).close();
	}

}
