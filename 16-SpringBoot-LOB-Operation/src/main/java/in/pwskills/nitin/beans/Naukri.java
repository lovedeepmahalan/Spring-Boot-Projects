package in.pwskills.nitin.beans;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

public class Naukri implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String address;
	private String name;
	private LocalDate date;
	private File image;
	private File resume;
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Naukri [id=" + id + ", address=" + address + ", name=" + name + ", date=" + date + ", image=" + image
				+ ", resume=" + resume + "]";
	}

}
