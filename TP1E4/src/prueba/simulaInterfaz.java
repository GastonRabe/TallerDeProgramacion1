package prueba;

import UI.Usuario;
import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;

public class simulaInterfaz {

	public static void main(String[] args)
	{
		Usuario user= new Usuario();
		try
		{
			user.calcular(4, 5, "-");
			user.mostrarResultado();
		}
		catch (OperandoInvalidoException | OperacionImposibleException e)
		{
			user.mostrarEstado(e.getMessage());
		}
	}
}
