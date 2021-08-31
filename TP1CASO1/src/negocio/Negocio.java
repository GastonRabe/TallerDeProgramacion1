package negocio;

import beer.BeerHouse;
import beer.Mesa;

public class Negocio 
{
	
	private BeerHouse bar;
	private double ingresos=0;
	
	public Negocio(BeerHouse bar)
	{
		this.bar=bar;
	}
	
	public void abrirLocal(int cantMesas)
	{
		bar.abrirLocal(cantMesas);
		this.ingresos=0;
	}
	
	public Mesa ocuparMesa(int nroMesa)
	{
		return bar.ocuparMesa(nroMesa);
	}
	
	public void cerrarMesa(int nroMesa)
	{
		this.ingresos+= bar.cerrarMesa(nroMesa);
	}

}
