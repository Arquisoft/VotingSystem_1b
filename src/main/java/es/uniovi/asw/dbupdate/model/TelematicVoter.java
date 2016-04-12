package es.uniovi.asw.dbupdate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Votantes_Telematicos")
public class TelematicVoter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User user;
	private boolean voted;
	private ConfigurationElection configurationElection;
	
	TelematicVoter(){ }
	
	public TelematicVoter(User user, boolean voted,
			ConfigurationElection configurationElection) {
		super();
		this.user = user;
		this.voted = voted;
		this.configurationElection = configurationElection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
	}
	
	

}
