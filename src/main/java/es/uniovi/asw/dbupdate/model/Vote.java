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

	public Vote(Date fecha, ElectoralCollege codigoColegio,
			VotableOption idElementoVotable, int cantidad){
		this.fecha=fecha;
		this.colegio=codigoColegio;
		this.elementoVotable=idElementoVotable;
		this.setCantidad(cantidad);
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
