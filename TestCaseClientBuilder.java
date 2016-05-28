package ro.ase.cts.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.builder.Client;
import ro.ase.cts.builder.ClientBuilder;
import ro.ase.cts.util.TipPlata;

public class TestCaseClientBuilder {
	
	@Test
	public void testCaseCreareClient() {
		String nume="Vasile";
		String prenume="Ion";
		String adresa="Bucuresti";
		String telefon="0762186969";
		TipPlata tipPlata=TipPlata.CASH;
		
		
		
		Client valoareAsteptata=new Client(nume,prenume,adresa,telefon,tipPlata);
		
		Client valoareObtinuta=new ClientBuilder(nume, prenume)
				.setAdresa(adresa)
				.setTelefon(telefon)
				.setTipPlata(tipPlata).build();
		
		assertEquals("Verificare asemanare obiect creat cu  ClientBuilder",valoareAsteptata,valoareObtinuta);
	}

}
