package in.pwskills.nitin.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String Total_Employee = "select count(*) from employee";
	private static final String Employee_Name = "select salary from employee where ename=?";
	private static final String Employee_id = "select * from employee where eNo=?";
	private static final String Get_EmployeeTable = "Select * from employee";
	private static final String Insert_Employee = "insert into employee(`ename`,`job`,`eNo`,`salary`,`deptNo`,`mgrNo`) values(?,?,?,?,?,?)";
	private static final String Update_Employee = "UPDATE employee SET salary = ? WHERE eNo = ?";
	private static final String Delete_Record = "delete from employee where eNo = ?";
	@Autowired	
	JdbcTemplate templet;
	
	@Override
	public int getEmployeeCount() {
		return templet.queryForObject(Total_Employee,Integer.class);
	}

	@Override
	public float getEmployeeSalary(String ename) {
		return templet.queryForObject(Employee_Name,Float.class,ename);
		
	}

	@Override
	public Map<String, Object> getEmployeeDetails(Integer eid) {
		return templet.queryForMap(Employee_id, eid);
	}

	@Override
	public List<Map<String, Object>> getAllEmployee() {
		return templet.queryForList(Get_EmployeeTable);
	}

	@Override
	public Integer InsertNewEmployee(String ename, String job, int eNo, float salary, int deptNo, int mgrNo) {
		// TODO Auto-generated method stub
		return templet.update(Insert_Employee,ename,job,eNo,salary,deptNo,mgrNo);
	}

	@Override
	public Integer UpdateEmployee(int eNo, float salary) {
		// TODO Auto-generated method stub
		return templet.update(Update_Employee,salary,eNo);
	}

	@Override
	public int deleteRecord(int eNo) {
		// TODO Auto-generated method stub
		return templet.update(Delete_Record,eNo);
	}

}
