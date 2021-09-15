package test;

import static org.junit.Assert.fail;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Sistema;

public class EscenarioAlumnosDatos {

	
	private Sistema sistema = new Sistema();
	private Alumno alumno;
	{
		
		this.alumno=new Alumno("Richard1","CalleFalsa1","prueba1@gmail.com");
		
		try 
		{
			this.sistema.agregarAlumno(new Alumno("Richard2","CalleFalsa2","prueba2@gmail.com"));
			this.sistema.agregarAlumno(alumno);
			this.sistema.agregarAlumno(new Alumno("Richard3","CalleFalsa3","prueba3@gmail.com"));
			this.sistema.agregarAlumno(new Alumno("Richard4","CalleFalsa4","prueba4@gmail.com"));
			this.sistema.agregarAlumno(new Alumno("Richard5","CalleFalsa5","prueba5@gmail.com"));
		} 
		catch (ClaveYaExistenteException e) 
		{
			fail("No deberia llegar aca, la clave no existe");
		} 
		catch (DatoInvalidoException e) 
		{
			fail("No deberia llegar aca, el dato es valido");
		}
	}
}