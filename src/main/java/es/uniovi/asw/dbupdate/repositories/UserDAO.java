package es.uniovi.asw.dbupdate.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.User;

@Repository
public interface UserDAO  extends CrudRepository<User, Long> { 

	   public List<User> findByNombre(String nombre);
	   public User findByMailAndContrasena(String mail, String contrasena);
	   
	  // public List<User> findByLoginAndPassword(String login, String password);
	
}
