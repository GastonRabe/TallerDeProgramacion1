package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import excepciones.EmpleadoInexistenteException;
import excepciones.EmpleadoRepetidoException;
import modelo.Empleado;
import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporario;
import modelo.Empresa;
import util.Mensajes;
import vista.SwingOptionPane;
import vista.Ventana;

public class Controlador implements ActionListener
{
	Empresa empresa = Empresa.getInstance();
	IVista vista = null;
	IOptionPane iOptionPane = new SwingOptionPane();
	private static Controlador instance = null;

	private Controlador()
	{
	}
	  public void setOptionpane(IOptionPane optionpane)
	    {
		this.iOptionPane = optionpane;
	    }

	public static Controlador getInstance()
	{
		if (instance == null) {
			instance = new Controlador();
			instance.vista = new Ventana();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(Mensajes.ACEPTAR.getValor()))
			this.consulta();
		else if (comando.equalsIgnoreCase(Mensajes.AGREGAR.getValor()))
			this.agregar();
	}

	private void agregar()
	{
		Empleado empleado = null;

		String tipo = this.vista.getTipoEmpleado();

		if (tipo.equalsIgnoreCase("PERMANENTE"))
		{
			empleado = new EmpleadoPermanente(this.vista.getDNI(), this.vista.getNombre(), this.vista.getAntiguedad());
		} else if (tipo.equalsIgnoreCase("TEMPORARIO"))
		{
			empleado = new EmpleadoTemporario(this.vista.getDNI(), this.vista.getNombre(), this.vista.getSueldoHora());
		}
		try
		{
			Empresa.getInstance().agregarEmpleado(empleado);
		} catch (EmpleadoRepetidoException e)
		{
			this.iOptionPane.ShowMessage(null, e.getMessage());
		}
		this.listado();
	}

	private void consulta()
	{
		int dni = this.vista.getDNIConsulta();
		Empleado empleado;
		try
		{
			empleado = Empresa.getInstance().getEmpleadoForDNI(dni);
			this.vista.actualizaEmpleadoActual(empleado);
		} catch (EmpleadoInexistenteException e1)
		{
			this.iOptionPane.ShowMessage(null, e1.getMessage());
		}

	}
	public Empleado getEmpleadoForDNI(Integer dni) {
		Empleado aux=null;
		try {
			aux = Empresa.getInstance().getEmpleadoForDNI(dni);
		} catch (EmpleadoInexistenteException e) {
			
		}
		return aux;
	}
	public Iterator<Empleado> getIterator()
	{
		return Empresa.getInstance().getIterator();
	}
	
	public Empleado getUltimoEmpleadoBuscado()
	{
		return Empresa.getInstance().getUltimoEmpleadoBuscado();
	}

	public IVista getVista()
	{
		return vista;
	}

	public void setVista(IVista vista)
	{
		this.vista = vista;
	}

	private void listado()
	{
		Iterator it = Empresa.getInstance().getIterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
