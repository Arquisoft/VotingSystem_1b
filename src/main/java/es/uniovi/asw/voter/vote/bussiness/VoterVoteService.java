package es.uniovi.asw.voter.vote.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.VotableOptionDAO;

@Component
public class VoterVoteService {
	
	@Autowired
	VotableOptionDAO vd;
	
	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection){
		List<VotableOption> votableOptions = vd.findByConfigurationElection(configurationElection);
		
		return votableOptions;
	}

}
