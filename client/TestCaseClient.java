package ro.ase.cts.teste.client;


import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import ro.ase.cts.builder.Client;
import ro.ase.cts.exceptii.ExceptieNull;
import ro.ase.cts.exceptii.ExceptieNumarTelefonLungimeInvalida;
import ro.ase.cts.util.TipPlata;


public class TestCaseClient {
	//fixture
	Client client;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown");
	}

	@Test
	public void testConstructorValoriNormale() throws Exception {
		String nume="Iordache";
		String prenume="Robert";
		String adresa="Piata Romana";
		String telefon="0760000000";
		TipPlata tipPlata=TipPlata.CASH;
		client=new Client(nume, prenume, adresa, telefon, tipPlata);
		
		assertEquals("Testare constructor nume.",this.client.getNume(), client.getNume());
		assertEquals("Testare constructor prenume.",this.client.getPrenume(), client.getPrenume());
		assertEquals("Testare constructor adresa.",this.client.getAdresa(), client.getAdresa());
		assertEquals("Testare constructor telefon.",this.client.getTelefon(), client.getTelefon());
		assertEquals("Testare constructor tip plata.",this.client.getTipPlata(), client.getTipPlata());
	}
	
	
	@Test
	public void testConstructorNumeNull() {
		
		String nume=null;
		String prenume="Robert";
		String adresa="Piata Romana";
		String telefon="0760000000";
		TipPlata tipPlata=TipPlata.CASH;
		
		try{
			client=new Client(nume, prenume, adresa, telefon, tipPlata);
			fail("Lipsa exceptie la nume=null .");	
		}catch(ExceptieNull ex){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testConstructorNumarTelefonCifre(){
		String nume="Iordache";
		String prenume="Robert";
		String adresa="Piata Romana";
		String telefon="phoneNumber";
		TipPlata tipPlata=TipPlata.CASH;
		
		try{
			client=new Client(nume, prenume, adresa, telefon, tipPlata);
			fail("Numarul de telefon nu poate fi format din litere");
		}catch(InvalidParameterException e){
			
		}
	}
	
	@Test
	public void testConstructorNumarTelefonLungime(){
		String nume="Iordache";
		String prenume="Robert";
		String adresa="Piata Romana";
		String telefon="2";
		TipPlata tipPlata=TipPlata.CASH;
		
		try{
			client=new Client(nume, prenume, adresa, telefon, tipPlata);
			fail("Numar de telefon invalid ca lungime");
		}catch(ExceptieNumarTelefonLungimeInvalida e){
			
		}catch(Exception e){
			
		}
	}
	
	
	

}
