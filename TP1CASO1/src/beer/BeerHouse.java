package beer;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BeerHouse 
{
	private HashMap<Integer,Mesa> mesas;
	private int cantMesas;
	private int cantProductos;
	private ArrayList<Producto> productos;
	private HashMap<Producto,Double> carta;
	
	
	public BeerHouse()
	{
		this.mesas=new HashMap<Integer,Mesa>();
		this.productos=new ArrayList<Producto>();
		this.carta=new HashMap<Producto,Double>();
		
		assert this.mesas!=null : "No hay mesas";
		assert this.productos!=null : "No hay prod";
		assert this.carta!=null : "No hay carta";
		
		for(int i=0;i<20;i++)
			this.mesas.put(i,new Mesa(this,i));
		
		for(int i=0;i<20;i++)
			this.productos.add(new Producto(i,10));
		
		
		this.actualizaCarta();
		
	}
	
	
	public void abrirLocal(int cantMesas)
	{		
		assert cantMesas>=1:"La cantidad de mesas no es >= 1";
		this.cantMesas=cantMesas;
		int rta=this.revisaMesas();
		assert cantMesas==rta:"La cantidad de mesas habilitadas difiere de las especificadas";
		this.actualizaCarta();
		int cantDisp=this.analizaProdcutos();
		this.revisaInvariante(cantDisp);
	}
	
	public Mesa ocuparMesa(int nroMesa)
	{
		assert this.revisaInvariante(nroMesa):"Num mesa incorrecto";
		Mesa aux=this.mesas.get(nroMesa);
		aux.ocupaMesa();
		return aux;
	}
	
	public double cerrarMesa(int nroMesa)
	{
		assert this.revisaInvariante(nroMesa):"Num mesa incorrecto";
		Mesa aux=this.mesas.get(nroMesa);
		double importe=aux.cierraMesa();
		return importe;
				
	}

	public HashMap<Integer, Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(HashMap<Integer, Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public int revisaMesas() 
	{
		int rta=0;
		for(int i=0;i<this.mesas.size();i++)
		{
			rta+=this.mesas.get(i).consultaMesa();
		}
		return rta;
	}
	
	public void actualizaCarta()
	{
		for(Producto p:this.productos)		
		{
			if(p.hayStock())
			{
				double numero = (double)(Math.random()*10+1);
				this.carta.put(p,numero);
			}
			else
				this.carta.remove(p);
		}
	}


	public HashMap<Producto,Double> getCarta() {
		return carta;
	}
	
	
	public int analizaProdcutos()
	{
		int rta=0;
		for (int i=0;i<this.productos.size();i++)
		{
			if(this.productos.get(i).hayStock())
				rta+=1;
		}
		return rta;
		
	}
	
	public boolean revisaInvariante(int nroMesa)
	{
		return (nroMesa>0) && (nroMesa<this.cantMesas);
	}
	
	
	
	
}
