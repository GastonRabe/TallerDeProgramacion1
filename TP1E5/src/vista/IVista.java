package vista;

import java.awt.event.ActionListener;

public interface IVista 
{
	/**
	 * Metodo que setea los action listener en cada 
	 * @param listener
	 */
	void setActionListener(ActionListener listener);
	/**
	 * Metodo que obtiene lo escrito por un usuario en el text field.
	 * @return Devuelve un int con lo que el usuario ingreso
	 * <b>Pre</b> El dato ingresado debe ser numerico y distinto de null o espacios en blanco
	 * <b>Post:</b> Devolvera el dato en formato numerico tras hacer la conversion.
	 */
	int getTextNumero();
	/**
	 * Metodo que muestra el ultimo estado del jugador
	 * @param traerEstado: String que tiene el ultimo estado
	 */
	void mostrarEstado(String traerEstado);
	/**
	 * Metodo que muestra los intentos del jugador
	 * @param traerIntentos: int que tiene la cantidad de intentos
	 */
	void mostrarIntentos(int traerIntentos);
	/**
	 * Metodo que deshabilita funciones: Boton de probar y text field
	 */
	void deshabilita();
	/**
	 * Metodo que habilita funciones: Boton de probar y text field.
	 */
	void habilita();
}
