package in.pwskills.nitin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CollegeTab")
public class College {

	@Id
	@Column(name="cid")
	private Integer id;
	
	@Column(name="Cname")
	private String name;
	
	@Column(name="Caddr")
	private String addr;

	public College(Integer id, String name, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
}
