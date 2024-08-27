package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeDTO;

public interface IEmployeeSeervicee {
	public String getEmployeeName(Integer eNo);

	public List<EmployeeDTO> getEmployeeByDesc(String string);

	public int saveEmployee(EmployeeDTO dto);


} 
