package es.uniovi.asw.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.dbupdate.model.Colegio;

public class TestColegio {

	@Test
	public void testColegioBasico() {
		Colegio c= new Colegio("123");
		assertEquals("123",c.getCodigoColegio());
	}

}
