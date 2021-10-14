package vista;

import java.awt.Component;

import javax.swing.JOptionPane;

import controlador.IOptionPane;

public class SwingOptionPane implements IOptionPane {
   

    @Override
    public void ShowMessage(Component parent, String mensaje) {
        JOptionPane.showMessageDialog(parent, mensaje);
    }

    
}
