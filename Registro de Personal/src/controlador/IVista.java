package controlador;

import modelo.Empleado;

public interface IVista
{
int getDNI();
String getNombre();
int getAntiguedad();
double getSueldoHora();
String getTipoEmpleado();
int getDNIConsulta();
void actualizaEmpleadoActual(Empleado empleado);
boolean aceptarEnabled();
boolean agregarEnabled();
boolean antiguedadEnabled();
boolean sueldoEnabled();

}
