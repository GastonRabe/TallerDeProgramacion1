package modelo;

public class EmpleadoPermanente extends Empleado
{
	private int antiguedad;

	/**
	 * <b>pre:</b> dni debe ser un numero entero mayor que cero. Nombre debe ser distinto de vacío y distinto de null, y antiguedad debe ser un numero entero mayor o igual a cero.</br>
	 * @param dni DNI del nuevo empleado
	 * @param nombre nombre del nuevo empleado
	 * @param antiguedad antigüedad en años del nuevo empleado
	 */
	public EmpleadoPermanente(int dni, String nombre, int antiguedad)
	{
		super(dni, nombre);
		this.antiguedad = antiguedad;

	}

	public int getAntiguedad()
	{
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad)
	{
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString()
	{
		return "EmpleadoPermanente - " + super.toString() + " Antiguedad: " + this.antiguedad;
	}

}
