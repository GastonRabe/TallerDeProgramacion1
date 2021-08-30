package Excepciones;

/**
 * clase que representa la excepcion cuando se quiere agregar un alumno que ya existe en la lista
 */
public class YaExisteException extends Exception {

	public YaExisteException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor de clase<br> 
	 * @param message de tipo String, representa la causa de la interrupcion de la ejecucion normal del programa
	 */
	public YaExisteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
