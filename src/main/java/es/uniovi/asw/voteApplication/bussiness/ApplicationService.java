package es.uniovi.asw.voteApplication.bussiness;

import es.uniovi.asw.voteApplication.exception.InvalidUserException;

public interface ApplicationService {
	
	public void saveApplication(String email, String password) throws InvalidUserException;

}
