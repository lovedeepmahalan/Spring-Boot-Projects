package in.pwskills.nitin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

@Configuration
public class PersistanceConfig {

	@Bean
	public LobHandler jdbcinsert() {
		return new DefaultLobHandler();
	}
	
}
