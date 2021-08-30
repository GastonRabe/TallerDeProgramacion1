package Excepciones;

/**
 * clase que representa la excepcion cuando se busca una nota de una materia que no fue aprobada
 */
public class NoAprobadaException extends Exception {

	public NoAprobadaException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor de clase<br>
	 * @param messagede tipo String, representa la causa por la cual se corta la ejecucion normal
	 */
	public NoAprobadaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
