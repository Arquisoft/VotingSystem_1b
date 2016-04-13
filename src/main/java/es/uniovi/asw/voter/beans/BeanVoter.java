package es.uniovi.asw.voter.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.VotableOption;

public class BeanVoter {
	
	private List<ConfigurationElection> list;

	public List<ConfigurationElection> getList() {
		list = new ArrayList<>();
		
		List<VotableOption> listaOptiones = new ArrayList<>();
		List<ElectoralCollege> listaColegios = new ArrayList<>();
		
		Date fecha = new Date();
		fecha.setMonth(fecha.getMonth() - 1);
		Date applycationStart = new Date(fecha.getTime());
		fecha.setMonth(fecha.getMonth() + 2);
		Date applycationEnd = new Date(fecha.getTime());
		
		ConfigurationElection c = new ConfigurationElection("Prueba votacion",
				"Probando", applycationStart, applycationEnd, new Date(), new Date(), listaOptiones,
				listaColegios, false);
		
		list.add(c);
		
		return list;
	}

}
