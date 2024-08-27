package in.pwskills.nitin.dao;

import in.pwskills.nitin.beans.Naukri;

public interface INaukriDao {
	public int saveRecord(Naukri naukri);
	public Naukri getWorker(int id);
	
}
