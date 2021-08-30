package modelo;

public class Manguera {
	
	private double acumVentas,ultimaVenta;
	private char activa;

	public Manguera() {
		this.acumVentas = 0;
		this.ultimaVenta = 0;
	}
	
	public void activaManguera() {
		this.activa='S';
	}
	public void desactivaManguera() {
		this.activa='N';
	}

	public double getAcumVentas() {
		return acumVentas;
	}

	public double getUltimaVenta() {
		return ultimaVenta;
	}

	public char getActiva() {
		return activa;
	}

	public void actualizaDatos(double lts) {
		this.ultimaVenta=lts;
		this.acumVentas+=lts;
		
	}
}
