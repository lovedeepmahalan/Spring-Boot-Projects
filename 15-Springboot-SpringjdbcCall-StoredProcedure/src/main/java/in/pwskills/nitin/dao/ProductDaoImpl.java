package in.pwskills.nitin.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import in.pwskills.nitin.beans.ProductBO;

@Repository("repository")
public class ProductDaoImpl implements IProductDao{

	@Autowired
	SimpleJdbcCall jdbcCall;

	//stored procedure is created with the help of chatgpt

	@Override
	public List<ProductBO> getProductList(String prod1, String prod2) {
		
		jdbcCall.setProcedureName("GET_PRODUCT_DETAILS_BY_NAME");
		
		//setting the inputs to storedprocedure
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("name1", prod1);
		parameterSource.addValue("name2", prod2);

		//keeping the result
		jdbcCall.returningResultSet("result", new RowMapper<ProductBO>() {

			@Override
			public ProductBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println(rowNum);
				ProductBO bo = new ProductBO();
				bo.setPid(rs.getInt(1));
				bo.setPname(rs.getString(2));
				bo.setPrice(rs.getFloat(3));
				bo.setQty(rs.getString(4));
				return bo;
			}
		});

		Map<String, Object> output = jdbcCall.execute(parameterSource);
		List<ProductBO> listBo = (List<ProductBO>) output.get("result");
		//My output is not coming proper because of Stored Procedure
		//Similarly we have to write code for updation and deletion and dateTime 
		return listBo;
	}

	

	
}
