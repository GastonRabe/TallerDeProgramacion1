package util;

public enum Mensajes
{
	ACEPTAR("Aceptar"), AGREGAR("Agregar"), EMPLEADO_ACTUAL("Empleado Actual"), PERMANENTE("Permanente"), TEMPORARIO(
			"Temporario"), DNI("DNI:"), DNI_CONSULTA("DNI a Consultar:"), CONSULTAS(
					"Consultas"), INGRESO("Ingreso"), NOMBRE("Nombre"), ANTIGUEDAD(
							"Antigüedad"), SUELDO_HORA("Sueldo x Hora"), ERROR_EMPLEADO_INEXISTENTE(
									"Empleado Inexistente"), ERROR_EMPLEADO_REPETIDO("Empleado Repetido");

	private String valor;

	private Mensajes(String valor)
	{
		this.valor = valor;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

}
