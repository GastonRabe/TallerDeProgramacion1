package modelo;

public class Producto 
{
	private double precio;
	private int stock;
	
	
	public Producto(int i)
	{
		this.stock=10;
		this.precio=10*i;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public void consumir() {
		this.stock--;
		
	}
	
	
	

}
