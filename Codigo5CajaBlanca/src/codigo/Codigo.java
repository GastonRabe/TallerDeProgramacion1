package codigo;

public class Codigo {
	public static void canal1(float Canal[][] ) {
		/*private*/ boolean filassuman1 = true;
		/*private*/ boolean hayunsolodistintodeceroporfila = true;
		/*private*/ float suma = 0;
		/*private static*/ Integer contadordenoceros = 0;
		//SACO LOS MODIFICADORES PARA VER QUE HACE EL TEST
		for (int i = 1; i <= 3; i++) {
			suma = 0;
			for (int j = 1; j <= 3; j++) {
				suma = suma + Canal[i][j];
			}
			filassuman1 = filassuman1 & (suma == 1);
		}
		if (filassuman1) {
			for (int i = 1; i <= 3; i++) {
				contadordenoceros = 0;
				for (int j = 1; j <= 3; j++) {
					if (Canal[i][j] != 0) {
						contadordenoceros++;
					}
				}
				hayunsolodistintodeceroporfila = hayunsolodistintodeceroporfila & (contadordenoceros == 1);
			}
			if (hayunsolodistintodeceroporfila) {
				System.out.println("Canal Determinante");
			} else {
				System.out.println("Canal no Determinante");
			}
		}
	}
}
