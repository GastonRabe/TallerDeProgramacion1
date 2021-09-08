package modelo;

import java.util.HashMap;

import excepciones.CantMesaIncorrectoException;

public class BeerHouse 
{
	/**
	 * 
	 */
	private HashMap<Integer,Producto> carta;
	/**
	 * 
	 */
	private HashMap<Integer,Mesa> mesas;
	/**
	 * 
	 */
	private int cantMesasTotales, cantMesasDisponibles;
	/**
	 * 
	 */
	private HashMap<Integer,Producto> productos;
	
	
	/**
	 *  Constructor de BeerHouse, crea los HashMaps e invoca a metodos para cargar productos y armar la carta
	 * @param cantMesasTotales La cantiadad de mesas totales
	 */
	public BeerHouse(int cantMesasTotales)
	{
		this.carta=new HashMap<Integer,Producto>();
		this.mesas=new HashMap<Integer,Mesa>();
		this.productos=new HashMap<Integer,Producto>();
		this.cantMesasTotales=cantMesasTotales;
		this.cargaProductos();
		
		this.actualizaCarta();
		
		for(int i=0;i<this.cantMesasTotales;i++)
		{
			this.mesas.put(i,new Mesa());
		}
	}
	
	
	/**
	 * Metodo que carga los productos y los agrega al HashMap
	 */
	private void cargaProductos() 
	{
		for(int i=0;i<10;i++)
		{
			this.agregaProducto(i,new Producto(i));
		}
	}
	/**
	 * Pone los productos creados en el HashMap
	 * @param i Codigo del producto
	 * @param prod Objeto producto a agregar
	 */
	
	public void agregaProducto(int i,Producto prod)
	{
		this.productos.put(i, prod);
	}
	
	/**
	 * Remueve el producto especificado.
	 * @param prod Producto a remover
	 */
	
	public void eliminaProducto(Producto prod)
	{
		this.productos.remove(prod);
	}
	
	/**
	 * Metodo que abre el local.
	 * <b>Pre:</b> cantMesas debe ser positivo y menor a las mesas totales
	 * <b>Post:</b> La carta debera quedar actualizada, las mesas revisadas y se actualizara la cant de mesas disponibles
	 * @param cantMesas cantidad de mesas disponibles en el dia
	 * @throws CantMesaIncorrectoException Carta o numero de mesa con valores erroneos.
	 */
	
	
	public void abrirLocal(int cantMesas) throws CantMesaIncorrectoException
	{
		assert cantMesas>=1:"Num mesa erroneos";
		assert cantMesas<=this.cantMesasTotales:"Num mesa erroneos.";
		if(cantMesas>=1 && this.carta.size()>=1)
		{
			this.cantMesasDisponibles=cantMesas;
			this.revisaMesas();
			this.actualizaCarta();
		}
		else
			throw new CantMesaIncorrectoException("Num mesa o carta incorrecto");
		this.revisaInvariantes();
	}
	
	/**
	 * 
	 */
	
	private void revisaInvariantes()
	{
		assert this.cantMesasDisponibles>=1:"Num mesa erroneos";
		assert this.carta.size()>=1:"Productos erroneos";
	}
	
	
	/**
	 *  Metodo que actualiza la carta.
	 */
	private void actualizaCarta() 
	{
		for(int i=0;i<this.productos.size();i++)
		{
			if(!(this.carta.containsValue(this.productos.get(i))))
			{
				this.productos.get(i).setStock(10);
				this.carta.put(i,this.productos.get(i));
			}	
		}
		assert this.carta.size()==this.productos.size():"";
		
	}

	
	/**
	 * 
	 * @throws CantMesaIncorrectoException
	 */
	private void revisaMesas() throws CantMesaIncorrectoException
	{
		int contador=0;
		for(int i=0;i<this.mesas.size();i++)
		{
			if(this.mesas.get(i).estaLibre())
				contador++;
		}
		if (contador<=this.cantMesasDisponibles)
		{
			throw new CantMesaIncorrectoException("Num mesa invalido");
		}
	}

	
	/**
	 * 
	 * @param nroMesa
	 * @return
	 */
	public Mesa ocuparMesa(int nroMesa)
	{
		assert nroMesa>0:"Numero de mesa erroneo";
		Mesa mesa;
		mesa=this.mesas.get(nroMesa);
		mesa.ocuparMesa();
		this.ordenar(nroMesa);
		assert !mesa.estaLibre():"Mesa no cambio estado";
		return mesa;
	}
	
	/**
	 * 
	 * @param nroMesa
	 */
	private void ordenar(int nroMesa)
	{
		int pedido = (int)Math.floor((Math.random()*10));
		this.mesas.get(nroMesa).ordenar(this.carta.get(pedido));
		if(this.carta.get(pedido).getStock()<1)
			this.carta.remove(pedido);
	}
	
	
	/**
	 * 
	 * @param nroMesa
	 * @return
	 */
	public double cerrarMesa(int nroMesa)
	{
		Mesa mesa;
		assert nroMesa>1:"Nro mesa invalido";
		mesa=this.mesas.get(nroMesa);
		assert !mesa.estaLibre():"Mesa libre, no se deberia cerrar";
		return mesa.cerrarMesa();
	}
	/**
	 * 
	 * @return
	 */
	public HashMap<Integer, Producto> getCarta() {
		return carta;
	}
	
	/**
	 * 
	 * @param carta
	 */
	public void setCarta(HashMap<Integer, Producto> carta) {
		this.carta = carta;
	}

	/**
	 * 
	 * @return
	 */
	public HashMap<Integer, Mesa> getMesas() {
		return mesas;
	}

	/**
	 * 
	 * @param mesas
	 */
	public void setMesas(HashMap<Integer, Mesa> mesas) {
		this.mesas = mesas;
	}
	/**
	 * 
	 * @return
	 */
	public int getCantMesasTotales() {
		return cantMesasTotales;
	}
	/**
	 * 
	 * @param cantMesasTotales
	 */
	public void setCantMesasTotales(int cantMesasTotales) {
		this.cantMesasTotales = cantMesasTotales;
	}
	/**
	 * 
	 * @return
	 */
	public int getCantMesasDisponibles() {
		return cantMesasDisponibles;
	}
	/**
	 * 
	 * @param cantMesasDisponibles
	 */
	public void setCantMesasDisponibles(int cantMesasDisponibles) {
		this.cantMesasDisponibles = cantMesasDisponibles;
	}
	
	

}
