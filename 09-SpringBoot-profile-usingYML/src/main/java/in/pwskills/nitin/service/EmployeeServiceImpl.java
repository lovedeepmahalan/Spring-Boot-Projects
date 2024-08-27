package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.EmployeeBO;
import in.pwskills.nitin.beans.EmployeeDTO;
import in.pwskills.nitin.dao.IEmployeeDAO;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDAO employeedao;
	
	@Override
	public List<EmployeeDTO> getEmployee(String[] arr) {

		StringBuilder builder=new StringBuilder("(");
		for (int i=0;i<arr.length;i++) {
			if(i==(arr.length-1)) {
				builder.append("'"+arr[i]+"')");
			}else {
				builder.append("'"+arr[i]+"',");
			}
		}
		String str=builder.toString();
		List<EmployeeBO> empbo=employeedao.getEmployee(str);
		ArrayList<EmployeeDTO> empdto=new ArrayList<EmployeeDTO>();
		
		empbo.forEach(employee->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(employee,dto);
			dto.setSrNo(empdto.size()+1);
			
			empdto.add(dto);
		});
		
		return empdto;
	}

}
