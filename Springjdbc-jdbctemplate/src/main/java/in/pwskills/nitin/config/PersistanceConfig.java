package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PersistanceConfig {

	@Bean
	public DataSource getDataSource() {
		String location="D:\\MySpringBootProjects\\Springjdbc-jdbctemplate\\src\\main\\java\\in\\pwskills\\nitin\\config\\application.properties";
		HikariConfig config=new HikariConfig(location);
		HikariDataSource datasource=new HikariDataSource(config);
		return datasource;
	}
	
	@Bean
	public JdbcTemplate gettemplet(@Autowired DataSource datasource) {
		return new JdbcTemplate(datasource);
		
	}
}
