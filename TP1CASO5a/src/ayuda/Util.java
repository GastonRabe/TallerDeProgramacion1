package ayuda;

public class Util 
{
	
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
