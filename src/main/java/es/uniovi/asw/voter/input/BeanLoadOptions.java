package es.uniovi.asw.voter.input;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.model.Vote;
import es.uniovi.asw.voter.application.exception.InvalidUserException;
import es.uniovi.asw.voter.vote.bussiness.VoteInputService;
import es.uniovi.asw.voter.vote.bussiness.VoterVoteService;
import es.uniovi.asw.voter.vote.exception.AlredyVotedException;
import es.uniovi.asw.voter.vote.exception.BusinessException;


@Component
public class BeanLoadOptions {
	
		
		private List<VotableOption> selectOption;
		private List<Vote> votos;
		private ConfigurationElection configurationElection;

		
		public List<VotableOption> getVotableOptions(ConfigurationElection configurationElection) {
			WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			VoterVoteService vvs = ctx.getBean(VoterVoteService.class);
			this.configurationElection = configurationElection;
			
			selectOption=vvs.getVotableOptions(configurationElection);
			return selectOption;
		}
		
		public void loadVote(){
			boolean fail = false;
			WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			VoteInputService vvs = ctx.getBean(VoteInputService.class);
			try {
			for(int i=0;i<selectOption.size();i++){
				vvs.loadVoteForOption(configurationElection, votos.get(i));
				
				
			}
			
			
			} catch ( BusinessException
					e) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
		        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
		        fail=true;
			}
			if(!fail){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Carga de datos correcta");
		        FacesContext.getCurrentInstance().addMessage("form-cuerpo:all", msg);
			}
		}

	}


