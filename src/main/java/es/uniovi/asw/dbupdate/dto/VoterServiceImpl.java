package es.uniovi.asw.dbupdate.dto;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import es.uniovi.asw.dbupdate.model.Voter;



public class VoterServiceImpl {

	
	@Autowired
	private VoterRepository repositorio;
	
	public VoterServiceImpl() {
		
	}
	
	
 

    public List<Voter> magia(){
    	repositorio.save(new Voter("david", "333", "333", "333"));
        System.out.println(repositorio.findByNombre("david").get(0).getNif());
        return repositorio.findByNombre("david");
    }
	
}
