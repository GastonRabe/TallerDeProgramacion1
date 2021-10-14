package test;

import java.awt.Component;

import controlador.IOptionPane;

public class FalsoOptionPane implements IOptionPane{
	   private String mensaje = null;

	    public FalsoOptionPane() {
	        super();
	    }

	    @Override
	    public void ShowMessage(Component parent, String mensaje) {
	        this.mensaje = mensaje;
	    }

	    public String getMensaje() {
	        return mensaje;
	    }
}
