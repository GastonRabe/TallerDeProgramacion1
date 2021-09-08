package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import excepciones.NumeroFueraDeRangoException;
import excepciones.TerminoJuegoException;
import negocio.Monitor;
import vista.IVista;

public class Controlador implements ActionListener
{
	
	/**
	 * 
	 */
	private Monitor monitor;
	/**
	 * 
	 */
	private IVista vista;
	/**
	 * 
	 */
	public Controlador(Monitor monitor,IVista vista)
	{
		this.vista=vista;
		this.vista.setActionListener(this);
		this.monitor=monitor;
		this.deshabilita();
	}
	/**
	 * 
	 */
	
	public void inicializarJuego()
	{
		this.monitor.IniciarJuego();
	}
	/**
	 * 
	 */
	
	public void probarNumero(int numero)
	{
			try {
				this.monitor.ProbarNumero(numero);
			} catch (TerminoJuegoException e) {
				// TODO Auto-generated catch block
				this.deshabilita(); //seria mejor q lo verifique cada vez q hace un intento.
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (NumeroFueraDeRangoException e2)
			{
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
	}

	/**
	 * 
	 */
	
	public void mostrarEstado()
	{
		this.vista.mostrarEstado(this.monitor.traerEstado());
	}
	
	/**
	 * 
	 */
	public void MostrarIntentos()
	{
		this.vista.mostrarIntentos(this.monitor.traerIntentos());
	}
	
	/**
	 * 
	 */
	public void deshabilita()
	{
		this.vista.deshabilita();
	}
	/**
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando;
		comando=e.getActionCommand();
		if(comando=="NuevoJuego")
		{
			this.habilita();
			this.inicializarJuego();
		}
		else if (comando=="Probar")
		{
			this.probarNumero(this.vista.getTextNumero());	
		}
		this.mostrarEstado();
		this.MostrarIntentos();
		
	}
	/**
	 * 
	 */ 

	private void habilita() 
	{
		this.vista.habilita();
		
	}
}
