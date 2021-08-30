package Excepciones;

/**
 * clase que representa la excepcion cuando se busca un alumno por legajo<br>
 *  y no se lo encuentra en la lista
 */
public class NoExisteAlumnoException extends Exception {

	public NoExisteAlumnoException() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * constructor de clase<br>
	 * @param message de tipo String se pasa al constructor de la clase padre
	 */
	public NoExisteAlumnoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	

}
