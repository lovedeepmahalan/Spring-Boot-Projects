package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.beans.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO> getEmployee(String str);

	
}
