package es.uniovi.asw.dbupdate.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CONFIGURACION")
public class ConfigurationElection {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Date applicationStart;
	private Date applicationEnd;
	private Date votationStart;
	private Date votationEnd;
	private boolean multipleVoting;

	@OneToMany(mappedBy="configurationElection")
	private Set<TelematicVoter> telematicVote;
	@OneToMany(mappedBy="configurationElection")
	private Set<VotableOption> votableOptions;
	@OneToMany(mappedBy="configurationElection")
	private Set<ElectoralCollege> electoralColleges;

	public ConfigurationElection(){

	}
	
	public ConfigurationElection(String name, String description,
			Date applicationStart, Date applicationEnd, Date votationStart,
			Date votationEnd, Set<VotableOption> votableOptions,
			Set<ElectoralCollege> electoralColleges, boolean multipleVoting) {
		
		super();
		this.name = name;
		this.description = description;
		this.applicationStart = applicationStart;
		this.applicationEnd = applicationEnd;
		this.votationStart = votationStart;
		this.votationEnd = votationEnd;
		this.votableOptions = votableOptions;
//		this.electoralColleges = electoralColleges;
		this.multipleVoting = multipleVoting;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getApplicationStart() {
		return applicationStart;
	}

	public void setApplicationStart(Date applicationStart) {
		this.applicationStart = applicationStart;
	}

	public Date getApplicationEnd() {
		return applicationEnd;
	}

	public void setApplicationEnd(Date applicationEnd) {
		this.applicationEnd = applicationEnd;
	}

	public Date getVotationStart() {
		return votationStart;
	}

	public void setVotationStart(Date votationStart) {
		this.votationStart = votationStart;
	}

	public Date getVotationEnd() {
		return votationEnd;
	}

	public void setVotationEnd(Date votationEnd) {
		this.votationEnd = votationEnd;
	}

	public Set<VotableOption> getVotableOptions() {
		return votableOptions;
	}

	public void setVotableOptions(Set<VotableOption> votableOptions) {
		this.votableOptions = votableOptions;
	}

	public Set<ElectoralCollege> getElectoralColleges() {
		return electoralColleges;
	}

	public void setElectoralColleges(Set<ElectoralCollege> electoralColleges) {
		this.electoralColleges = electoralColleges;
	}

	public Set<TelematicVoter> getTelematicVote() {
		return telematicVote;
	}

	public void setTelematicVote(Set<TelematicVoter> telematicVote) {
		this.telematicVote = telematicVote;
	}
	
	public boolean isMultipleVoting() {
		return multipleVoting;
	}

	public void setMultipleVoting(boolean multipleVoting) {
		this.multipleVoting = multipleVoting;
	}
	
	public ConfigurationElection getConfigurationElection() {
		return this;
	}

}
