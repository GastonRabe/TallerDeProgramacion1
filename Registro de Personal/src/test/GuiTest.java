package test;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import util.Mensajes;
import vista.Ventana;

public class GuiTest {

	Robot robot;
	Controlador controlador;
	// SwingOptionPane op = new SwingOptionPane();
	FalsoOptionPane op = new FalsoOptionPane();

	public GuiTest() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	}

	@Before
	public void setUp() throws Exception {
		controlador = Controlador.getInstance();
		controlador.setOptionpane(op);
	}

	@Test
	public void testIngresoPermanenteOk() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton permanente = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnPermanente");
		JTextField antiguedad = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldAntiguedad");
		JButton agregar = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAgregar");
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JButton aceptaConsulta = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAceptar");
		JTextField empleadoActual = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldEmpleadoActual");
		// lleno los JTextField
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Valentin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("42157718", robot);
		TestUtils.clickComponent(permanente, robot);
		TestUtils.clickComponent(antiguedad, robot);
		TestUtils.tipeaNum("15", robot);
		TestUtils.clickComponent(agregar, robot);
		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("42157718", robot);
		TestUtils.clickComponent(aceptaConsulta, robot);
		// verifico los resultados
		Assert.assertEquals("Deberia de coincidir el nombre", "Valentin", empleadoActual.getText());

		Assert.assertEquals("Debería de coincidir el tipo de contratacion", "PERMANENTE",
				Controlador.getInstance().getVista().getTipoEmpleado());
		TestUtils.borraJTextField(consultaDNI, robot);
	}

	@Test
	public void testIngresosTemporarioOk() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton temporario = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnTemporario");
		JTextField sueldo = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldSueldoHora");
		JButton agregar = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAgregar");
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JButton aceptaConsulta = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAceptar");
		JTextField empleadoActual = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldEmpleadoActual");
		// lleno los JTextField
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Martin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("4548", robot);
		TestUtils.clickComponent(temporario, robot);
		TestUtils.clickComponent(sueldo, robot);
		TestUtils.tipeaNum("21", robot);
		TestUtils.clickComponent(agregar, robot);
		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("4548", robot);
		TestUtils.clickComponent(aceptaConsulta, robot);
		// verifico los resultados
		Assert.assertEquals("Deberia de coincidir el nombre", "Martin", empleadoActual.getText());

		Assert.assertEquals("Debería de coincidir el tipo de contratacion", "TEMPORARIO",
				Controlador.getInstance().getVista().getTipoEmpleado());
		TestUtils.borraJTextField(consultaDNI, robot);

	}

	@Test
	public void testCaracterNombre() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton temporario = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnTemporario");
		JTextField sueldo = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldSueldoHora");
		JButton agregar = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAgregar");
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JButton aceptaConsulta = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAceptar");
		JTextField empleadoActual = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldEmpleadoActual");
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("456", robot);
		TestUtils.clickComponent(temporario, robot);
		TestUtils.clickComponent(sueldo, robot);
		TestUtils.tipeaNum("15.2", robot);
		TestUtils.clickComponent(agregar, robot);
		Assert.assertFalse("El nombre debe tener como mínimo un caracter",
				Controlador.getInstance().getVista().agregarEnabled());
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.borraJTextField(dni, robot);
		// Assert.assertEquals("Incorrecto, el usuario nunca debería de haberse
		// ingresado por lo tanto la casilla no se borraría", 456,
		// Controlador.getInstance().getVista().getDNI());
	}

	/**
	 * ACA TESTEO SI SE HABILITA EL CAMPO ANTIGUEDAD (PONIENDO UN EMPLEADO
	 * TEMPORARIO)
	 */
	@Test
	public void testCampoAntiguedadErroneo() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton temporario = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnTemporario");

		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Valentin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("123456", robot);
		TestUtils.clickComponent(temporario, robot);
		Assert.assertFalse("Debería de estar inhabilitado ya que es un empleado temporario",
				Controlador.getInstance().getVista().antiguedadEnabled());
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.borraJTextField(dni, robot);

	}

	@Test
	public void testBotonAceptarErroneo() {
		robot.delay(TestUtils.getDelay());
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JTextField empleadoActual = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldEmpleadoActual");
		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("-1", robot);
		Assert.assertFalse("Debería de estar inhabilitado ya que es un DNI negativo",
				Controlador.getInstance().getVista().aceptarEnabled());
	}

	@Test
	public void testBotonAceptarOk() {
		robot.delay(TestUtils.getDelay());
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JTextField empleadoActual = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldEmpleadoActual");
		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("123", robot);
		Assert.assertTrue("Debería de estar habilitado ya que es un DNI positivo",
				Controlador.getInstance().getVista().aceptarEnabled());
		TestUtils.borraJTextField(consultaDNI, robot);

	}

	@Test
	public void testCampoSalarioErroneo() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton permanente = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnPermanente");
		JTextField sueldo = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldSueldoHora");
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Valentin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("123456", robot);
		TestUtils.clickComponent(permanente, robot);
		Assert.assertFalse("Debería de estar inhabilitado ya que es un empleado permanente",
				Controlador.getInstance().getVista().sueldoEnabled());
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.borraJTextField(dni, robot);
	}

	@Test
	public void testConsultaInexistente() {
		robot.delay(TestUtils.getDelay());
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JButton aceptaConsulta = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAceptar");

		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("123", robot);
		TestUtils.clickComponent(aceptaConsulta, robot);

		Assert.assertEquals("Mensaje incorrecto debería decir " + Mensajes.ERROR_EMPLEADO_INEXISTENTE.getValor(),
				Mensajes.ERROR_EMPLEADO_INEXISTENTE.getValor(), op.getMensaje());

		TestUtils.borraJTextField(consultaDNI, robot);

	}


	@Test
	public void testIngresoEmpleadoTemporarioRepetido() {
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton temporario = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnTemporario");
		JTextField sueldo = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldSueldoHora");
		JButton agregar = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAgregar");
		// lleno los JTextField
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Martin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("4548", robot);
		TestUtils.clickComponent(temporario, robot);
		TestUtils.clickComponent(sueldo, robot);
		TestUtils.tipeaNum("21", robot);
		TestUtils.clickComponent(agregar, robot);
		Assert.assertEquals("Mensaje incorrecto debería decir " + Mensajes.ERROR_EMPLEADO_REPETIDO.getValor(),
				Mensajes.ERROR_EMPLEADO_REPETIDO.getValor(), op.getMensaje());
		TestUtils.borraJTextField(dni, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.borraJTextField(sueldo, robot);
		
	}
	@Test
	public void testIngresoEmpleadoPermanenteRepetido() {
		robot.delay(TestUtils.getDelay());
		JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldNombre");
		JTextField dni = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldDNI");
		JRadioButton permanente = (JRadioButton) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "rdbtnPermanente");
		JTextField antiguedad = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldAntiguedad");
		JButton agregar = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAgregar");

		// lleno los JTextField
		TestUtils.clickComponent(nombre, robot);
		TestUtils.tipeaTexto("Valentin", robot);
		TestUtils.clickComponent(dni, robot);
		TestUtils.tipeaNum("42157718", robot);
		TestUtils.clickComponent(permanente, robot);
		TestUtils.clickComponent(antiguedad, robot);
		TestUtils.tipeaNum("15", robot);
		TestUtils.clickComponent(agregar, robot);
		Assert.assertEquals("Mensaje incorrecto debería decir " + Mensajes.ERROR_EMPLEADO_REPETIDO.getValor(),
				Mensajes.ERROR_EMPLEADO_REPETIDO.getValor(), op.getMensaje());
		TestUtils.borraJTextField(dni, robot);
		TestUtils.borraJTextField(nombre, robot);
		TestUtils.borraJTextField(antiguedad, robot);
		
	}

	@Test
	public void testConsultaOk() {
		robot.delay(TestUtils.getDelay());
		JTextField consultaDNI = (JTextField) TestUtils
				.getComponentForName((Ventana) Controlador.getInstance().getVista(), "textFieldDNIConsulta");
		JButton aceptaConsulta = (JButton) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"btnAceptar");
		JTextField rta = (JTextField) TestUtils.getComponentForName((Ventana) Controlador.getInstance().getVista(),
				"textFieldEmpleadoActual");
		TestUtils.clickComponent(consultaDNI, robot);
		TestUtils.tipeaTexto("42157718", robot);
		TestUtils.clickComponent(aceptaConsulta, robot);
		Assert.assertEquals("Deberia de coincidir el nombre", "Valentin", rta.getText());
		Assert.assertEquals("Debería de haberse borrado el campo consulta DNI", "", consultaDNI.getText());

	}

}
