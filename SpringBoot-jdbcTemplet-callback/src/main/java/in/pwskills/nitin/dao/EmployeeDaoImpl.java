package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao{

	private static final String Select_Employee = "select * from employee where eNO=?";
	private static final String Select_ALLEmployee = "select * from employee";
	private static final String Select_EmployeeByDesg = "select * from employee where job=?";
	@Autowired
	JdbcTemplate template;
	
	@Override
	public EmployeeBO getEmployee(Integer eNo) {
		//this is used to get data in Required Object an this interface RowMapper is given by SpringBoot
		return template.queryForObject(Select_Employee, new RowMapper<EmployeeBO>(){

			@Override
			public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeBO bo=new EmployeeBO();
				bo.setEname(rs.getString(1));
				bo.setJob(rs.getString(2));
				bo.seteNo(rs.getInt(3));
				bo.setSalary(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				return bo;
			}
			
		},eNo);
	}

	@Override
	public List<EmployeeBO> getEmployeeByDesg(String desg){
		//ResultSetExtractor is Used to extract results from the entire ResultSet at once.
		//written in lambda expression 
		ArrayList<EmployeeBO> listbo=new ArrayList<EmployeeBO>();
		  return template.query(Select_EmployeeByDesg,(ResultSetExtractor<List<EmployeeBO>>) (rs)->{
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				System.out.println("USING RESULTSETEXTEACTOR");
				bo.setEname(rs.getString(1));
				bo.setJob(rs.getString(2));
				bo.seteNo(rs.getInt(3));
				bo.setSalary(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				listbo.add(bo);
			}
			return listbo;
		},desg);
	}
	
	@Override
	public List<EmployeeBO> getAllEmployee() {

		ArrayList<EmployeeBO> employeeBo = new ArrayList<>();
		// RowCallbackHandler interface is used to get List of Object from employee individually.
		//written in lambda expression
		//RowCallbackHandler it is not generic we cannot in it.
		template.query(Select_ALLEmployee, (RowCallbackHandler) (rs) -> {
			EmployeeBO bo = new EmployeeBO();
			System.out.println("USING ROWCALLBACKHANDLER");
			bo.setEname(rs.getString(1));
			bo.setJob(rs.getString(2));
			bo.seteNo(rs.getInt(3));
			bo.setSalary(rs.getFloat(4));
			bo.setDeptNo(rs.getInt(5));
			bo.setMgrNo(rs.getInt(6));

			employeeBo.add(bo);

		});
		return employeeBo;
	}
}
