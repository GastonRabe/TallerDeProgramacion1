package beer;

public class Mesa 
{
	private char uso;
	private double importeConsumido;
	private BeerHouse bar;
	private int numMesa;
	
	public Mesa(BeerHouse bar,int numMesa)
	{
		this.uso='L';
		this.importeConsumido=0;
		this.bar=bar;
		this.numMesa=numMesa;
	}

	public void ocupaMesa() 
	{
		this.uso='O';
	}


	public double cierraMesa()
	{
		this.uso='L';
		double aux= this.importeConsumido;
		this.importeConsumido=0;
		return aux;
	}
	
	public void consumo(Producto prod)
	{
		this.importeConsumido+= this.bar.getCarta().get(prod);
	}

	public int consultaMesa() 
	{
		if (this.uso=='L')
			return 1;
		else
			return 0;
	}

}
