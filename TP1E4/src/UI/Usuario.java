package UI;

import javax.swing.JOptionPane;

import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;
import modelo.Calcular;
import negocio.Monitor;

public class Usuario {

	private Monitor monitor= new Monitor();
	
	public void calcular(int primerOperando, int segundoOperando, String operacion) throws OperandoInvalidoException, OperacionImposibleException
	{
		assert operacion!=null: "Operacion nula";
		monitor.calcular(primerOperando, segundoOperando, operacion);
	}
	
	public void mostrarEstado(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void mostrarResultado()
	{
		JOptionPane.showMessageDialog(null, monitor.traerResultado());
	}
}
