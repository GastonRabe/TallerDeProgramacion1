package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.NoAprobadaException;
import Excepciones.NoExisteAlumnoException;
import Excepciones.NoExisteMateriaException;
import Excepciones.YaExisteException;

/**
 * clase que representa un certificado de un alumno<br>
 * <b> inv </b> <br>
 * alumno !=null <br>
 * !alumno.getApellidoNombre().equals("") <br>
 * alumno.getMaterias()!=null <br>
 * alumno.getLegajo<=9999 && alumno.getLegajo>0
 */
public class Certificado {
	private ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
	private Alumno certificadoAct=null;
    

	/**
	 * constructor sin parametros
	 */
	/**
	 * 
	 */
	public Certificado() {
	
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * metodo que agrega alumno a la lista para certificados
	 * <b> post: </b>  Se agrega un nuevo alumno a la lista <br>
	 * @param alumno de clase Alumno, representa los alumnos a agregar 
	 * @throws YaExisteException se lanza cuando se quiere agregar un alumno ya existente
	 */
	public void AgregarAlumno(Alumno alumno) throws YaExisteException{
		if(this.alumnos.contains(alumno))
			throw new YaExisteException("el alumno a agregar ya existe "); 
		else 
			this.alumnos.add(alumno);
		verificarInvariante(alumno);
	}
	
	
	/**<b> inv </b> el legajo del alumno debe ser un numero positivo de 4 cifras <br>
	 * <b> post : </b> se encontro el alumno por legajo y se selecciona para certificado <br>
	 * @param Legajo de tipo integer, representa a cada alumno para distinguirlos
	 * @throws NoExisteAlumnoException se lanza cuando el legajo no coincide con ningun alumno de la lista
	 */
	public void pedirCertificado(int Legajo) throws NoExisteAlumnoException{
		assert (Legajo>0) && (Legajo<=9999): "el legajo a buscar debe ser un numero positivo de 4 cifras";
		if(!this.BuscaAlumno(Legajo))	
			throw new NoExisteAlumnoException("no existe el alumno con ese legajo");
		
	}
	/**
	 * metodo que busca el alumno por legajo en la lista de alumnos <br>
	 * @param legajo de tipo integer identificador de cada alumno
	 * @return de tipo boolean, true en caso de encontrar un alumno con el legajo de parametro<br>
	 * false en caso contrario
	 */
	private boolean BuscaAlumno(int legajo) {
		// TODO Auto-generated method stub
		Iterator<Alumno> it= this.alumnos.iterator();
		Alumno aux=this.alumnos.get(0);
		while(it.hasNext() && aux.getLegajo()!=legajo) {
			aux=it.next();
		}
		if(aux.getLegajo()==legajo) {
			this.certificadoAct=aux;
			return true;
		}
		else	
			return false;
	}
	/**
	 * metodo que devuelve el apellido y nombre del alumno seleccionado actualmente
	 * @return de tipo String, representa el nombre y apellido del alumno
	 */
	public String traerApellidoyNombre() {
		
		return this.certificadoAct.getApellidoNombre();
	}
	/**
	 * metodo que retorna el estado de la materia pasada por parametro del alumno <br>
	 * <b> inv : </b> el alumno para certificado actual debe ser distinto de null y la materia distinta de null<br>
	 * @param Materia de tipo String, nombre de la materia de la cual se busca conocer<br>
	 * su estado (A cursar, Aprobada , Cursada)<br>
	 * @return de tipo String, representa el estado de la materia pasada por parametro del alumno
	 * @throws NoExisteMateriaException se lanza cuando no coincide con ninguna de las 4 materias existentes
	 */
	public String traerEstado(String Materia) throws NoExisteMateriaException{
		assert certificadoAct!=null : "debe seleccionar un alumno";
		assert Materia!=null : "La materia debe ser distinta de null";
		Iterator<Materia> it = this.certificadoAct.getMaterias().iterator();
		Materia aux=it.next();
		while(it.hasNext() && !(aux.getNombre().equals(Materia))) {
			aux=it.next();
		}
		if(aux.getNombre().equals(Materia)) {
			return aux.getEstado();
		}
		else
			throw new NoExisteMateriaException("la materia que se quiso buscar no existe");
	}
	
	/**
	 * metodo que retorna la nota del alumno en la materia pasada por parametro <br>
	 * <b> inv : </b> el alumno para certificado actual != null y la materia !=null
	 * @param Materia de tipo String, representa la materia a buscar la nota del alumno
	 * @return de tipo String, representa la nota del alumno en la materia pasada por parametro
	 * @throws NoAprobadaException se lanza cuando se pide la nota de una materia que su estado no es Aprobada
	 * @throws NoExisteMateriaException se lanza cuando la materia buscada no existe 
	 */
	public String traerNota(String Materia) throws NoAprobadaException , NoExisteMateriaException{
		assert certificadoAct!=null : "debe seleccionar un alumno";
		assert Materia!=null : "La materia debe ser distinta de null";
		Iterator<Materia> it = this.certificadoAct.getMaterias().iterator();
		Materia aux=it.next();
		while(it.hasNext() && !(aux.getNombre().equals(Materia))) {
			aux=it.next();
		}
		if(aux.getNombre().equals(Materia)) {
			if(aux.getEstado().equals("Aprobada"))
			    return aux.getNota();
			else
				throw new NoAprobadaException("la materia debe ser aprobada para tener una nota");
		}
		else
			throw new NoExisteMateriaException("la materia que se quiso buscar no existe");

	}
	
	/**
	 * metodo que retorna la condicion del alumno seleccionado <br>
	 * <b> inv : </b> el alumno con certificado debe ser !=null
	 * @return de tipo String, representa la condicion del alumno (regular o irregular)
	 */
	public String traerCondicion() {
		 assert this.certificadoAct!=null : "debe seleccionar un alumno";
	     return this.certificadoAct.getCondicion();	
	}
	/**
	 * verifica que el invariante se cumpla. Si algo falla se lanza un AssertionError <br>
	 * <b> inv: </b> el alumno debe ser !=null,legajo entero positivo de hasta 4 cifras y la lista de materias !=null <br>
	 * @param alumno
	 */
	private void verificarInvariante(Alumno alumno) {
		assert alumno!=null: "el alumno debe ser distinto de null";
		assert (alumno.getLegajo()>0) && (this.certificadoAct.getLegajo()<=9999) : "el legajo debe ser un numero positivo de 4 cifras";
		assert alumno.getMaterias()!=null : "El arreglo de materias debe ser distinto de null";
	}

}
