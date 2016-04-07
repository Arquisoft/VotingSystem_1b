package es.uniovi.asw.dbupdate.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbupdate.model.Voter;

//TODO: cambiar restcontroler por
// controler normal
//y crear una plantilla con la que cargar datos
//rest de momento para devolver solo datos
@RestController
public class EjemploAutoWired {

	//lo inicia el controlador automatico
	@Autowired
	private VoterDAO cosa;
	
	//cuando se pide esto
	//http://localhost:8080/magia
	 @RequestMapping("/magia")
	public Iterable<Voter> magia(){
		if(cosa!=null){
			//se imprime porque no es null
			System.out.println("magia");
			System.out.println("Usuarios:"+cosa.count());
		}
		else{
			System.out.println("mal");
		}
		return cosa.findAll();
	}
}
