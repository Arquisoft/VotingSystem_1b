package es.uniovi.asw.dbupdate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	private List<VotableOption> votableOptions;
	@ManyToOne
	private List<ElectoralCollege> electoralColleges;
	private boolean multipleVoting;

	ConfigurationElection(){

	}
	
	public ConfigurationElection(String name, String description,
			Date applicationStart, Date applicationEnd, Date votationStart,
			Date votationEnd, List<VotableOption> votableOptions,
			List<ElectoralCollege> electoralColleges, boolean multipleVoting) {
		
		super();
		this.name = name;
		this.description = description;
		this.applicationStart = applicationStart;
		this.applicationEnd = applicationEnd;
		this.votationStart = votationStart;
		this.votationEnd = votationEnd;
		this.votableOptions = votableOptions;
		this.electoralColleges = electoralColleges;
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

	public List<VotableOption> getVotableOptions() {
		return votableOptions;
	}

	public void setVotableOptions(List<VotableOption> votableOptions) {
		this.votableOptions = votableOptions;
	}

	public List<ElectoralCollege> getElectoralColleges() {
		return electoralColleges;
	}

	public void setElectoralColleges(List<ElectoralCollege> electoralColleges) {
		this.electoralColleges = electoralColleges;
	}

	public boolean isMultipleVoting() {
		return multipleVoting;
	}

	public void setMultipleVoting(boolean multipleVoting) {
		this.multipleVoting = multipleVoting;
	}


}
