package beer;

public class Producto 
{
	
	private String nombre;
	private int cantidad;
	private int numProd;
	
	public Producto(int numProd,int i)
	{
		this.numProd=numProd;
		this.cantidad=i;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean hayStock()
	{
		return this.cantidad>0;
	}
	
	public void consumo()
	{
		this.cantidad--;
	}
	
	public void reponer(int cantidad)
	{
		this.cantidad=cantidad;
	}

	
}
