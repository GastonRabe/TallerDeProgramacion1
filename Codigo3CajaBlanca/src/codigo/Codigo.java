package codigo;

public class Codigo {
	public static boolean es_Ruso(Boolean Vodka, Boolean Slavianka_lo_emociona, Integer VasosdeVodka) {
		boolean resultado = false;
		Integer contador = 0;
		if (Vodka & Slavianka_lo_emociona) { 
			while (contador < VasosdeVodka) {
				contador = contador + 1;
			}
			resultado = contador > 5;
		}
		return resultado;
	}
}
