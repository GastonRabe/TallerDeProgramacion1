package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Profesor;

public class TestProfesores{

	private EscenarioProfesoresDatos esce;

	@Before
	public void setUp() throws Exception
	{
		this.esce= new EscenarioProfesoresDatos();
	}
	
	
	@Test
	public void testBuscarProfesorExitoso()
	{
		try
		{
			Assert.assertNotNull("Deberia encontrarlo, porque el Profesor esta, y si no esta deberia atraparlo la excepcion",this.esce.sistema.buscarProfesor("Richard2"));
		} 
		catch (NoEncontradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("Deberia encontrarlo, porque el profesor esta");
		}
	}
	
	@Test
	public void testBuscarProfesorNoEncontrado()
	{
		try
		{
			 this.esce.sistema.buscarProfesor("ERRONEO");
			 Assert.fail("No deberia encontrarlo, el usuario no esta en sistema");
		} 
		catch (NoEncontradoException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Test
	public void eliminarProfesorExitoso()
	{
		Profesor profesor1=new Profesor("YoNoExisto","Proeeba","pruebaNoExisto@gmail.com","223541552");
		try
		{
			this.esce.sistema.agregarProfesor(profesor1);
			this.esce.sistema.eliminarProfesor(profesor1);
			Assert.assertNull("Deberia ser nulo el retorno, ya que el Profesor debio ser eliminado del sistema",this.esce.sistema.buscarProfesor("YoNoExisto"));
		} 
		catch (NoEncontradoException e) 
		{
			
		} catch (ClaveYaExistenteException e) {
			
			Assert.fail("No debe entrar, es por el agregar profesor, no es el metodo a testear");
		} catch (DatoInvalidoException e) {

			Assert.fail("No debe entrar, es por el agregar profesor, no es el metodo a testear");
		}
	}
	
	

	@Test
	public void modificarProfesorExitoso()
	{	
		Profesor profesor1=new Profesor("Prueba","Proeba","prueba@gmail.com","223541552");
		Profesor profesor2=new Profesor("Prueba2","Proeba2","prueba@gmail.com","22354187");
		try 
		{
			this.esce.sistema.agregarProfesor(profesor1);
			this.esce.sistema.modificarProfesor(profesor1,profesor2);
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",profesor1.getApellidoNombre()==profesor2.getApellidoNombre());
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",profesor1.getMail()==profesor2.getMail());
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",profesor1.getTelefono()==profesor2.getTelefono());
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",profesor1.getDomicilio()==profesor2.getDomicilio());
		}
		catch ( DatoInvalidoException e2)
		{
			Assert.fail("Los datos son validos, no deberia capturar esta excepcion");
		} catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			Assert.fail("No es el metodo a testear, no deberia entrara aca");
		}
	}
	
	
	@Test
	public void modificarProfesorDatoInvalido()
	{
		Profesor profesor1=new Profesor("Prueba","Proeba","prueba@gmail.com","223541552");
		Profesor profesor2=new Profesor("Prueba2","Proeba2","prueba@gmail.com","22354187");
		try 
		{
			this.esce.sistema.agregarProfesor(profesor1);
			profesor2.setMail("-120");
			this.esce.sistema.modificarProfesor(profesor1,profesor2);
			Assert.fail("No deberia modificarse, debido a que tiene un atributo erroneo");
		}
		catch( DatoInvalidoException e)
		{
			
		}
		catch (ClaveYaExistenteException e2) {
			
			Assert.fail("No deberia capturarse esta excepcion, agregarProfesor no es el metodo a testear, ademas el Profesor no es repetido");
		}
	}
}