package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
public class PersistanceConfig {

	@Bean
	public SimpleJdbcCall jdbcinsert(DataSource datasource) {
		return new SimpleJdbcCall(datasource);
	}
	
}
