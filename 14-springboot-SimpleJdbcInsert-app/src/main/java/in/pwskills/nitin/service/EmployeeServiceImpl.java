package in.pwskills.nitin.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.EmployeeBO;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeSeervicee{

	@Autowired
	IEmployeeDao dao;

	@Override
	public int saveEmployee(EmployeeDTO dto) {
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insertEmployee(bo);
	}
	
}
