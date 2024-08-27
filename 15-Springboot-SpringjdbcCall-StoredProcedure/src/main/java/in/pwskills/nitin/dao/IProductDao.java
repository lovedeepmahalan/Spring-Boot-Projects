package in.pwskills.nitin.dao;


import java.util.List;

import in.pwskills.nitin.beans.ProductBO;

public interface IProductDao {
	
	public List<ProductBO> getProductList(String string, String string2);
	
}
