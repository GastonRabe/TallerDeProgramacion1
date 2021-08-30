package interfaz;

import java.util.ArrayList;

import Excepciones.NoAprobadaException;
import Excepciones.NoExisteAlumnoException;
import Excepciones.NoExisteMateriaException;
import Excepciones.YaExisteException;
import modelo.Alumno;
import modelo.Certificado;
import modelo.Materia;
import negocio.Negocio;

/**
 *clase que representa la interfaz de usuario
 */
public class UI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Certificado certificado = new Certificado();
	 Negocio negocio=new Negocio(certificado);
	 ArrayList<Materia>materias=new ArrayList<Materia>();
	 try {
		Alumno a =new Alumno(1232,"Perez Pablo");
		materias.add(new Materia("Fisica"));
		materias.add(new Materia("Historia"));
		negocio.pedirCertificado(0);
		negocio.traerCondicion();
		negocio.traerEstado("Fisica");
		negocio.traerNota("Fisica");
		certificado.AgregarAlumno(a);
		a.setMaterias(materias);
		negocio.pedirCertificado(1232);
		System.out.println(negocio.traerApellidoyNombre());
	} 
	 catch (NoExisteAlumnoException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	 catch (YaExisteException e1) {
		 System.out.println(e1.getMessage());
		 
	 }
	 catch(NoExisteMateriaException e2) {
		 System.out.println(e2.getMessage());
	 }
	 catch(NoAprobadaException e3) {
		 System.out.println(e3.getMessage());
	 }
	}

}
