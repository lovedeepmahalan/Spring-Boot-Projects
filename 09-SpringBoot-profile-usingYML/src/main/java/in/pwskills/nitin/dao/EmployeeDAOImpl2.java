package in.pwskills.nitin.dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.EmployeeBO;

@Repository("dao")
//Class level use of profile of profile comes from below then then this class object will be created else no
@Profile(value = {"uat","dev"})
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	
	static {
		System.out.println("EmployeeDAOIMPL2 class is loading");
	}
	
	public EmployeeDAOImpl2() {
		System.out.println("EmployeeDAOImpl2.EmployeeDAOImpl2()");
	}
	
	private static final String SQL_QUERY = "SELECT * FROM employee WHERE job IN ";
	@Autowired
	private DataSource datasource;
	private static Connection connection=null;
	
	@Override
	public List<EmployeeBO> getEmployee(String str) {
		EmployeeBO bo=null;
		List<EmployeeBO> listbo=null;
		try {
				System.out.println(datasource.getClass().getName());
				connection=datasource.getConnection();
				Statement stmt=connection.createStatement();
				System.out.println(str);
				ResultSet resultSet=stmt.executeQuery(SQL_QUERY + str + " order by ename");
				listbo=new ArrayList<EmployeeBO>();
			while(resultSet.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(resultSet.getInt(3));
				bo.setEmpName(resultSet.getString(1));
				bo.setJob(resultSet.getString(2));
				bo.setSalary(resultSet.getFloat(4));
				bo.setDeptNo(resultSet.getInt(5));
				bo.setMgrNo(resultSet.getInt(6));
				listbo.add(bo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return listbo;
	}

}
