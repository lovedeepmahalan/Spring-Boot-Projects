package in.pwskills.nitin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "in.pwskills.nitin")
@Configuration
@Import(PersistanceConfig.class)
public class AppConfig {

}
