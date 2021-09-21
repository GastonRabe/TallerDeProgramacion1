package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import codigo.Codigo;

public class SumoYRestoTest {

	@Test
	public void testC1() {
		Codigo.sumoyresto(25, 5);
	}
	
	@Test
	public void testC2() {
		Codigo.sumoyresto(2, 12);
	}

	
	@Test
	public void testC3() {
		Codigo.sumoyresto(4, 2);
	}

	
	@Test
	public void testC4() {
		Codigo.sumoyresto(-1, -2);
	}

//AL CORRER LOS 4 CAMINOS MINIMOS, UNO AL SER VOID Y DOS AL NUNCA ENTRAR AL PRIMER WHILE (YA QUE SUMA SERÁ SIEMPRE ==0) NO PASA REALMENTE POR NINGÚN CAMINO
//DE TODAS FORMAS SE "PROBÓ" CON DATOS PARA SIMULAR QUE PASE POR ESOS CAMINOS, SI REALMENTE PUDIESE ENTRAR AL CICLO, PODRÍA SER CAMBIANDO LA CONDICIÓN
//POR SUMA >=0, AÚN ASI NO ME RETORNARÍA NADA, Y NO HABRÍA UNA SALIDA ESPERADA, RESULTA TODO UN TANTO INNECESARIO
}
