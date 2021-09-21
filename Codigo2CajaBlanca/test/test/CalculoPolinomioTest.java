package test;

import org.junit.Assert;
import org.junit.Test;

import codigo.Codigo;

public class CalculoPolinomioTest {

	@Test
	public void testC1() {
		float [] coef = new float[] {2,3,0};
		float rta;
		rta=Codigo.calculopolinomio(2,coef,(Integer)coef.length-1);
		Assert.assertEquals(0, rta, 0);
	}
	//NUNCA ENTRARÍA AL CICLO YA QUE LA CONDICIÓN DE CORTE ES QUE EL GRADO SEA MENOR A 0, Y NO EXISTE TAL POLINOMIO QUE CUMPLA CON ESE GRADO, SALIDA=0
	@Test
	public void testC2() {
		float [] coef = {5};
		float rta;
		rta=Codigo.calculopolinomio(2,coef,(Integer)coef.length-1);
		Assert.assertEquals(0, rta, 0);
	}
	//NUNCA ENTRARÍA AL CICLO YA QUE LA CONDICIÓN DE CORTE ES QUE EL GRADO SEA MENOR A 0, Y NO EXISTE TAL POLINOMIO QUE CUMPLA CON ESE GRADO, SALIDA=0

}
