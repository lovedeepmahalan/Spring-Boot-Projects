package in.pwskills.nitin.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("company")
@ConfigurationProperties(prefix = "company.info")
public class Company {

	private String name;
	private Integer turnover;
	private String project;
	
	static {
		System.out.println("Company.class file is loading...");
	}

	public Company() {
		System.out.println("Company Object -> Zero param....");
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTurnover(Integer turnover) {
		this.turnover = turnover;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", turnover=" + turnover + ", project=" + project + "]";
	}
	
	
}
