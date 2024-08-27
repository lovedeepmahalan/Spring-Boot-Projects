package in.pwskills.nitin.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="productab")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="pid")
	private Integer productId;
	
	@Column(name="pcode")
	private String productCode;
	
	@OneToMany
	@JoinColumn(name="mfId",referencedColumnName="pid")
	private List<Model> model;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productCode, List<Model> model) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.model = model;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<Model> getModel() {
		return model;
	}

	public void setModel(List<Model> model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", model=" + model + "]";
	}
	
	
}
