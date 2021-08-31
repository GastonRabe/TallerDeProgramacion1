package prueba;
import beer.BeerHouse;
import negocio.Negocio;
import vista.Interfaz;

public class Main {

	public static void main(String[] args) 
	{
		BeerHouse bar=new BeerHouse();
		Negocio negocio=new Negocio(bar);
		Interfaz interfaz=new Interfaz(negocio);
		
		

	}

}
