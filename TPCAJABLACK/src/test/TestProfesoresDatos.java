package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Profesor;

public class TestProfesoresDatos {

	private EscenarioProfesoresSinDatos esce;
	
	@Before
	public void setUp() throws Exception 
	{
		this.esce=new EscenarioProfesoresSinDatos();

	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public void testAgregarProfesorExitoso(Profesor nuevo)
	{
		Profesor Profesor = new Profesor("Prueba","Proeba","email@gmail.com","223564654");
		try 
		{
			this.esce.sistema.agregarProfesor(Profesor);
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			fail("no debe entrar aca, unica clave agregada");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			fail("No tiene que entrar aca, datos correctos");
		}
		
		Assert.assertTrue("Profesor NO AGREGADO", this.esce.sistema.getProfesores().contieneValor(Profesor));
		
	}
	
	@Test
	public void testAgregarProfesorClaveRep(Profesor nuevo)
	{
		
		Profesor Profesor = new Profesor("Prueba","Proeba","email@gmail.com","22365456");
		Profesor Profesor2 = new Profesor("Prueba","asd","emai123l@gmail.com","22265498");
		try 
		{
			this.esce.sistema.agregarProfesor(Profesor);
			this.esce.sistema.agregarProfesor(Profesor2);
			fail("No deberia haber agregado");
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			fail("No tiene que entrar aca, duplico claves");
		}
		
		
	}
	
	@Test
	public void testAgregarProfesorDatoInv(Profesor nuevo)
	{
		Profesor Profesor = new Profesor("-999","1","88","");
		try 
		{
			this.esce.sistema.agregarProfesor(Profesor);
			fail("No deberia haber agregado");
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			fail("No tiene que entrar aca, datos invalidos");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			
		}
	}
}