package in.pwskills.nitin.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "stud.info")
public class Student {

	static {
		System.out.println("Student class is loading");
	}
	
	public Student() {
		System.out.println("Student class object is created");
	}
	
	private int id;
	private String name;
	private int age;
	private int fee;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", fee=" + fee + "]";
	}
	
	
}
