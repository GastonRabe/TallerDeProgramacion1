package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import excepciones.CantMesaIncorrectoException;
import negocio.Negocio;
import vista.IVista;

public class Controlador implements ActionListener
{
	private Negocio negocio;
	private IVista vista;
	
	
	public Controlador(Negocio negocio,IVista vista)
	{
		this.vista=vista;
		this.vista.setActionListener(this);
		this.negocio=negocio;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if(comando=="ABRIR")
		{
			try {
				this.negocio.abrirLocal(this.vista.getTextAbrir());
			} catch (CantMesaIncorrectoException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		else if(comando=="OCUPAR")
		{
			this.negocio.ocuparMesa(this.vista.getTextOcupar());
		}
		else if(comando=="CERRAR")
		{
			this.vista.muestraImporte(this.negocio.cerrarMesa(this.vista.getTextCerrar()));
		}
		
	}

}
