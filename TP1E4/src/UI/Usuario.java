package UI;

import javax.swing.JOptionPane;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;
import modelo.Calcular;
import negocio.Monitor;

public class Usuario {

	private Monitor monitor= new Monitor();
	
	/**
	 * PRE: Ningun operando no debe ser nulo, y debe ser un entero positivo. La operacion debe estar seleccionada, no puede ser null
	 * POST: Se delega la tarea de calcular al monitor
	 * @param primerOperando : Es el primer operando de la cuenta a realizar
	 * @param segundoOperando : Es el segundo operando de la cuenta a realizar
	 * @param operacion : Operacion a a realizar
	 * @throws OperandoInvalidoException : Se propaga si el operaando no pertenece a los cuatro posibles
	 * @throws OperacionImposibleException : Se propaga si la operacion que se desea realizar tiene algun operando o el resultado da negativo, tambien division por cero
	 */
	public void calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		monitor.calcular(primerOperando, segundoOperando, operacion);
	}
	
	/**
	 * @param mensaje : Muestra el mensaje de estado de error
	 */
	public void mostrarEstado(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	 * 
	 * @return Retorna el resultado de la ultima cuenta
	 */
	public int mostrarResultado()
	{
		return monitor.traerResultado();
	}
}
