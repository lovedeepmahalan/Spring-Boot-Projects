package in.pwskills.nitin.controller;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeVO;

public interface IEmployeeController {
	
	public List<EmployeeVO> getEmployee(String[] arr);
}
