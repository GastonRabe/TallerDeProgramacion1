package test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAlumnosDatos.class, TestAlumnosSinDatos.class, TestProfesores.class, TestProfesoresSinDatos.class })
public class AllTests extends junit.framework.TestSuite{

}
