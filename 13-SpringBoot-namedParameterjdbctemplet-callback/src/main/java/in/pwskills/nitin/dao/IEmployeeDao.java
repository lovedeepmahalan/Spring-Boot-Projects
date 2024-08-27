package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeBO;

public interface IEmployeeDao {
	public String getEmployeeName(Integer eNo);

	public List<EmployeeBO> getEmployeeByDesg(String desc);

	public int insertEmployee(EmployeeBO bo);
	
}
