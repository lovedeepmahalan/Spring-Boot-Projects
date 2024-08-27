package in.pwskills.nitin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value=PersistanceConfig.class)
public class AppConfig {

}
