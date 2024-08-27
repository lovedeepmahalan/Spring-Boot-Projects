package in.pwskills.nitin.beans;

public class Company {
	
	private String location;
	private String title;
	private String size;
	public void setLocation(String location) {
		this.location = location;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Company [location=" + location + ", title=" + title + ", size=" + size + "]";
	}
	
	
}
