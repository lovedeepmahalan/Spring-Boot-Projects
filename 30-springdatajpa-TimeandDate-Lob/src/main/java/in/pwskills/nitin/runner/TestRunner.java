package in.pwskills.nitin.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.dao.IDeveloperDap;
import in.pwskills.nitin.entity.Developer;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	IDeveloperDap dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*LocalDateTime time=LocalDateTime.of(2020, 06, 01, 9, 0);
		
		File file=new File("D:/resume/resume.txt");
		FileReader reader=new FileReader(file);
		char[] resume=new char[(int) (file.length())];
		reader.read(resume);
		
		File f2=new File("C:/Users/Xps/OneDrive/Pictures/Camera Roll/WIN_20240401_22_42_29_Pro.jpg");
		FileInputStream is=new FileInputStream(f2);
		byte[] image=new byte[is.available()];
		is.read(image);
		Developer developer=new Developer("Sumit",time, image, resume);
		
		dao.save(developer);*/
		
		Optional<Developer> opt=dao.findById(1);
		
		if(opt.isPresent()) {
			Developer developer=opt.get();
			System.out.println(developer);
			
			File file=new File("developer_image.jpg");
			FileOutputStream os=new FileOutputStream(file);
			os.write(developer.getImage());
			
			File file2=new File("developer_resume.txt");
			PrintWriter writer=new PrintWriter(file2);
			writer.println(developer.getResume());
		}else {
			System.out.println("Data not found for given id");
		}
		
	}
}
