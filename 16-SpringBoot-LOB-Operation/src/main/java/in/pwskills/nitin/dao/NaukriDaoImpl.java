package in.pwskills.nitin.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import in.pwskills.nitin.beans.Naukri;

@Repository("dao")
public class NaukriDaoImpl implements INaukriDao{

	private static final String Insert_Worker = "insert into worker (`address`,`name`,`date`,`image`,`resume`) VALUES (?,?,?,?,?)";

	private static final String Get_Worker = "SELECT * FROM worker";

	@Autowired
	JdbcTemplate template;
	
	@Autowired
	LobHandler handler;

	@Override
	public int saveRecord(Naukri naukri) {
		int count=template.execute(Insert_Worker,new AbstractLobCreatingPreparedStatementCallback(handler) {

			@Override
			protected void setValues(PreparedStatement ps, LobCreator lobCreator)
					throws SQLException, DataAccessException {
				FileInputStream stream;
				try {
					ps.setString(1, naukri.getAddress());
					ps.setString(2,naukri.getName());
					ps.setDate(3,Date.valueOf(naukri.getDate()));
					stream = new FileInputStream(naukri.getImage());
					FileReader reader=new FileReader(naukri.getResume());
					lobCreator.setBlobAsBinaryStream(ps, 4,stream, (int) naukri.getImage().length());
					lobCreator.setClobAsCharacterStream(ps, 5, reader, (int)naukri.getResume().length());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		return count;
	}

	@Override
	public Naukri getWorker(int id) {
		Naukri naukri=new Naukri();
		template.query(Get_Worker,new AbstractLobStreamingResultSetExtractor<Naukri>() {

			@Override
			protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
				naukri.setId(rs.getInt(1));
				naukri.setName(rs.getString(4));
				naukri.setAddress(rs.getString(2));
				naukri.setDate(rs.getDate(4).toLocalDate());
				//reading image[BLOB] from db and writing to our harddisk
				File imageFile = new File("nitin.jpg");
				FileOutputStream stream = new FileOutputStream(imageFile);
				FileCopyUtils.copy(handler.getBlobAsBinaryStream(rs, 5), stream);
				naukri.setImage(imageFile);
				
				
				//reading resume[CLOB] from db and writing to our harddisk
				File resumeFile = new File("nitin.txt");
				FileWriter writer = new FileWriter(resumeFile);
				FileCopyUtils.copy(handler.getClobAsCharacterStream(rs, 6), writer);
				naukri.setResume(resumeFile);
				
			}
			
		});
		return naukri;
	}
}
