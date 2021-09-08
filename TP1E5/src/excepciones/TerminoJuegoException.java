package excepciones;

public class TerminoJuegoException extends Exception 
{
	
	/**
	 * Constructor de la excepcion ejecutada cuando termino el juego
	 * @param msg : Tiene el msg por el cual fue lanzada la excepcion.
	 */
	public TerminoJuegoException(String msg)
	{
		super(msg);
	}
}
