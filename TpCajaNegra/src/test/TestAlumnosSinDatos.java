package test;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Profesor;

public class TestAlumnosSinDatos {

	private EscenarioAlumnosSinDatos esce;
	
	@Before
	public void setUp() throws Exception 
	{
		this.esce=new EscenarioAlumnosSinDatos();
	}	
	
	@Test
	public void testAgregarAlumnoExitoso()
	{
		Alumno alumno = new Alumno("Prueba","Proeba","email@gmail.com");
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
		}
		catch (ClaveYaExistenteException e) {
			// TODO Auto-generated catch block
			Assert.fail("no debe entrar aca, unica clave agregada");
		}
		catch (DatoInvalidoException e) {
			// TODO Auto-generated catch block
			Assert.fail("No tiene que entrar aca, datos correctos");
		}
		
		Assert.assertTrue("ALUMNO NO AGREGADO", this.esce.sistema.getAlumnos().contieneValor(alumno));
		
	}
	
	@Test
	public void testAgregarAlumnoClaveRep()
	{
		
		Alumno alumno = new Alumno("Prueba","Proeba","email@gmail.com");
		Alumno alumno2 = new Alumno("Prueba","asd","emai123l@gmail.com");
		alumno.setLegajo(Alumno.getNuevoLegajo());
		alumno2.setLegajo(alumno.getLegajo());
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
			this.esce.sistema.agregarAlumno(alumno2);
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
	public void testAgregarAlumnoDatoInv()
	{
		Alumno alumno = new Alumno(null,"1","88");
		try 
		{
			this.esce.sistema.agregarAlumno(alumno);
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
