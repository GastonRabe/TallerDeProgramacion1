package modelo;

import java.util.Random;

import excepciones.NumeroFueraDeRangoException;
import excepciones.TerminoJuegoException;

public class Juego 
{
	
	/**
	 * Ultimo estado
	 */
	private String ultimoEstado;
	/**
	 *  Cantidad de intentos
	 */
	private int cantIntentos;
	/**
	 *  Numero generado
	 */
	private int generado;
	/**
	 * Constructor del juego. Setea cantidad de intentos y numero generado en 0.
	 */
	public Juego()
	{
		this.cantIntentos=0;
		this.generado=0;
	}
	
	/**
	 *  Metodo que devuelve la cantidad de intentos
	 * @return Devuelve la cantiad de intentos
	 */
	public int getCantIntentos() {
		return cantIntentos;
	}

	/**
	 * Setea cantidad de intentos en valor especificado
	 * @param cantIntentos
	 */
	public void setCantIntentos(int cantIntentos) {
		this.cantIntentos = cantIntentos;
	}

	/**
	 * Metodo que inicia el juego.
	 * <b>Post:</b> La cantidad de intentos debe setearse en 10. El numero generado debe estar en el rango de (0 a 100]
	 */
	public void IniciaJuego()
	{
		this.cantIntentos=10;
		this.ultimoEstado=null;
		this.generado=(int)Math.floor((Math.random()*100+1));
		assert this.generado<100:"Fuera de rango";
		assert this.generado>0:"Fuera de rango";
		assert this.cantIntentos==10:"Intentos erroneos.";
	}

	/**
	 * Metodo que ejecuta el juego, el usuario ingresa un numero y se comprueba si el usuario gano, acertando, perdio, quedandose sin
	 * intentos, o si su numero fue incorrecto pero mas bajo o mas alto del generado.
	 * @param numero numero ingresado por el usuario.
	 * @return devuelve el ultimo estado del jugador.
	 * @throws TerminoJuegoException Lanza excepcion si el juego ha terminado, tanto si ha ganado o si se ha quedado sin intentos.
	 * @throws NumeroFueraDeRangoException Se lanza cuando el usuario ha ingresado un numero fuera del rango permitido
	 * <b>Pre:</b> El numero debe ser > 0
	 * <b>Post:</b> El juego verificara y cambiara el estado del usuario dependiendo su respuesta
	 */
	
	
	public String Prueba(int numero) throws TerminoJuegoException, NumeroFueraDeRangoException
	{
		assert numero>0:"Numero negativo";
			if(numero>=1 && numero<=100)
			{
				if(this.getUltimoEstado()!="Acerto" && this.getUltimoEstado()!="Perdio" && cantIntentos>1)
				{
					if(numero<this.generado)
						this.setUltimoEstado("bajo");
					else if(numero>this.generado)
						this.setUltimoEstado("alto");
					else if(numero==this.generado)
						this.setUltimoEstado("Acerto");
					else if(numero!=this.generado && this.cantIntentos==1)
						this.setUltimoEstado("Perdio");
					this.cantIntentos--;
				}
				else
					throw new TerminoJuegoException("Juego ha finalizado");
			}
			else
				throw new NumeroFueraDeRangoException("Numero fuera de rango");	
			this.invariantes();
			return this.getUltimoEstado();	
			
	}
	
	
	private void invariantes() {
		assert this.getUltimoEstado()!=null:"El juego ha iniciado y el juego no ha sido cambiado";
		assert this.generado<100:"Fuera de rango";
		assert this.generado>0:"Fuera de rango";
		
	}

	
	/**
	 * Metodo que invoca a un metodo para devolver la cantidad de intentos.
	 * @return Devuelve cantidad de intentos
	 */
	public int traerIntentos()
	{
		return this.getCantIntentos();
	}
	
	/**
	 * Metodo que llama al metodo que trae el ultimo estado
	 * @return Devuelve un string con el estado ultimo
	 */
	
	public String traerEstado()
	{
		return this.getUltimoEstado();
	}

	/**
	 * Metodo que trae el ultimo estaod
	 * @return Devuelve el ultimo estado
	 */
	private String getUltimoEstado() 
	{
		return this.ultimoEstado;
	}
	/**
	 * Metodo que setea el ultimo estado
	 * @param estado Contiene el estado a establecer.
	 */
	private void setUltimoEstado(String estado)
	{
		this.ultimoEstado=estado;
	}
	
	

}
