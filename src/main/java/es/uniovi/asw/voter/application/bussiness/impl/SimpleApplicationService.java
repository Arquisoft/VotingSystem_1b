package es.uniovi.asw.voter.application.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.voter.application.bussiness.ApplicationService;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

@Component
public class SimpleApplicationService implements ApplicationService {

	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;

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

}
