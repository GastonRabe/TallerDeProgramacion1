package negocio;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;
import modelo.Calcular;

public class Monitor {

	private Calcular calculo;
	
	public void calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		calculo= new Calcular(primerOperando,segundoOperando, operacion);
	}
	
	public int traerResultado()
	{
		assert calculo!=null: "No existe calculo previo realizado correctamente";
		return calculo.traerResultado();
	}
}
