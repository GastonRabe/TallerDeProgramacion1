package negocio;

import excepciones.NumeroFueraDeRangoException;
import excepciones.TerminoJuegoException;
import modelo.Juego;

public class Monitor 
{
	/**
	 * Referencia al juego
	 */
	private Juego juego;
	/**
	 *  Constructor del monitor, donde se setea el juego, pasado por parametro.
	 *  @param juego : Parametro que trae la referencia del juego
	 */
	public Monitor(Juego juego)
	{
		this.juego=juego;
	}
	/**
	 *  Metodo que mediante la referencia al juego, llama al metodo que inica el juego
	 */
	public void IniciarJuego()
	{
		this.juego.IniciaJuego();
	}
	
	/**
	 * Metodo que mediante la referencia al juego, llama al metodo que prueba un numero
	 */
	public void ProbarNumero(int numero) throws NumeroFueraDeRangoException,TerminoJuegoException
	{
		this.juego.Prueba(numero);
	}
	/**
	 * Metodo que mediante la referencia al juego, trae la cantidad de intentos restantes.
	 * @return Devuelve la cantidad de intentos.
	 */
	public int traerIntentos()
	{
		return this.juego.traerIntentos();
	}
	/**
	* Metodo que mediante la referencia al juego, trae el ultimo estado.
	 * @return Devuelve el ultimo estado en string.
	 */
	public String traerEstado()
	{
		return this.juego.traerEstado();
	}
	
}
