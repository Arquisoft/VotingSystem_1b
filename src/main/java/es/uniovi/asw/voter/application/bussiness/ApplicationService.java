package es.uniovi.asw.voter.application.bussiness;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voter.application.exception.AlredyVotedException;
import es.uniovi.asw.voter.application.exception.BusinessException;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

public interface ApplicationService {
	
	public void saveApplication(String email, String password, ConfigurationElection configurationElection) throws InvalidUserException;

	
	public void voteOnElection(ConfigurationElection c, Vote v, User u,ElectoralCollege colegioElectoral) throws InvalidUserException, BusinessException, AlredyVotedException;
	
	
}
