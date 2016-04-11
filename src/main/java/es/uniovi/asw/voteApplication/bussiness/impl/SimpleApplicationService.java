package es.uniovi.asw.voteApplication.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.voteApplication.bussiness.ApplicationService;

@Component
public class SimpleApplicationService implements ApplicationService {
	
	@Autowired(required=true)
	private UserDAO ud;
	@Autowired(required=true)
	private TelematicVoterDAO td;

	@Override
	public String saveApplication(String email, String password) {
				
		if(ud == null){
			System.out.println("mal rollo");
		}
		else{
			System.out.println("buen rollo");
			User user = ud.findByMailAndContrasena(email, password);
			
			if(user == null){
			}
			
			TelematicVoter telematic = new TelematicVoter(user, false);
			td.save(telematic);
			
		}
		return "Exito";
	}

}
