package in.pwskills.nitin.runner;

import java.io.File;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.Naukri;
import in.pwskills.nitin.dao.INaukriDao;

@Component
public class NaukriRunner implements CommandLineRunner {

	@Autowired
	INaukriDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		/*Naukri naukri=new Naukri();
		LocalDate date=LocalDate.of(2022,04,06);
		naukri.setAddress("Chandigarh");
		naukri.setDate(date);
		naukri.setName("Lovedeep");
		String resume="D:\\Nitin_Projects\\MySpringCoreProjects\\16-SpringBoot-LOB-Operation\\src\\main\\java\\resume.txt";
		String image="D:\\Nitin_Projects\\MySpringCoreProjects\\16-SpringBoot-LOB-Operation\\src\\main\\java\\WIN_20220713_15_37_13_Pro.jpg";
		File Resume=new File(resume);
		File Image=new File(image);
		naukri.setResume(Resume);
		naukri.setImage(Image);
		int a=(dao.saveRecord(naukri));
		if(a==0) {
			System.out.println("Data is not inerted due to some error");
		}else {
			System.out.println("Data has been added succeessfully");
		}*/
		
		Naukri naukri = dao.getWorker(1);
		System.out.println("Name     is :: " + naukri.getName());
		System.out.println("Address  is :: " + naukri.getAddress());
		System.out.println("Date     is :: " +naukri.getDate());
		System.out.println("Image    is :: " + naukri.getImage().getAbsolutePath());
		System.out.println("Resume   is :: " + naukri.getResume().getAbsolutePath());

	}

}
