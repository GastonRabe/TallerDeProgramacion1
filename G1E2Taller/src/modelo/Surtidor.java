package modelo;

import java.util.Random;

import excepciones.CargaNegativaException;
import excepciones.CombustibleInsuficienteException;
import excepciones.ExcedeCombustibleException;
import excepciones.InactivoException;

public class Surtidor {
	
	private final double capacidadMaxima = 2000;
	private double combustible;
	private Manguera m1,m2;
	private Random tiempo = new Random();
	private char estado='I';
	
	
   // si excede el combustible tiro una excepcion porque se podría arreglar, no creo que haga falta tirar todo


	/**constructor de la clase surtidor
	 * @param carga es la cantidad de combustible inicial del surtidor
	 * @throws ExcedeCombustibleException se lanza la excepción en caso de que el surtidor supere la capacidad maxima establecida
	 * @throws CargaNegativaException se lanza la excepcion en caso de que la carga sea negativa
	 */
	public void inicializarSurtidor(double carga) throws ExcedeCombustibleException, CargaNegativaException {
		if(carga < 0)
			throw new CargaNegativaException("No se puede ingresar una carga negativa");
		if (carga>this.capacidadMaxima)
		throw new ExcedeCombustibleException("El surtidor excede los 2000 lts de capacidad");
		else {
			this.combustible=carga;
			m1 = new Manguera();
			m2 = new Manguera();
			this.estado = 'A';
		}
			
	}
	
	/**metodo destinado a la carga del surtidor <br>
	 * @param carga > 0, es la cantidad que se le va a cargar al surtidor <br>
	 * @throws ExcedeCombustibleException, no puede exceder la capacidad maxima, caso contrario se lanza la excepcion
	 * @throws CargaNegativaException se lanza la excepcion en caso de que la carga sea negativa
	 * @throws InactivoException 
	 */
	public void cargaSurtidor (double carga)throws ExcedeCombustibleException, CargaNegativaException, InactivoException {
		if(carga+this.combustible>this.capacidadMaxima)
			throw new ExcedeCombustibleException("El surtidor excede los 2000 lts de capacidad");
		else if (carga < 0)
			throw new CargaNegativaException("No se puede ingresar una carga negativa");
		else if(this.estado !='I')
			this.combustible+=carga;
		else
			throw new InactivoException("El surtidor nunca fue inicializado");
			
			
	}
	
	/**
	 * metodo para activar la manguera y poder realizar descargas, de cumplirse la condicion en el aserto, se activa la manguera
	 * caso contrario se corta la ejecución
	 */
	public void activaManguera1() {
		assert this.combustible>=1:"No hay suficiente combustible";
		this.m1.activaManguera();
		
	}
	/**
	 * metodo para activar la manguera y poder realizar descargas, de cumplirse la condicion en el aserto, se activa la manguera
	 * caso contrario se corta la ejecución
	 */
	public void activaManguera2() {
		assert this.combustible>=1:"No hay suficiente combustible";
		this.m2.activaManguera();
		
	}
	
	
	/**
	 * metodo para desactivar la manguera y que el surtidor deje de descargar
	 */
	public void desactivaManguera1() {
		this.m1.desactivaManguera();	
	}
	/**
	 * metodo para desactivar la manguera y que el surtidor deje de descargar
	 */
	public void desactivaManguera2() {
		this.m2.desactivaManguera();	
	}
	
	
	/**metodo en donde se descarga combustible desde la manguera 1, además acumula los litros vendidos, y actualiza la cant de la ultima venta <br>
	 * se utiliza una variable random para determinar los segundos que el trabajador estará apretando el gatillo, y como se descarga un litro por segundo, la cantidad de segundos sera
	 * la cantidad de litros a descargar<br>
	 * @throws CombustibleInsuficienteException : se lanza en el caso de que el surtidor no posea la cantidad de combustible necesaria para realizar la descarga
	 */
	public void descargaManguera1() throws CombustibleInsuficienteException {
		double litros;
		assert this.m1.getActiva()=='S': "No es posible descargar ya que la manguera no está activa";
		litros = tiempo.nextInt(250);
		if(this.combustible-litros<0) {
			this.m1.actualizaDatos(this.combustible);
			this.combustible=0;
			throw new CombustibleInsuficienteException("La descarga no fue totalmente exitosa, se descargó unicamente: "+ this.combustible +" de los "+litros+ "pedidos");
		}
		else {
			this.combustible-=litros;
			this.m1.actualizaDatos(litros);
		}
	}
	
	/**metodo en donde se descarga combustible desde la manguera 2, además acumula los litros vendidos, y actualiza la cant de la ultima venta <br>
	 * se utiliza una variable random para determinar los segundos que el trabajador estará apretando el gatillo, y como se descarga un litro por segundo, la cantidad de segundos sera
	 * la cantidad de litros a descargar<br>
	 * @throws CombustibleInsuficienteException : se lanza en el caso de que el surtidor no posea la cantidad de combustible necesaria para realizar la descarga
	 */
	public void descargaManguera2() throws CombustibleInsuficienteException {
		double litros;
		assert this.m2.getActiva()=='S': "No es posible descargar ya que la manguera no está activa";
		litros = tiempo.nextInt(250);
		if(this.combustible-litros<0) {
			this.m2.actualizaDatos(this.combustible);
			this.combustible=0;
			throw new CombustibleInsuficienteException("La descarga no fue totalmente exitosa, se descargó unicamente: "+ this.combustible +" de los "+litros+ "pedidos");
		}
		else {
			this.combustible-=litros;
			this.m2.actualizaDatos(litros);
		}
	}

	/**metodo para saber si hay un excedente de combustible en el surtidor
	 * @return : retorna la cantidad de combustible en caso de haber, caso contrario salta el "false" del aserto
	 */
	public double getExistenciaDeposito() {
		assert this.combustible>=1: "No hay depósito de combustible";
		return this.combustible; 
		
	}
	/**metodo que retorna el acumulado de litros vendidos por el surtidor
	 * @return : el total de litros vendidos por el surtidor
	 */
	public double getAcumuladoManguera1() {
		return this.m1.getAcumVentas();
		
	}
	/**metodo que retorna el acumulado de litros vendidos por el surtidor
	 * @return : el total de litros vendidos por el surtidor
	 */
	public double getAcumuladoManguera2() {
		return this.m2.getAcumVentas();
		
	}
	/**metodo que retorna la cantidad de litros descargados en la ultima venta
	 * @return : los litros vendidos en la ultima venta
	 */
	public double getUltimaVentaMG1() {
		return this.m1.getUltimaVenta();
	}
	/**metodo que retorna la cantidad de litros descargados en la ultima venta
	 * @return : los litros vendidos en la ultima venta
	 */
	public double getUltimaVentaMG2() {
		return this.m2.getUltimaVenta();
	}




	
	
	

}
