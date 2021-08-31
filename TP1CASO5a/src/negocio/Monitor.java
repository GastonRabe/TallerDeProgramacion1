package negocio;

import excepciones.NumeroFueraDeRangoException;
import excepciones.TerminoJuegoException;
import modelo.Juego;

public class Monitor 
{
	
	private Juego juego;
	
	public Monitor(Juego juego)
	{
		this.juego=juego;
	}
	
	public void IniciarJuego()
	{
		this.juego.IniciaJuego();
	}
	
	
	public void ProbarNumero(int numero) throws NumeroFueraDeRangoException,TerminoJuegoException
	{
		this.juego.Prueba(numero);
	}
	
	public int traerIntentos()
	{
		return this.juego.traerIntentos();
	}
	
	public String traerEstado()
	{
		return this.juego.traerEstado();
	}
	
}
