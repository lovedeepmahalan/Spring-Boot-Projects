package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Configuration
public class PersistanceConfig {

	@Bean
	public SimpleJdbcInsert jdbcinsert(DataSource datasource) {
		return new SimpleJdbcInsert(datasource);
	}
	
}
