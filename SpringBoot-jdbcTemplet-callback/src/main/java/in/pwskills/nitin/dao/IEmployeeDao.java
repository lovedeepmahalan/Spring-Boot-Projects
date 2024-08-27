package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeBO;

public interface IEmployeeDao {

	public EmployeeBO getEmployee(Integer eNo);
	public List<EmployeeBO> getAllEmployee();
	List<EmployeeBO> getEmployeeByDesg(String desg);
}
