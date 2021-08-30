package Excepciones;

/**
 * clase que representa la excepcion por no ser una de las 4 materias del sistema
 */
public class NoExisteMateriaException extends Exception {

	public NoExisteMateriaException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor de clase<br>
	 * @param message de tipo String, representa el mensaje o causa de la interrupcion de la ejecucion normal
	 */
	public NoExisteMateriaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
