package in.pwskills.nitin.beans;

public class EmployeeDTO {

	private String ename;
	private String job;
	private float salary;
	private int eNo;
	private int deptNo;
	private int mgrNo;
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void seteNo(int eNo) {
		this.eNo = eNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public void setMgrNo(int mgrNo) {
		this.mgrNo = mgrNo;
	}
	
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public float getSalary() {
		return salary;
	}
	public int geteNo() {
		return eNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public int getMgrNo() {
		return mgrNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [ename=" + ename + ", job=" + job + ", salary=" + salary + ", eNo=" + eNo + ", deptNo="
				+ deptNo + ", mgrNo=" + mgrNo + "]";
	}
	
	
}
