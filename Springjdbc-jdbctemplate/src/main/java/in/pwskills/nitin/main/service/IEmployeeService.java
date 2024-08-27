package in.pwskills.nitin.main.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

	public int getEmployeeCount();
	public float getEmplyeeSalary(String name);
	public Map<String,Object> getEmployeeDetails(Integer id);
	public List<Map<String,Object>> getEmployeeTable();
	public Integer InsertNewEmployee(String ename,String job,int eNo,float salary,int deptNo,int mgrNo);
	public Integer UpdateEmployee(int i, float salary);
	public int deleteEmployee(int i);

}
