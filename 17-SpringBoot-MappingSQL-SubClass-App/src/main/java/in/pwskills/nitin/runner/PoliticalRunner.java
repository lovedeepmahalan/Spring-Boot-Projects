package in.pwskills.nitin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.beans.PoliticalParty;
import in.pwskills.nitin.service.IPoliticalPartyService;

@Component
public class PoliticalRunner implements CommandLineRunner {

	@Autowired
	IPoliticalPartyService service;

	@Override
	public void run(String... args) throws Exception {
		//PoliticalParty party = service.fetchPoliticalPartyDetailsByPartyId(1);
		//PoliticalParty party1=service.fetchPoliticalPartyDetailsByPartyName("BJP");
		//System.out.println(party);
		//System.out.println(party1);
		//System.out.println(service.UpdatePoliticalParty(1,"Congress"));
		System.out.println(service.insertParty("Bhagwa","BJP","Kamal"));
		//System.out.println(service.deleteParty(2));
	}
	
	

}
