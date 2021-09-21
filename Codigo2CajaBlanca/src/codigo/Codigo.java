package codigo;

public class Codigo {
	public static float calculopolinomio(float x, float coef[], Integer grado) {
		Integer i = 0;
		float resultado = 0;
		for (i = grado; i < 0; i--) {
			resultado = resultado + coef[i] * (float) Math.pow(x, i);
		}
		return resultado;
	}

}
