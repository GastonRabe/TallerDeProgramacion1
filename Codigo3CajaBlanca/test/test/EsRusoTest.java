package test;

import org.junit.Assert;
import org.junit.Test;

import codigo.Codigo;

public class EsRusoTest {

	@Test
	public void testCamino1() {
		boolean rta;
		rta=Codigo.es_Ruso(true, true, 8);
		Assert.assertEquals(true, rta);
	}
	//AMBOS BOOLEAN TRUE Y EL ENTERO > 5, SALIDA=TRUE
	
	@Test
	public void testCamino2() {
		boolean rta;
		rta=Codigo.es_Ruso(true, true, 5);
		Assert.assertEquals(false, rta);
	}
	//AMBOS BOOLEAN TRUE Y EL ENTERO <=5, SALIDA=FALSE
	
	@Test
	public void testCamino3() {
		boolean rta;
		rta=Codigo.es_Ruso(true, false, -45);
		Assert.assertEquals(false, rta);
	}
	//PRIMER BOOLEAN TRUE, SEGUNDO BOOLEAN FALSE, ENTERO INDISTINTO, SALIDA=FALSE
	
	@Test
	public void testCamino4() {
		boolean rta;
		rta=Codigo.es_Ruso(false, true, 16);
		Assert.assertEquals(false, rta);
	}
	//PRIMER BOOLEAN FALSE, SEGUNDO BOOLEAN Y ENTERO VALORES INDISTINTOS, SALIDA=FALSE
	

}
