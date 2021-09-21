package codigo;

public class Codigo {

	public static double horasExtras(double jornadalaboral, double horastrabajadasnormales, double horastrabajadasferiados) {
		double resultado = 0;
		if ((jornadalaboral > 0) & (horastrabajadasnormales > 0) & (horastrabajadasferiados >= 0)) {
			resultado = horastrabajadasferiados + horastrabajadasnormales - jornadalaboral;
			if (resultado < 0) {
				resultado = 0;
			}
		} else {
			resultado = -1;
		}
		return resultado;
	}
}
