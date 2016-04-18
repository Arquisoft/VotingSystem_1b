package es.uniovi.asw.modelo;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.TelematicVoter;
import es.uniovi.asw.dbupdate.model.User;

public class UserTest {

	@Test
	public void testBasicoUsuario() {
		User u = new User("nombre", "mail", "nif", null);
		u.setContrasena("123");
		assertEquals("123", u.getContrasena());
		assertEquals("nombre",u.getNombre());
		assertEquals("mail",u.getMail());
		assertEquals("nif",u.getNif());
		assertEquals(null, u.getCodigoColegio());
		
		TelematicVoter t= new TelematicVoter(u, false, null);
		Set<TelematicVoter> miSet= new HashSet<TelematicVoter>();
		miSet.add(t);
		u.setTelematicVote(miSet);
		assertEquals(miSet, u.getTelematicVote());
		
		
	}

}
