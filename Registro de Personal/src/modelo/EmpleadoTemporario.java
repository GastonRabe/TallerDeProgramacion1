package modelo;

public class EmpleadoTemporario extends Empleado

{
	private double sueldoPorHora;

	/**
	 * <b>pre:</b> dni debe ser un numero entero mayor que cero. Nombre debe ser distinto de vacío y distinto de null, y sueldoPorHora debe ser un numero double mayor a cero.</br>
	 * @param dni DNI del nuevo empleado
	 * @param nombre Nombre del nuevo empleado
	 * @param sueldoPorHora Sueldo por hora del nuevo empleado
	 */
	public EmpleadoTemporario(int dni, String nombre, double sueldoPorHora)
	{
		super(dni, nombre);
		this.sueldoPorHora = sueldoPorHora;
	}

	public double getSueldoPorHora()
	{
		return sueldoPorHora;
	}

	public void setSueldoPorHora(double sueldoPorHora)
	{
		this.sueldoPorHora = sueldoPorHora;
	}

	@Override
	public String toString()
	{
		return "EmpleadoTemporario - " + super.toString() + " sueldo Por Hora " + this.sueldoPorHora;
	}
	

}
