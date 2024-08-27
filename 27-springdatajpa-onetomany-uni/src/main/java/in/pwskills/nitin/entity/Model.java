package in.pwskills.nitin.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="modeltab")
public class Model implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mid")
	private Integer id;
	
	@Column(name="mcode")
	private String modelCode;
	
	@Column(name="mdata")
	private String modelData;

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(Integer id, String modelCode, String modelData) {
		super();
		this.id = id;
		this.modelCode = modelCode;
		this.modelData = modelData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelData() {
		return modelData;
	}

	public void setModelData(String modelData) {
		this.modelData = modelData;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", modelCode=" + modelCode + ", modelData=" + modelData + "]";
	}
	
	
}