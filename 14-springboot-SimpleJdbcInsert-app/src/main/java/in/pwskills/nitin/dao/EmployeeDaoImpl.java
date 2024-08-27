package in.pwskills.nitin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.EmployeeBO;

@Repository("repository")
public class EmployeeDaoImpl implements IEmployeeDao{

	@Autowired
	SimpleJdbcInsert simplejdbc;

	@Override
	public int insertEmployee(EmployeeBO bo) {
		simplejdbc.setTableName("employee");
		BeanPropertySqlParameterSource param=new BeanPropertySqlParameterSource(bo);
		return simplejdbc.execute(param);
	}
}
