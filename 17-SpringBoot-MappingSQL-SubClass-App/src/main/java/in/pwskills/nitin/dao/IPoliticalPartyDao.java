package in.pwskills.nitin.dao;

import java.util.List;

import in.pwskills.nitin.beans.PoliticalParty;

public interface IPoliticalPartyDao {

	public PoliticalParty getPoliticalPartyByPartyId(int i);

	public PoliticalParty getPoliticalPartyByPartyName(String name);

	public int updatePoliticalPartyByID(int i, String string);

	public String insertParty(String color, String name, String symbol);

	public int deleteParty(int id);


}
