package in.pwskills.nitin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Developer_Info")
public class Developer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="did")
	private Integer id;
	
	@Column(name="dname")
	private String name;
	
	private LocalDateTime dateofjoining;
	
	@Lob
	private char[] resume;
	
	@Lob
	@Column(length = 100000)
	private byte[] image;

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

	public LocalDateTime getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(LocalDateTime dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	public Developer(String name, LocalDateTime dateofjoining, byte[] image, char[] resume) {
		super();
		this.name = name;
		this.dateofjoining = dateofjoining;
		this.image = image;
		this.resume = resume;
	}

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", dateofjoining=" + dateofjoining + ", image="
				+ Arrays.toString(image) + ", resume=" + Arrays.toString(resume) + "]";
	}

}
