package in.pwskills.nitin.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.pwskills.nitin.beans.ProductBO;
import in.pwskills.nitin.beans.ProductDTO;
import in.pwskills.nitin.dao.IProductDao;

@Service("service")
public class ProductServiceImpl implements IProductSeervicee{

	@Autowired
	IProductDao dao;

	@Override
	public List<ProductDTO> fetchProductsByName(String string, String string2) {
		List<ProductBO> bo=dao.getProductList(string,string2);
		ProductDTO dto=new ProductDTO();
		List<ProductDTO> listdto=new ArrayList<ProductDTO>();
		bo.forEach(productbo->{
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	
	
}
