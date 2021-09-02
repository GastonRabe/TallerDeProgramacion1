package negocio;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;
import modelo.Calcular;

public class Monitor {

	private Calcular calculo;
	
	/**
	 * Delega tarea a calculo
	 * @param primerOperando: primer operando de la cuenta
	 * @param segundoOperando: segundo operando de la cuenta
	 * @param operacion: operacion a realizar
	 * @throws OperandoInvalidoException: Se propaga si el operaando no pertenece a los cuatro posibles
	 * @throws OperacionImposibleException: Se propaga si la operacion que se desea realizar tiene algun operando o el resultado da negativo, tambien division por cero
	 */
	public void calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		calculo= new Calcular(primerOperando,segundoOperando, operacion);
	}
	
	/**PRE: tiene que haber un calculo hecho anteriormente
	 * @return: valor del ultimo calculo correcto de la calculadora
	 */
	public int traerResultado()
	{
		assert calculo!=null: "No existe calculo previo realizado correctamente";
		return calculo.traerResultado();
	}
}
