package excepciones;

public class NumeroFueraDeRangoException extends Exception
{
	/**
	 * Constructor de la excepcion ejecutada cuando el numero generado esta fuera de rango
	 * @param msg : Tiene el msg por el cual fue lanzada la excepcion.
	 */
	public NumeroFueraDeRangoException(String msg)
	{
		super(msg);
	}
}
