package in.pwskills.nitin.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
	
	private String name;
	private Integer eid;
	private String[] nickNames;
	private List<String> friendsNames;
	private Set<Long> phoneNumber;
	private Map<String, Long> bankDetails;
	private Company company;
	public void setName(String name) {
		this.name = name;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	public void setFriendsNames(List<String> friendsNames) {
		this.friendsNames = friendsNames;
	}
	public void setPhoneNumber(Set<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setBankDetails(Map<String, Long> bankDetails) {
		this.bankDetails = bankDetails;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", nickNames=" + Arrays.toString(nickNames)
				+ ", friendsNames=" + friendsNames + ", phoneNumber=" + phoneNumber + ", bankDetails=" + bankDetails
				+ ", company=" + company + "]";
	}
	
	
	
}
