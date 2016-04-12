package es.uniovi.asw.dbupdate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class User {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		@Column(name="name")
		private String nombre;
		@Column(name="ename")
		private String mail;
		private String nif;
		@Column(name="censusesinfo")
		private String codigoColegio;
		@Column(name="pass")
		private String contrasena;
		@OneToMany(mappedBy="user")
		private Set<TelematicVoter> telematicVote;
		
		protected User(){
			
		}
		public User(String nombre, String mail, String nif, String codigoColegio){
			this.nombre=nombre;
			this.mail=mail;
			this.nif=nif;
			this.codigoColegio=codigoColegio;
			telematicVote= new HashSet<TelematicVoter>();
			
		}

		public String getNombre() {
			return nombre;
		}

		public String getMail() {
			return mail;
		}

		public String getNif() {
			return nif;
		}
		public String getUser() {
			return mail;
		}

		public String getCodigoColegio() {
			return codigoColegio;
		}

		public String getContrasena() {
			return contrasena;
		}
		
		public void setContrasena(String contrasena) {
			this.contrasena=contrasena;
		}
		public Set<TelematicVoter> getTelematicVote() {
			return telematicVote;
		}
		public void setTelematicVote(Set<TelematicVoter> telematicVote) {
			this.telematicVote = telematicVote;
		}
		
		public void addTelematicvoterToSet(TelematicVoter tmad){
			telematicVote.add(tmad);
		}

	}
