package modelo;

import java.util.HashMap;
import java.util.Iterator;

import excepciones.EmpleadoInexistenteException;
import excepciones.EmpleadoRepetidoException;
import util.Mensajes;

/**
 * @author guille
 *Clase que conserva un conjunto de empleados. Utiliza el patr�n Singleton
 */
public class Empresa
{
	private String nombre;
	private HashMap<Integer, Empleado> empleados = new HashMap<Integer, Empleado>();
	private Empleado ultimoEmpleadoBuscado = null;
	private static Empresa instance = null;

	private Empresa()
	{
	}
	
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public static Empresa getInstance()
	{
		if (Empresa.instance == null)
			Empresa.instance = new Empresa();
		return instance;
	}

	/**
	 * Agrega un nuevo empleado a la empresa. Si el documento del Empleado ya figura en su n�mina, se lanza una excepcion de tipo EmpleadoRepetidoException 
	 * <b>pre:</b> Empleado debe ser distinto de null</br>
	 * @param empleado Objeto de tipo empleado que se agrega a la Empresa
	 * @throws EmpleadoRepetidoException Es lanzada cuando el dni del empleado pasado como par�metro es el mismo que el de un empleado que ya figura en la n�mina
	 */
	public void agregarEmpleado(Empleado empleado) throws EmpleadoRepetidoException
	{
		if (this.empleados.containsKey(empleado.getDni()))
			throw new EmpleadoRepetidoException(Mensajes.ERROR_EMPLEADO_REPETIDO.getValor(), empleado.getDni());
		this.empleados.put(empleado.getDni(), empleado);
	}

	public Iterator<Empleado> getIterator()
	{
		return this.empleados.values().iterator();
	}

	/**
	 * Devuelve el Empleado cuyo DNI conicide con el par�metro DNI.
	 * @param dni DNI del empleado que se desea buscar
	 * @return El objeto empleado cuyo dni coincide con el par�metro dni
	 * @throws EmpleadoInexistenteException Es lanzada cuando el dni pasado como par�metro no coincide con ningun empleado en la n�minan de la empresa
	 */
	public Empleado getEmpleadoForDNI(Integer dni) throws EmpleadoInexistenteException
	{
		Empleado respuesta = this.empleados.get(dni);
		if (respuesta == null)
			throw new EmpleadoInexistenteException(Mensajes.ERROR_EMPLEADO_INEXISTENTE.getValor(), dni);
		this.ultimoEmpleadoBuscado = respuesta;
		return respuesta;
	}

	/**
	 * @return retorna el �ltimo empleado que fue buscado por dni a trav�s del m�todo getEmpleadoForDNI. Si dicho m�todo nunca fue invocado, retorna null
	 */
	public Empleado getUltimoEmpleadoBuscado()
	{
		return ultimoEmpleadoBuscado;
	}

}
