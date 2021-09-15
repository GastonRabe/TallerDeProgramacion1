package test;

import org.junit.Before;
import org.junit.Test;

import modelo.Alumno;
/*agregar, buscar, eliminar y modificar Alumnos  y Profesores*/
public class TestAlumnosDatos 
{
	private EscenarioAlumnosDatos esce;

	@Before
	
	public void setUp() throws Exception
	{
		this.esce= new EscenarioAlumnosDatos();
	}
	
	
	@Test
	public void testBuscarAlumnoExitoso(String nombre)
	{
		
	}
	@Test
	public void testBuscarAlumnoNoEncontrado(String nombre)
	{
		
	}
	
	@Test
	public void eliminarAlumnoExitoso(Alumno elim)
	{
		
	}

	@Test
	public void modificarAlumnoExitoso(Alumno alumno, Alumno modif)
	{
		
	}
	@Test
	public void modificarAlumnoDatoInvalido(Alumno alumno, Alumno modif)
	{
		
	}
	
	
	


	
	
}
