package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao{

	private static final String Get_Emp_Name = "select ename from employee where eNo=:eid";
	private static final String Get_Employee = "select * from employee where job=:desc";
	private static final String Insert_Employee = "insert into employee(`ename`,`job`,`eNo`,`salary`,`deptNo`,`mgrNo`) values(:ename,:job,:eNo,:salary,:deptNo,:mgrNo)";
	@Autowired
	//with the help of NamedParameterJdbcTemplate we can write named query
	NamedParameterJdbcTemplate template;
	
	//we can pass named parameter in two ways Map,MapSqlParameterSource(we can pass 1 or more then 1) as below
	@Override
	public String getEmployeeName(Integer eNo) {
		Map<String, Integer> parammap=Map.of("eid",eNo);
		return template.queryForObject(Get_Emp_Name,parammap, String.class);
	}
	public List<EmployeeBO> getEmployeeByDesg(String desc) {
		MapSqlParameterSource param=new MapSqlParameterSource();
		param.addValue("desc", desc);
		return template.query(Get_Employee, param,new ResultSetExtractor<List<EmployeeBO>>(){

			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeBO> listbo=new ArrayList<EmployeeBO>();
				while(rs.next()) {
					EmployeeBO bo=new EmployeeBO();
					bo.setEname(rs.getString(1));
					bo.setJob(rs.getString(2));
					bo.seteNo(rs.getInt(3));
					bo.setSalary(rs.getFloat(4));
					bo.setDeptNo(rs.getInt(5));
					bo.setMgrNo(rs.getInt(6));
					listbo.add(bo);
				}
				return listbo;
			}
			
		});
	}
	@Override
	public int insertEmployee(EmployeeBO bo) {
		return template.update(Insert_Employee, new BeanPropertySqlParameterSource(bo));
	}

}
