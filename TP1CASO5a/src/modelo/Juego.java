package modelo;

import java.util.Random;

import excepciones.NumeroFueraDeRangoException;
import excepciones.TerminoJuegoException;

public class Juego 
{
	
	
	private String ultimoEstado;
	private int cantIntentos;
	private int generado;
	
	public Juego()
	{
		this.cantIntentos=0;
		this.generado=0;
	}
	
	
	public int getCantIntentos() {
		return cantIntentos;
	}


	public void setCantIntentos(int cantIntentos) {
		this.cantIntentos = cantIntentos;
	}


	public void IniciaJuego()
	{
		this.cantIntentos=10;
		this.ultimoEstado=null;
		this.generado=(int)Math.floor((Math.random()*100+1));
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
			return this.getUltimoEstado();	
	}
	
	
	public int traerIntentos()
	{
		return this.getCantIntentos();
	}
	
	public String traerEstado()
	{
		return this.getUltimoEstado();
	}


	private String getUltimoEstado() 
	{
		return this.ultimoEstado;
	}
	
	private void setUltimoEstado(String estado)
	{
		this.ultimoEstado=estado;
	}
	
	

}
