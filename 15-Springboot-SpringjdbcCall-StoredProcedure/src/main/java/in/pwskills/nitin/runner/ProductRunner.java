package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import in.pwskills.nitin.service.IProductSeervicee;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	IProductSeervicee service;
	
	@Autowired
	SimpleJdbcCall jdbccall;
	
	@Override
	public void run(String... args) throws Exception {
		service.fetchProductsByName("Sugar", "Milk").forEach(System.out::println);
	}

}
