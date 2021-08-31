package vista;

import negocio.Negocio;

public class Interfaz
{
	
	private Negocio negocio;
	
	public Interfaz(Negocio negocio)
	{
		this.negocio=negocio;
	}
	
	
	public void abrirlLocal()
	{
		int dato=4;
		this.negocio.abrirLocal(dato);
	}
	
	public void cerrarMesa()
	{
		int dato=4;
		this.negocio.abrirLocal(dato);
	}
	
	public void ocuparMesa()
	{
		int dato=4;
		this.negocio.abrirLocal(dato);
	}
	
	
	

}
