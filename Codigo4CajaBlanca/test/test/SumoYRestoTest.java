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

//AL CORRER LOS 4 CAMINOS MINIMOS, UNO AL SER VOID Y DOS AL NUNCA ENTRAR AL PRIMER WHILE (YA QUE SUMA SER� SIEMPRE ==0) NO PASA REALMENTE POR NING�N CAMINO
//DE TODAS FORMAS SE "PROB�" CON DATOS PARA SIMULAR QUE PASE POR ESOS CAMINOS, SI REALMENTE PUDIESE ENTRAR AL CICLO, PODR�A SER CAMBIANDO LA CONDICI�N
//POR SUMA >=0, A�N ASI NO ME RETORNAR�A NADA, Y NO HABR�A UNA SALIDA ESPERADA, RESULTA TODO UN TANTO INNECESARIO
}
