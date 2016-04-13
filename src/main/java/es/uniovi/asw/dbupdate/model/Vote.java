package es.uniovi.asw.dbupdate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="VOTO")
public class Vote {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date fecha;
	@ManyToOne
	private ElectoralCollege colegio;
	@ManyToOne
	private VotableOption elementoVotable;
	private int cantidad;

	Vote(){ }

	public Vote(Date fecha, ElectoralCollege colegio,
			VotableOption elementoVotable, int cantidad) {
		super();
		this.fecha = fecha;
		this.colegio = colegio;
		this.elementoVotable = elementoVotable;
		this.cantidad = cantidad;
	}



	public ElectoralCollege getColegio() {
		return colegio;
	}


	public void setColegio(ElectoralCollege colegio) {
		this.colegio = colegio;
	}


	public VotableOption getElementoVotable() {
		return elementoVotable;
	}


	public void setElementoVotable(VotableOption elementoVotable) {
		this.elementoVotable = elementoVotable;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Date getFecha() {
		return fecha;
	}

	public ElectoralCollege getIDCodigoColegio() {
		return colegio;
	}

	public VotableOption getIDOpcion() {
		return elementoVotable;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
