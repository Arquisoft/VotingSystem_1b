package es.uniovi.asw.voter.vote.beans;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.voter.vote.bussiness.VoterVoteService;

public class BeanOptions {
	
	List<VotableOption> votableOptions;

	public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection) {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		VoterVoteService vvs = ctx.getBean(VoterVoteService.class);
		
		return vvs.getVotableOptions(configurationElection);
	}

}
