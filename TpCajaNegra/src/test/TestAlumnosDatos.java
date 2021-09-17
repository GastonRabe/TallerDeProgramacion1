package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.NoEncontradoException;
import modelo.Alumno;

public class TestAlumnosDatos{

	private EscenarioAlumnosDatos esce;

	@Before
	public void setUp() throws Exception
	{
		this.esce= new EscenarioAlumnosDatos();
	}
	
	
	@Test
	public void testBuscarAlumnoExitoso()
	{
		try
		{
			Assert.assertNotNull("Deberia encontrarlo, porque el Alumno esta, y si no esta deberia atraparlo la excepcion",this.esce.sistema.buscarAlumno("Richard2"));
		} 
		catch (NoEncontradoException e) {
			// TODO Auto-generated catch block
			Assert.fail("Deberia encontrarlo, porque el Alumno esta");
		}
	}
	
	@Test
	public void testBuscarAlumnoNoEncontrado()
	{
		try
		{
			 this.esce.sistema.buscarAlumno("ERRONEO");
			 Assert.fail("No deberia encontrarlo, el usuario no esta en sistema");
		} 
		catch (NoEncontradoException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Test
	public void eliminarAlumnoExitoso()
	{
		Alumno Alumno1=new Alumno("YoNoExisto","ProebaNoExiste","prueba23@gmail.com");
		try
		{
			this.esce.sistema.agregarAlumno(Alumno1);
			this.esce.sistema.eliminarAlumno(Alumno1);
			Assert.assertNull("Deberia ser nulo el retorno, ya que el Alumno debio ser eliminado del sistema",this.esce.sistema.buscarAlumno("YoNoExisto"));
		} 
		catch (NoEncontradoException e) 
		{
			
		} catch (ClaveYaExistenteException e) {
			
			Assert.fail("No debe entrar, es por el agregar Alumno, no es el metodo a testear");
		} catch (DatoInvalidoException e) {

			Assert.fail("No debe entrar, es por el agregar Alumno, no es el metodo a testear");
		}
	}
	
	

	@Test
	public void modificarAlumnoExitoso()
	{	
		Alumno Alumno1=new Alumno("Prueba","Proeba","prueba@gmail.com");
		Alumno Alumno2=new Alumno("Prueba2","Proeba2","prueba@gmail.com");
		try 
		{
			this.esce.sistema.agregarAlumno(Alumno1);
			this.esce.sistema.modificarAlumno(Alumno1,Alumno2);
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",Alumno1.getApellidoNombre()==Alumno2.getApellidoNombre());
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",Alumno1.getMail()==Alumno2.getMail());
			Assert.assertTrue("El legajo deberia haber sido modificado y el assert no deberia lanzarse",Alumno1.getDomicilio()==Alumno2.getDomicilio());
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
	public void modificarAlumnoDatoInvalido()
	{
		Alumno Alumno1=new Alumno("Prueba","Proeba","prueba@gmail.com");
		Alumno Alumno2=new Alumno("Prueba2","Proeba2","prueba@gmail.com");
		try 
		{
			this.esce.sistema.agregarAlumno(Alumno1);
			Alumno2.setMail("-120");
			this.esce.sistema.modificarAlumno(Alumno1,Alumno2);
			Assert.fail("No deberia modificarse, debido a que tiene un atributo erroneo");
		}
		catch( DatoInvalidoException e)
		{
			
		}
		catch (ClaveYaExistenteException e2) {
			
			Assert.fail("No deberia capturarse esta excepcion, agregarAlumno no es el metodo a testear, ademas el Alumno no es repetido");
		}
	}
}