package Test;

import org.junit.Assert;
import org.junit.Test;

import codigo.Codigo;

public class HorasExtrasTest {

	@Test
	public void testCamino1() {
		double resultado;
		resultado=Codigo.horasExtras(12,15,10);
		Assert.assertEquals(13, resultado, 0);
	}
	//CAMINO LARGO EN DONDE CUMPLE TODAS LAS CONDICIONES, RETORNA PARAM2+PARAM3-PARAM1
	@Test
	public void testCamino2() {
		double resultado;
		resultado=Codigo.horasExtras(13,5,8);
		Assert.assertEquals(0, resultado, 0);
	}
	//CUMPLE LAS CONDICIONES DEL PRIMER IF, PERO LA SUMA DE LOS PARAMETROS NO DA MAYOR A 0, RETORNA 0
	@Test
	public void testCamino3() {
		double resultado;
		resultado=Codigo.horasExtras(10,3,-1);
		Assert.assertEquals(-1, resultado, 0);
	}
	//NO CUMPLE LA PRIMER CONDICION DEL PRIMER IF, RETORNA -1
	@Test
	public void testCamino4() {
		double resultado;
		resultado=Codigo.horasExtras(10,-1,2);
		Assert.assertEquals(-1, resultado,0);
	}
	//NO CUMPLE LA SEGUNDA CONDICION DEL PRIMER IF, RETORNA -1
	@Test
	public void testCamino5() {
		double resultado;
		resultado=Codigo.horasExtras(-1,3,2);
		Assert.assertEquals(-1, resultado,0);
	}
	//NO CUMPLE LA TERCERA CONDICION DEL PRIMER IF, RETORNA -1

}
