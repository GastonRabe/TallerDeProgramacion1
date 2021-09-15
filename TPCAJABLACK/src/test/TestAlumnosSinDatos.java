package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;

public class TestAlumnosSinDatos {

	
	private EscenarioAlumnosSinDatos esce;

	
	@Before
	public void setUp() throws Exception 
	{
		this.esce=new EscenarioAlumnosSinDatos();

	}

	@After
	public void tearDown() throws Exception {
	}	
	
	@Test
	public void testAgregarAlumnoExitoso(Alumno nuevo)
	{
		Alumno alumno = new Alumno("Prueba","Proeba","email@gmail.com");
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			fail("no debe entrar aca, unica clave agregada");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			fail("No tiene que entrar aca, datos correctos");
		}
		
		Assert.assertTrue("ALUMNO NO AGREGADO", this.esce.sistema.getAlumnos().contieneValor(alumno));
		
	}
	
	@Test
	public void testAgregarAlumnoClaveRep(Alumno nuevo)
	{
		
		Alumno alumno = new Alumno("Prueba","Proeba","email@gmail.com");
		Alumno alumno2 = new Alumno("Prueba","asd","emai123l@gmail.com");
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
			this.esce.sistema.agregarAlumno(alumno2);
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
	public void testAgregarAlumnoDatoInv(Alumno nuevo)
	{
		Alumno alumno = new Alumno("-999","1","88");
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
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
