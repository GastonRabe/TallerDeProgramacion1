package main;

import controlador.Controlador;
import modelo.BeerHouse;
import negocio.Negocio;
import vista.Interfaz;

public class Main {

	public static void main(String[] args) {
		BeerHouse j=new BeerHouse(20);
		Negocio m=new Negocio(j);
		Interfaz vista = new Interfaz();
		Controlador controlador = new Controlador(m,vista);
		vista.setVisible(true);

	}

}
