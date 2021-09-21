package codigo;

public class Codigo {
	public static void sumoyresto(Integer A, Integer B) {
		float suma = 0;
		Integer i = 0;
		while (suma > 0) {
			suma = suma + A;
			if (suma % 2 == 0) {
				suma = suma - 1;
			} else {
				while (i < B) {
					suma = suma - B;
					i = i + 1;
				}
			}
		}
	}
}
