package modelo;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;

public class Calcular {

	private int primerOperando, segundoOperando, resultado;
	private String operacion;
	
	public Calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		this.primerOperando=primerOperando;
		this.segundoOperando=segundoOperando;
		this.operacion=operacion;
		validarOperacion();
		realizarOperacion();
	}
	
	public void validarOperacion() throws OperandoInvalidoException
	{
		if (primerOperando<0 || segundoOperando<0)
			throw new OperandoInvalidoException("Hay un operando negativo");
		else if (!(operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/")))
			throw new OperandoInvalidoException("Operacion invalida, operando no pertenece a los posibles");
	}
	
	public void realizarOperacion() throws OperacionImposibleException
	{
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
					
	}
	
	public int traerResultado()
	{
		return this.resultado;
	}
}
