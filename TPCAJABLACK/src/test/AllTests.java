package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ TestAlumnosDatos.class, TestProfesoresSinDatos.class, TestProfesoresDatos.class, TestAlumnosSinDatos.class })
public class AllTests {

}
