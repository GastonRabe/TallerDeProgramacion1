package test;

import static org.junit.Assert.fail;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Profesor;
import modelo.Sistema;

public class EscenarioProfesoresDatos {

	private Sistema sistema = new Sistema();
	private Profesor Profesor;
	{
		
		this.Profesor=new Profesor("Richard1","CalleFalsa1","prueba1@gmail.com","223654564");
		
		try 
		{
			this.sistema.agregarProfesor(new Profesor("Richard2","CalleFalsa2","prueba2@gmail.com","223654353"));
			this.sistema.agregarProfesor(Profesor);
			this.sistema.agregarProfesor(new Profesor("Richard3","CalleFalsa3","prueba3@gmail.com","223346372"));
			this.sistema.agregarProfesor(new Profesor("Richard4","CalleFalsa4","prueba4@gmail.com","223652324"));
			this.sistema.agregarProfesor(new Profesor("Richard5","CalleFalsa5","prueba5@gmail.com","226347744"));
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
