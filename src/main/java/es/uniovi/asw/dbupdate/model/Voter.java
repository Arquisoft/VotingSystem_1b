package es.uniovi.asw.dbupdate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Voter {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String nombre;
		private String mail;
		private String nif;
		private String codigoColegio;
		private String contrasena;
		
		protected Voter(){
			
		}
		public Voter(String nombre, String mail, String nif, String codigoColegio){
			this.nombre=nombre;
			this.mail=mail;
			this.nif=nif;
			this.codigoColegio=codigoColegio;
			
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


	}
