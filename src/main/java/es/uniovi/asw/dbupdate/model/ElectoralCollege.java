package es.uniovi.asw.dbupdate.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ElectoralCollege {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String codigo;
	@ManyToOne
	private ConfigurationElection configurationElection;
	@OneToMany(mappedBy="colegio")
	private Set<Vote> votos;
	
	public Set<Vote> getVotos() {
		return votos;
	}

	public void setVotos(Set<Vote> votos) {
		this.votos = votos;
	}

	ElectoralCollege() { }
	
	public ElectoralCollege(String codigo,
			ConfigurationElection configurationElection) {
		super();
		this.codigo = codigo;
		this.configurationElection = configurationElection;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ConfigurationElection getConfigurationElection() {
		return configurationElection;
	}

	public void setConfigurationElection(ConfigurationElection configurationElection) {
		this.configurationElection = configurationElection;
	}

	public String getCodigoColegio() {
		return codigo;
	}
}