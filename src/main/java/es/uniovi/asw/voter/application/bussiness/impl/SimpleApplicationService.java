package es.uniovi.asw.voter.application.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.dbupdate.repositories.VoteDAO;
import es.uniovi.asw.voter.application.bussiness.ApplicationService;
import es.uniovi.asw.voter.application.exception.AlredyVotedException;
import es.uniovi.asw.voter.application.exception.BusinessException;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

@Component
public class SimpleApplicationService implements ApplicationService {

	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;
	
	@Autowired(required=true)
	private VoteDAO votoDao;

	@Override
	public void saveApplication(String email, String password,
			ConfigurationElection configurationElection) throws InvalidUserException {

		User user = ud.findByMailAndContrasena(email, password);

		if(user == null){
			throw new InvalidUserException();
		}

		TelematicVoter telematic = new TelematicVoter(user, false, configurationElection);
		td.save(telematic);

	}

	@Override
	public void voteOnElection(ConfigurationElection c, Vote v, User u,
			ElectoralCollege colegioElectoral) throws InvalidUserException, BusinessException, AlredyVotedException {
	
		User user = ud.findByMailAndContrasena(u.getMail(), u.getContrasena());

		if(user == null){
			throw new InvalidUserException();
		}
		
		TelematicVoter miVotoTelematico=td.findByUserAndConfigurationElection(u, c);
		
		if(miVotoTelematico == null){
			throw new BusinessException("No habias pedido voto telematico");
		}
		
		if(miVotoTelematico.isVoted()){
			throw new AlredyVotedException("No habias pedido voto telematico");
		}
		
		
		miVotoTelematico.setVoted(true);
		td.save(miVotoTelematico);
		
		votoDao.save(v);
		
	}

	
}
