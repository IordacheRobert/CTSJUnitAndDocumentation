package ro.ase.cts.teste;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.builder.Client;
import ro.ase.cts.exceptii.ExceptieNull;
import ro.ase.cts.util.TipPlata;

public class TestCaseNumeClient {


	Client client;
	
	
	@Before
	public void setUp() throws Exception {
		client=new Client("Dumistrescu", "Ion","Bucharest,sector 6,Strada Xulescu","0763625252", TipPlata.CASH);
	}

	@After
	public void tearDown() throws Exception {
		client=null;
	}
	
	@Test
	public void testNumeNull(){
		String nume=null;
		try{
		client.setNume(nume);
		}catch(ExceptieNull e){
		}
	}
	
	

	@Test
	public void testNumeValoriNormale() {
		String nume="Ilie";
		client.setNume(nume);
		assertEquals("Verificare nume cu valori normale",nume,client.getNume());
	}
	
	
	@Test
	public void testNumeGol(){
		String nume="";
		try{
			client.setNume(nume);
			fail("Verificare nume gol");
		}catch(InvalidParameterException e){
			
		}
	}
	
	
	
	@Test
	public void testNumeCuCifre(){
		String nume="Robert12";
		try{
			client.setNume(nume);
			fail("Numele nu poate contine cifre.");
		}catch(InvalidParameterException e){
			
		}
	}

	
	
	@Test
	public void testNumeLung(){
		String nume="RedWackyLeagueAntlezBroketheStereoaasdaasdasdasdasdasdasdasdasda";

		try{
			client.setNume(nume);
			fail("Verificare nume cu lungime mai mare de 50 de caractere");
		}catch(InvalidParameterException e){
			
		}
	}
	
}
