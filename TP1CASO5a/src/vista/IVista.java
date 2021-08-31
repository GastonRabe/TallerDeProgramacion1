package vista;

import java.awt.event.ActionListener;

public interface IVista 
{
	void setActionListener(ActionListener listener);
	int getTextNumero();
	void mostrarEstado(String traerEstado);
	void mostrarIntentos(int traerIntentos);
	void deshabilita();
	void habilita();
}
