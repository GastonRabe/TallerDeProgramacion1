package negocio;

import excepciones.CantMesaIncorrectoException;
import modelo.BeerHouse;
import modelo.Mesa;

public class Negocio 
{
	
	private BeerHouse bar;

	public Negocio(BeerHouse bar)
	{
		this.bar=bar;
	}
	
	public void abrirLocal(int cantMesas) throws CantMesaIncorrectoException
	{
		this.bar.abrirLocal(cantMesas);
	}
	
	public Mesa ocuparMesa(int nroMesa)
	{
		return this.bar.ocuparMesa(nroMesa);
	}
	
	public double cerrarMesa(int nroMesa)
	{
		return this.bar.cerrarMesa(nroMesa);
	}
	
	
}
