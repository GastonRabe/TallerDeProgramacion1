package modelo;

public class Mesa 
{
	
	private char uso;
	private double consumido;
	
	
	public Mesa()
	{
		this.uso='L';
		this.consumido=0;
	}
	
	public boolean estaLibre()
	{
		return this.uso=='L';
	}
	
	public void ocuparMesa()
	{
		this.uso='O';
	}
	
	public void liberarMesa()
	{
		this.uso='L';
		this.consumido=0;
	}

	public double cerrarMesa()
	{
		double consumido = this.consumido;
		this.liberarMesa();
		return consumido;
	}


	public void ordenar(Producto prod) 
	{
		
		this.consumido+=prod.getPrecio();
		prod.consumir();
		
	}
	
	
}
