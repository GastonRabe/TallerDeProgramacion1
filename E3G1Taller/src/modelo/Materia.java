package modelo;

/**
 * clase que representa cada materia del sistema
 */
public class Materia {
	private String nombre;
	private String Estado;
	private String nota;

	/**
	 * constructor de clase <br>
	 * <b> inv </b> el nombre de la materia debe ser Fisica, Matematica, Literatura o Historia<br>
	 * @param nombre de tipo String, representa el nombre de la materia
	 */
	public Materia(String nombre) {
		assert (nombre.equals("Historia") || nombre.equals("Matematica") || nombre.equals("Literatura") || nombre.equals("Fisica")) : "el nombre de la materia debe ser alguna de las 4 que existen";
		this.nombre=nombre;// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getNota() {
		return nota;
	}

	/**
	 * metodo que agrega la nota de la materia<br>
	 * <b> post : </b> se agrega la nota de la materia aprobada
	 * @param nota de tipo String , representa la nota de la materia
	 */
	public void setNota(String nota) {
		this.nota = nota;
		VerificaInvariante();
	}
	/**
	 * verifica que el invariante se cumpla. Si no se lanza una AssertionError <br>
	 * <b> inv </b> la materia puede tener nota si su estado es aprobada y la nota es de 0 a 10<br>
	 */
	private void VerificaInvariante() {
		assert this.Estado.equals("Aprobada") : "La materia no ha sido aprobada";
		assert Integer.parseInt(nota)>=0 && Integer.parseInt(nota)<=10 : "la nota debe ser de 0 a 10";
	}

}
