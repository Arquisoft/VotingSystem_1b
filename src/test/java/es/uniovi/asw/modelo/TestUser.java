package es.uniovi.asw.modelo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

public class TestUser {

	@Test
	public void testBasicoUsuario() {
		User u = new User("nombre", "mail", "nif", "codigo");
		u.setContrasena("123");
		assertEquals("123", u.getContrasena());
		assertEquals("nombre",u.getNombre());
		assertEquals("mail",u.getMail());
		assertEquals("nif",u.getNif());
		assertEquals("codigo", u.getCodigoColegio());
		
		TelematicVoter t= new TelematicVoter(u, false);
		Set<TelematicVoter> miSet= new HashSet<TelematicVoter>();
		u.setTelematicVote(miSet);
		assertEquals(miSet, u.getTelematicVote());
		
		
	}

}
