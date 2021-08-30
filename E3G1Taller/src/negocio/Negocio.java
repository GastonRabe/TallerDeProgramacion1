package negocio;

import Excepciones.NoAprobadaException;
import Excepciones.NoExisteAlumnoException;
import Excepciones.NoExisteMateriaException;
import modelo.Certificado;

/**
 * clase que representa el controlador del sistema<br>
 */
public class Negocio {
	Certificado Certificado;

	/**
	 * constructor de clase<br>
	 * @param certificado de tipo certificado, representa el modelo del sistema
	 */
	public Negocio(Certificado certificado) {
		// TODO Auto-generated constructor stub
		this.Certificado=certificado;
	}
	/**
	 * metodo que invoca al metodo del modelo con mismo nombre<br>
	 * @param Legajo de tipo entero, representa el legajo a buscar
	 * @throws NoExisteAlumnoException se propaga de la clase certificado
	 */
	public void pedirCertificado(int Legajo) throws NoExisteAlumnoException {
		this.Certificado.pedirCertificado(Legajo);
		
	}
	/**
	 * metodo que retorna el nombre y apellido del alumno seleccionado<br>
	 * @return de tipo String , se propaga el resultado del modelo
	 */
	public String traerApellidoyNombre() {
		return this.Certificado.traerApellidoyNombre();
	}
	/**
	 * metodo que propaga el resultado del modelo de traer el estado de una materia para un determinado alumno <br>
	 * @param Materia de tipo String, la materia que se buscara en el modelo
	 * @return de tipo String el resultado del modelo
	 * @throws NoExisteMateriaException se propaga del modelo
	 */
	public String traerEstado(String Materia) throws NoExisteMateriaException {
		return this.Certificado.traerEstado(Materia);
	}
	/**
	 * metodo que invoca al metodo de mismo nombre del modelo<br>
	 * @param Materia de tipo String, la materia que se busca en el modelo
	 * @return de tipo String, propaga el resultado de la nota del alumno en una asignatura
	 * @throws NoAprobadaException se propaga desde modelo
	 * @throws NoExisteMateriaException se propaga desde modelo
	 */
	public String traerNota(String Materia) throws NoAprobadaException, NoExisteMateriaException{
		return this.Certificado.traerNota(Materia);
	}
	/**
	 * metodo que propaga la condicion del alumno seleccionado
	 * @return de tipo String , representa la condicion del alumno que se propaga
	 */
	public String traerCondicion() {
		return this.Certificado.traerCondicion();
	}
}
