package vista;

import java.awt.event.ActionListener;

public interface IVista 
{
	void setActionListener(ActionListener listener);
	public int getTextAbrir();
	public int getTextOcupar();
	public int getTextCerrar();
	void muestraImporte(double cerrarMesa);

	
}
