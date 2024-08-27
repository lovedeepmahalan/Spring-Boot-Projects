package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.EmployeeBO;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.dao.EmployeeDaoImpl;
import in.pwskills.nitin.dao.IEmployeeDao;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeSeervicee{

	@Autowired
	IEmployeeDao dao;

	@Override
	public String getEmployeeName(Integer eNo) {
		return dao.getEmployeeName(eNo);
	}

	@Override
	public List<EmployeeDTO> getEmployeeByDesc(String desc) {
		List<EmployeeBO> bolist=dao.getEmployeeByDesg(desc);
		List<EmployeeDTO> dtolist=new ArrayList<EmployeeDTO>();
		bolist.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dtolist.add(dto);
		});
		return dtolist;
	}

	@Override
	public int saveEmployee(EmployeeDTO dto) {
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insertEmployee(bo);
	}
	
}
