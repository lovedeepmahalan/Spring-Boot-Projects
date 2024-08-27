package in.pwskills.nitin.main.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {

	public int getEmployeeCount();
	public float getEmployeeSalary(String ename);
	public Map<String, Object> getEmployeeDetails(Integer eid);
	public List<Map<String,Object>> getAllEmployee();
	public Integer InsertNewEmployee(String ename,String job,int eNo,float salary,int deptNo,int mgrNo);
	public Integer UpdateEmployee(int eNo, float salary);
	public int deleteRecord(int i);
}
