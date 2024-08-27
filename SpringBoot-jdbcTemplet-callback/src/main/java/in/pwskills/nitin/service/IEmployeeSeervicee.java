package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeDTO;

public interface IEmployeeSeervicee {

	public EmployeeDTO getEmployee(Integer id);

	public List<EmployeeDTO> getAllEmployee();
	
	public List<EmployeeDTO> getEmployeeByDesg(String desg);
}
