package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class PersistanceConfig {

	@Autowired
	Environment environment;
	
	@Bean
	//method use of profile if profile is prodst then this method will be executed else no
	@Profile(value="prodst")
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setJdbcUrl(environment.getProperty("spring.datsource.url"));
		dataSource.setUser(environment.getProperty("spring.datsource.username"));
		dataSource.setPassword(environment.getProperty("spring.datsource.password"));
		return dataSource;
	}
}
