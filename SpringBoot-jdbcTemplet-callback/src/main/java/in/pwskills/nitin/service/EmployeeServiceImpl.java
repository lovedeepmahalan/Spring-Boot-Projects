package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.EmployeeBO;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.dao.EmployeeDaoImpl;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeSeervicee{

	@Autowired
	EmployeeDaoImpl dao;
	
	@Override
	public EmployeeDTO getEmployee(Integer id) {
		EmployeeBO bo=dao.getEmployee(id);
		EmployeeDTO dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeBO> bo=dao.getAllEmployee();
		List<EmployeeDTO> listdto=new ArrayList<EmployeeDTO>();
		bo.forEach(emp->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(emp, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public List<EmployeeDTO> getEmployeeByDesg(String desg) {
		List<EmployeeBO> bo=dao.getAllEmployee();
		List<EmployeeDTO> listdto=new ArrayList<EmployeeDTO>();
		bo.forEach(emp->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(emp, dto);
			listdto.add(dto);
		});
		return listdto;
	}

}
