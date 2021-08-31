package main;

import controlador.Controlador;
import modelo.Juego;
import negocio.Monitor;
import vista.Interfaz;

public class Main {

	public static void main(String[] args) 
	{
		Juego j=new Juego();
		Monitor m=new Monitor(j);
		Interfaz vista = new Interfaz();
		Controlador controlador = new Controlador(m,vista);
		vista.setVisible(true);

	}

}
