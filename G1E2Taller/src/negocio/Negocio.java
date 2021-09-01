package negocio;

import excepciones.CargaNegativaException;
import excepciones.CombustibleInsuficienteException;
import excepciones.ExcedeCombustibleException;
import excepciones.InactivoException;
import modelo.Surtidor;

public class Negocio {
	
	private Surtidor s = new Surtidor();
	
	/**metodo que invoca el metodo del surtidor desde la clase negocio para inicializar el surtidor
	 *  * </b> pre </b> : carga > 0<br>
	 * @param carga : cantidad de combustible con el que se inicializara el surtidor
	 * @return : retorna un string indicando que la operacion fue exitosa
	 * @throws ExcedeCombustibleException : propaga la excepcion que puede ser lanzada desde el constructor del surtidor
	 * @throws CargaNegativaException se lanza la excepcion en caso de que la carga sea negativa
	 */
	public String inicializaSurtidor(double carga) throws ExcedeCombustibleException, CargaNegativaException{
		this.s.inicializarSurtidor(carga);
		return "Operación Exitosa"; 
		
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio para cargar el surtidor <br>
	 * </b> pre </b> : carga > 0<br>
	 * @param carga : cantidad de combustible que se cargara en el surtidor
	 * @return : retorna un string indicando la carga fue exitosa
	 * @throws ExcedeCombustibleException : propaga la excepcion que puede ser lanzada desde el metodo
	 * @@throws CargaNegativaException se lanza la excepcion en caso de que la carga sea negativa
	 */
	public String cargaSurtidor(double carga) throws ExcedeCombustibleException, CargaNegativaException,InactivoException {
		this.s.cargaSurtidor(carga);
		return "Carga Exitosa";
		
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio para activar la manguera 1
	 * @return : retorna un string indicando que la operacion fue exitosa
	 */
	public String activaManguera1() {
		this.s.activaManguera1();
		return "Manguera 1 Activada";
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio para activar la manguera 2
	 * @return : retorna un string indicando que la operacion fue exitosa
	 */
	public String activaManguera2() {
		this.s.activaManguera2();
		return "Manguera 2 Activada";
	}

	/**
	 * metodo que invoca el metodo del surtidor para la manguera 1 desde la clase negocio para desactivar la manguera
	 */
	public void desactivaManguera1() {
		this.s.desactivaManguera1();
	}
	/**
	 * metodo que invoca el metodo del surtidor para la manguera 2 desde la clase negocio para desactivar la manguera
	 */
	public void desactivaManguera2() {
		this.s.desactivaManguera2();
	}


	/**metodo que invoca el metodo del surtidor para la manguera 1 desde la clase negocio
	 * @return : un string indicando que la descarga fue exitosa
	 * @throws CombustibleInsuficienteException : propaga la excepcion proveniente del metodo de la clase surtidor, en caso de que se haya lanzado
	 */
	public String descargaManguera1() throws CombustibleInsuficienteException {
		this.s.descargaManguera1();
		return "Descarga Manguera 1 Exitosa | "+ this.s.getExistenciaDeposito()+ " de lts actuales en el depósito";
	}
	/**metodo que invoca el metodo del surtidor para la manguera 2 desde la clase negocio
	 * @return : un string indicando que la descarga fue exitosa
	 * @throws CombustibleInsuficienteException : propaga la excepcion proveniente del metodo de la clase surtidor, en caso de que se haya lanzado
	 */
	public String descargaManguera2() throws CombustibleInsuficienteException {
		this.s.descargaManguera2();
		return "Descarga Manguera 2 Exitosa | "+ this.s.getExistenciaDeposito()+ " de lts actuales en el depósito";
	}
	
	/**metodo que invoca el metodo del surtidor desde la clase negocio
	 * @return : retorna la cantidad de combustible en caso de haber
	 */
	public String getExistenciaDeposito() {
		return this.s.getExistenciaDeposito()+ " de lts actuales en depósito";
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio
	 * @return : el total de litros vendidos por la manguera 1
	 */
	public String getAcumuladoManguera1() {
		return this.s.getAcumuladoManguera1()+ " litros vendidos de la manguera 1";
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio
	 * @return : el total de litros vendidos por la manguera 2
	 */
	public String getAcumuladoManguera2() {
		return this.s.getAcumuladoManguera2()+ " litros vendidos de la manguera 2";
	}

	/**metodo que invoca el metodo del surtidor desde la clase negocio
	 * @return : los litros vendidos en la ultima venta de la manguera 1
	 */
	public String getUltimaVentaMG1() {
		return this.s.getUltimaVentaMG1()+ " cantidad de litros de la ultima venta de la manguera 1";
	}
	/**metodo que invoca el metodo del surtidor desde la clase negocio
	 * @return : los litros vendidos en la ultima venta de la manguera 1
	 */
	public String getUltimaVentaMG2() {
		return this.s.getUltimaVentaMG2()+ " cantidad de litros de la ultima venta de la manguera 2";
	}
	
	

}
