package interfaz;

import excepciones.CargaNegativaException;
import excepciones.CombustibleInsuficienteException;
import excepciones.ExcedeCombustibleException;
import excepciones.InactivoException;
import negocio.Negocio;

public class UI {

	public static void main(String[] args) {

		Negocio YPF = new Negocio();
		String cadena;

		try {
			YPF.inicializaSurtidor(-205);
		} catch (ExcedeCombustibleException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		 catch(CargaNegativaException ecn) {
			 System.out.println(ecn.getMessage());
		 }
		try{
			cadena = YPF.cargaSurtidor(700);
			System.out.println(cadena);
		}
		catch(ExcedeCombustibleException e) {
			System.out.println(e.getMessage());
		}
		 catch(CargaNegativaException ecn) {
			 System.out.println(ecn.getMessage());
		}
		catch(InactivoException ei) {
			System.out.println(ei.getMessage());
		}
		
		cadena = YPF.activaManguera1();
		System.out.println(cadena);
		
		
		try{
			cadena = YPF.descargaManguera1();
			System.out.println(cadena);
		}
		catch(CombustibleInsuficienteException ec) {
			System.out.println(ec.getMessage());
		}
		try{
			cadena = YPF.descargaManguera1();
			System.out.println(cadena);
		}
		catch(CombustibleInsuficienteException ec) {
			System.out.println(ec.getMessage());
		}
		cadena = YPF.activaManguera2();
		System.out.println(cadena);
		try {
			cadena=YPF.descargaManguera2();
			System.out.println(cadena);
		}
		catch(CombustibleInsuficienteException ec) {
			System.out.println(ec.getMessage());
		}
	
		
		System.out.println(YPF.getAcumuladoManguera1());
		System.out.println(YPF.getUltimaVentaMG1());
		System.out.println(YPF.getAcumuladoManguera2());
		System.out.println(YPF.getUltimaVentaMG2());
	

		}

}
