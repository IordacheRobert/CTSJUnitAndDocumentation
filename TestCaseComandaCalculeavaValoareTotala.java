package ro.ase.cts.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.SimpleFactory.Booster;
import ro.ase.cts.SimpleFactory.Produs;
import ro.ase.cts.exceptii.ExceptieCapacitateMaxima;
import ro.ase.cts.strategyAndObserver.Comanda;

public class TestCaseComandaCalculeavaValoareTotala {

	Comanda comanda;

	@Before
	public void setUp() throws Exception {
		comanda=new Comanda();
	}

	@After
	public void tearDown() throws Exception {
		comanda.getProduseCos().clear();
		comanda=null;
	}
	
	@Test
	public void testCaseValoareTotala10Produse() throws ExceptieCapacitateMaxima{
		long valoareAsteptata=550;
		for(int i=0;i<10;i++){
			Produs produs=new Booster();
			comanda.adaugareProdus(produs);
		}
		
		assertEquals("Verificare valoare totala 10 produse.",valoareAsteptata,comanda.calculeazaValoareaTotala());
	}
	

	@Test
	public void testCaseValoareTotalaZeroProduse() {
		long valoareAsteptata=0;
		
		assertEquals("Verificare valoare totala 0 produse.",valoareAsteptata,comanda.calculeazaValoareaTotala());
		
	}
	
	
	@Test
	public void testCaseValoareTotalaUnProdus() throws ExceptieCapacitateMaxima{
		
		Produs p= new Booster();
		comanda.adaugareProdus(p);
		long valoareAsteptata=p.pret;
		
		assertEquals("Verificare valoare totala 1 produs.",valoareAsteptata,comanda.calculeazaValoareaTotala());
	}
	
	
	@Test
	public void testCaseValoareTotalaCapacitateMaxima() throws ExceptieCapacitateMaxima{
		for(int i=0;i<comanda.getCapacitateMaxima();i++){
			comanda.adaugareProdus(new Booster());
		}
		long valoareAsteptata=comanda.getCapacitateMaxima()*55;
		valoareAsteptata=(long) (valoareAsteptata*0.7);
		assertEquals("Verificare valoare totala multe produse.",valoareAsteptata,comanda.calculeazaValoareaTotala());
	}
	
	
	
		
}
