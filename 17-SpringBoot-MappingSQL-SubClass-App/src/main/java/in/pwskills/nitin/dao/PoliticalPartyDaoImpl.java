package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.beans.PoliticalParty;


@Repository("repository")
public class PoliticalPartyDaoImpl implements IPoliticalPartyDao{

	private static final String GetPartyByID = "select * from PoliticalParty where id=?";
	private static final String GetPartyByName = "select * from PoliticalParty where partyName=?";
	private static final String UpdatePartyById = "update PoliticalParty set partyName=? where id=?";
	private static final String InsertParty = "insert into PoliticalParty(`partyColor`,`partyName`,`partySymbol`) values(?,?,?)";
	private static final String DeleteParty = "delete from PoliticalParty where id=?";
	private PoliticalPartySelector1 selector1;
	private PoliticalPartySelector2 selector2;
	private PoliticalPartyUpdater updator;
	private PoliticalPartyInsertor insertor;
	private PoliticalPartyDeletor deletor;
	public PoliticalPartyDaoImpl(DataSource ds) {
		this.selector1=new PoliticalPartySelector1(ds, GetPartyByID);
		this.selector2=new PoliticalPartySelector2(ds, GetPartyByName);
		this.updator=new PoliticalPartyUpdater(ds, UpdatePartyById);
		this.insertor=new PoliticalPartyInsertor(ds,InsertParty);
		this.deletor=new PoliticalPartyDeletor(ds,DeleteParty);
	}
	@Override
	public int updatePoliticalPartyByID(int i, String partyName) {
		return updator.update(partyName,i);
	}
	@Override
	public PoliticalParty getPoliticalPartyByPartyId(int i) {
		return selector1.findObject(i);
		
	}
	//if we have to get the list of Party then we have to go for execute method instead of findObject
	//for more information refer Nitin_Manjunath Code
	@Override
	public PoliticalParty getPoliticalPartyByPartyName(String name) {
		return selector2.findObject(name);
	}
	@Override
	public String insertParty(String color, String name, String symbol) {
		int a= insertor.update(color,name,symbol);
		if(a==0) {
			return "Party is not registered";
		}else {
			return "Party is registered succesfully";
		}
	}
	@Override
	public int deleteParty(int id) {
		
		return deletor.update(id);
	}

	private static class PoliticalPartySelector1 extends MappingSqlQuery<PoliticalParty>{

		@SuppressWarnings("unused")
		public PoliticalPartySelector1(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
		@Override
		protected PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			PoliticalParty party=new PoliticalParty();
			party.setFlagColors(rs.getString(2));
			party.setPartyId(rs.getInt(1));
			party.setPartyName(rs.getString(3));
			party.setPartySymbol(rs.getString(4));
			return party;
		}
	}
	private static class PoliticalPartySelector2 extends MappingSqlQuery<PoliticalParty>{

		public PoliticalPartySelector2(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}
		@Override
		protected PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			PoliticalParty party=new PoliticalParty();
			party.setFlagColors(rs.getString(2));
			party.setPartyId(rs.getInt(1));
			party.setPartyName(rs.getString(3));
			party.setPartySymbol(rs.getString(4));
			return party;
		}
		
		}
	private static class PoliticalPartyUpdater extends SqlUpdate{
		public PoliticalPartyUpdater(DataSource ds,String Query) {
			super(ds,Query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
	}
	
	public static class PoliticalPartyInsertor extends SqlUpdate{
		public PoliticalPartyInsertor(DataSource ds,String Query) {
			super(ds,Query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}
	}
	
	private static class PoliticalPartyDeletor extends SqlUpdate{
		public PoliticalPartyDeletor(DataSource ds,String Query) {
			super(ds,Query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
	}
}
