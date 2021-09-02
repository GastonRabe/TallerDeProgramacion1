package modelo;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;

public class Calcular {

	private int primerOperando, segundoOperando, resultado;
	private String operacion;
	
	/** 
	 * @param primerOperando
	 * @param segundoOperando
	 * @param operacion
	 * @throws OperandoInvalidoException
	 * @throws OperacionImposibleException
	 */
	public Calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		this.primerOperando=primerOperando;
		this.segundoOperando=segundoOperando;
		this.operacion=operacion;
		validarOperacion();
		realizarOperacion();
	}
	
	/**
	 * Realiza la validacion de que tanto la operacion sea valida como los operandos sean no negativos
	 * @throws OperandoInvalidoException
	 */
	public void validarOperacion() throws OperandoInvalidoException
	{
		if (primerOperando<0 || segundoOperando<0)
			throw new OperandoInvalidoException("Hay un operando negativo");
		else if (operacion==null || !(operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/")))
			throw new OperandoInvalidoException("Operacion invalida, debe seleccionar una operacion");
	}
	
	/**
	 * PRE: Los operandos deben ser enteros no negativos, la operacion suma resta mult. o div. y no puede ser null
	 * POST: Si las operaciones pueden realizarse se modifica el
	 * @throws OperacionImposibleException
	 */
	public void realizarOperacion() throws OperacionImposibleException
	{
		invariante();
		if (operacion.equals("+"))
			resultado=primerOperando+segundoOperando;
		else
			if (operacion.equals("*"))
				resultado=primerOperando*segundoOperando;
			else
				if (operacion.equals("-"))
				{
					if (segundoOperando>primerOperando)
						throw new OperacionImposibleException("No se puede restar, da negativo");
					else
						resultado=primerOperando-segundoOperando;
				}
				else
				{
					assert operacion.equals("/"): "La operacion a realizar no esta disponible";
					if (segundoOperando==0)
						throw new OperacionImposibleException("Error de division por cero");
				}
		invariante();
	}
	
	/**
	 * @return Retorna el ultimo resultado correcto de la calcualdora
	 */
	public int traerResultado()
	{
		return this.resultado;
	}
	
	public void invariante()
	{
		assert operacion!=null: "OPERACION NULA, DEBE SELECCIONAR UN OPERADOR PARA REALIZAR EL CALCULO";
		assert (operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/")): "Operacion no disponible, se modifico";
		assert !(primerOperando<0) || !(segundoOperando<0) : "Error en los operandos, se cambio alguno a negativo";
	}
}
