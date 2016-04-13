package es.uniovi.asw.dbupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.repositories.TelematicVoterDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;

//TODO: cambiar restcontroler por
// controler normal
//y crear una plantilla con la que cargar datos
//rest de momento para devolver solo datos
@RestController
public class EjemploAutoWired {

	//lo inicia el controlador automatico
	@Autowired
	private UserDAO cosa;
	@Autowired
	private TelematicVoterDAO otraCosa;
	
	//cuando se pide esto
	//http://localhost:8080/magia
	 @RequestMapping("/magia")
	public Iterable<User> magia(){
		if(cosa!=null){
			//User user = new User("Pepe","","","");
			
			//cosa.save(user);
			//otraCosa.save(new TelematicVoter(user, false));
			
			//se imprime porque no es null
			System.out.println("magia");
			System.out.println("Usuarios:"+cosa.count());
			System.out.println("TelematicVoter"+otraCosa.count());
		}
		else{
			System.out.println("mal");
		}
		return cosa.findAll();
	}
}
