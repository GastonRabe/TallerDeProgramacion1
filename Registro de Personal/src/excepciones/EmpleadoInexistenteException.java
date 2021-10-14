package excepciones;

public class EmpleadoInexistenteException extends Exception
{
	private int dniConsultado;

	public EmpleadoInexistenteException(String message, int dniConsultado)
	{
		super(message);
		this.dniConsultado = dniConsultado;
	}

	public int getDniConsultado()
	{
		return dniConsultado;
	}
	

}
