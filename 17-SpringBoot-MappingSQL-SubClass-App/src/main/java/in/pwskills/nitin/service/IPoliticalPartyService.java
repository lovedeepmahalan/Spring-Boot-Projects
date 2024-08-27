package in.pwskills.nitin.service;

import in.pwskills.nitin.beans.PoliticalParty;

public interface IPoliticalPartyService {

	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(int i);

	public PoliticalParty fetchPoliticalPartyDetailsByPartyName(String name);

	public int UpdatePoliticalParty(int i, String string);

	public String insertParty(String color, String name, String symbol);

	public int deleteParty(int id);

	
}
