package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.PoliticalParty;
import in.pwskills.nitin.dao.IPoliticalPartyDao;
import in.pwskills.nitin.dao.PoliticalPartyDaoImpl;



@Service("service")
public class PoliticalPartyServiceImpl implements IPoliticalPartyService{

	@Autowired
	IPoliticalPartyDao dao;
	@Override
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(int i) {
		
		return dao.getPoliticalPartyByPartyId(i);
	}
	@Override
	public PoliticalParty fetchPoliticalPartyDetailsByPartyName(String name) {
		return dao.getPoliticalPartyByPartyName(name);
	}
	

	@Override
	public int UpdatePoliticalParty(int i, String string) {
		return dao.updatePoliticalPartyByID(i,string);
	}
	@Override
	public String insertParty(String color, String name, String symbol) {
		String status=dao.insertParty(color,name,symbol);
		return status;
	}
	@Override
	public int deleteParty(int id) {
		int a=dao.deleteParty(id);
		return a;
	}}
