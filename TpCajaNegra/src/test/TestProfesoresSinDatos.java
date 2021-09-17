package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Profesor;

public class TestProfesoresSinDatos {

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
	public void testAgregarProfesorExitoso()
	{
		Profesor Profesor = new Profesor("Prueba","Proeba","email@gmail.com","223564654");
		try 
		{
			this.esce.sistema.agregarProfesor(Profesor);
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			Assert.fail("no debe entrar aca, unica clave agregada");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No tiene que entrar aca, datos correctos");
		}
		
		Assert.assertTrue("Profesor NO AGREGADO", this.esce.sistema.getProfesores().contieneValor(Profesor));
		
	}
	
	@Test
	public void testAgregarProfesorClaveRep()
	{
		Profesor profesor = new Profesor("Prueba","Proeba","email@gmail.com","22265498");
		Profesor profesor2 = new Profesor("Prueba2","Proeba2","email2@gmail.com","22265469");
		profesor.setLegajo(Profesor.getNuevoLegajo());
		profesor2.setLegajo(profesor.getLegajo());
		try 
		{
			this.esce.sistema.agregarProfesor(profesor);
			this.esce.sistema.agregarProfesor(profesor2);
			Assert.fail("No deberia haber agregado");
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No tiene que entrar aca, duplico claves");
		}
		
		
	}
	
	@Test
	public void testAgregarProfesorDatoInv()
	{
		Profesor Profesor = new Profesor("-999","1","88","");
		try 
		{
			this.esce.sistema.agregarProfesor(Profesor);
			Assert.fail("No deberia haber agregado");
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			Assert.fail("No tiene que entrar aca, datos invalidos");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			
		}
	}

}
