package in.pwskills.nitin.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="StudTab")
public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sid")
	private Integer studId;
	
	@Column(name="sname")
	private String studName;
	
	@Column(name="saddr")
	private String studAddr;
	
	@ManyToOne
	@JoinColumn(name="CollFkey",referencedColumnName = "Cid")
	private College college;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studId, String studName, String studAddr, College college) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAddr = studAddr;
		this.college = college;
	}

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudAddr() {
		return studAddr;
	}

	public void setStudAddr(String studAddr) {
		this.studAddr = studAddr;
	}

	

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAddr=" + studAddr + ", college="
				+ college + "]";
	}
	
	
}
