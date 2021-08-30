package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * clase que representa los alumnos del sistema
 */
public class Alumno {
	private int legajo;
	private String ApellidoNombre;
	private ArrayList<Materia>materias;
	private String Condicion;

	

	public Alumno(int legajo , String ApellidoNombre) {
		this.legajo=legajo;
		this.ApellidoNombre=ApellidoNombre;
		this.materias= new ArrayList<Materia>();
		
		// TODO Auto-generated constructor stub
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}


	public String getApellidoNombre() {
		return ApellidoNombre;
	}


	public void setApellidoNombre(String apellidoNombre) {
		ApellidoNombre = apellidoNombre;
	}


	public ArrayList<Materia> getMaterias() {
		return materias;
	}


	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
		EsRegular();
	}
	/**
	 * metodo privado de la clase que indica la condicion del alumno
	 */
	private void EsRegular() {
		int cont=0;
		Iterator<Materia> it =this.materias.iterator();
		while(it.hasNext()) {
			if(it.next().getEstado().equals("A cursar"))
				cont++;
			if(cont==2)
				setCondicion("Regular");
		}
		setCondicion("Irregular");		
	}
	
	public String getCondicion() {
		return Condicion;
	}


	public void setCondicion(String condicion) {
		Condicion = condicion;
	}

}
