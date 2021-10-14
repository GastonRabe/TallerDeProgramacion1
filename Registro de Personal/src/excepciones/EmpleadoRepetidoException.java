package excepciones;

public class EmpleadoRepetidoException extends Exception
{
	private int dniIngresado;

	public EmpleadoRepetidoException(String message, int dniIngresado)
	{
		super(message);
		this.dniIngresado = dniIngresado;
	}

	public int getDniIngresado()
	{
		return dniIngresado;
	}
	

}
