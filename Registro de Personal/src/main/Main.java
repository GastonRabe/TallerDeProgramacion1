package main;

import controlador.Controlador;
import util.Mensajes;
import vista.Ventana;

public class Main
{

	public static void main(String[] args)
	{
		//ingles();
		Ventana ventana = new Ventana();
	}

	private static void ingles()
	{
		Mensajes.ACEPTAR.setValor("Accept");
		Mensajes.AGREGAR.setValor("Add");
		Mensajes.ANTIGUEDAD.setValor("Antiquity");
		Mensajes.CONSULTAS.setValor("Queries");
		Mensajes.DNI.setValor("Id");
		Mensajes.DNI_CONSULTA.setValor("Id for Query");
		Mensajes.EMPLEADO_ACTUAL.setValor("Current employee");
		Mensajes.ERROR_EMPLEADO_INEXISTENTE.setValor("Non-existent employee");
		Mensajes.ERROR_EMPLEADO_REPETIDO.setValor("Repeated employee");
		Mensajes.INGRESO.setValor("Entry");
		Mensajes.NOMBRE.setValor("Name");
		Mensajes.PERMANENTE.setValor("Permanent");
		Mensajes.TEMPORARIO.setValor("Temporary");
		Mensajes.SUELDO_HORA.setValor("Salary per hour");
	}
}
