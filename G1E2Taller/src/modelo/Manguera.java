package modelo;

/**
 * @author usuario
 * Clase manguera de la cual el surtidor va a realizar sus operaciones
 */
public class Manguera {
	
	private double acumVentas,ultimaVenta;
	private char activa;

	/**
	 * constructor de la clase manguera en donde inicializo los litros acumulados vendidos y su ultima venta
	 */
	public Manguera() {
		this.acumVentas = 0;
		this.ultimaVenta = 0;
	}
	
	/**
	 * metodo para activar la manguera
	 */
	public void activaManguera() {
		this.activa='S';
	}
	/**
	 * metodo para desactivar la manguera
	 */
	public void desactivaManguera() {
		this.activa='N';
	}

	/**
	 * @return : retorna los litros acumulados vendidos en total
	 */
	public double getAcumVentas() {
		return acumVentas;
	}

	/**
	 * @return : retorna los litros vendidos en la ultima venta
	 */
	public double getUltimaVenta() {
		return ultimaVenta;
	}

	/**
	 * @return : retorna un caracter que indica si la manguera esta o no activa
	 */
	public char getActiva() {
		return activa;
	}

	/**metodo que actualiza los datos de la manguera, tanto los litros vendidos como la ultima venta
	 * @param lts : litros que se descarga el surtidor por la manguera
	 */
	public void actualizaDatos(double lts) {
		this.ultimaVenta=lts;
		this.acumVentas+=lts;
		
	}
}
