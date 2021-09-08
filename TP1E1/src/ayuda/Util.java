package ayuda;

public class Util 
{
	/**
	 * Metodo que retorna true si la cadena ingresada es numerica, y falso si no lo es.
	 * @param cadena Contiene la cadena ingresada
	 * @return true si la cadena ingresada es numerica, y falso si no lo es.
	 */
	 public static boolean isNumeric(String cadena)
	 {
	        boolean resultado;

	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;
	        }

	        return resultado;
	    }
	
	
	
}
