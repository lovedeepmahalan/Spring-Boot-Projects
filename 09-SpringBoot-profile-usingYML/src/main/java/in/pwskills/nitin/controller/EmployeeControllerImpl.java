package in.pwskills.nitin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.beans.EmployeeVO;
import in.pwskills.nitin.service.IEmployeeService;

@Component
public class EmployeeControllerImpl implements IEmployeeController {

	
	@Autowired
	IEmployeeService service;
	
	@Override
	public List<EmployeeVO> getEmployee(String[] arr) {
		
		List<EmployeeVO> listvo=new ArrayList<EmployeeVO>();
		
		List<EmployeeDTO> Empdto=service.getEmployee(arr);
		Empdto.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSalary(String.valueOf(dto.getSalary()));
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			listvo.add(vo);
		});
		
		return listvo;
	}

}
