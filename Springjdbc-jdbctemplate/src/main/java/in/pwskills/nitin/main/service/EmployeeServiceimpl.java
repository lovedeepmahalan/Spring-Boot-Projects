package in.pwskills.nitin.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.main.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceimpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public int getEmployeeCount() {
		return dao.getEmployeeCount();
	}

	@Override
	public float getEmplyeeSalary(String name) {
		// TODO Auto-generated method stub
		return dao.getEmployeeSalary(name);
	}

	@Override
	public Map<String, Object> getEmployeeDetails(Integer id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetails(id);
	}

	@Override
	public List<Map<String, Object>> getEmployeeTable() {
		return dao.getAllEmployee();
	}

	@Override
	public Integer InsertNewEmployee(String ename, String job, int eNo, float salary, int deptNo, int mgrNo) {
		// TODO Auto-generated method stub
		return dao.InsertNewEmployee(ename, job, eNo, salary, deptNo, mgrNo);
	}

	@Override
	public Integer UpdateEmployee(int eNo, float salary) {
		// TODO Auto-generated method stub
		return dao.UpdateEmployee(eNo,salary);
	}

	@Override
	public int deleteEmployee(int i) {
		// TODO Auto-generated method stub
		return dao.deleteRecord(i);
	}

}
