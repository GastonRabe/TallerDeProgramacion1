package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ayuda.Util;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Interfaz extends JFrame implements IVista
{

	private JPanel contentPane;
	private JButton btnAbrilLocal;
	private JTextField textFieldCantMesas;
	private JTextField textFieldOcupar;
	private JTextField textFieldCerrar;
	private JButton btnOcuparMesa;
	private JButton btnCerrarMesa;
	private JLabel lblImporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 664);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.btnAbrilLocal = new JButton("Abril Local");
		this.btnAbrilLocal.setActionCommand("ABRIR");
		this.btnAbrilLocal.setBounds(98, 74, 89, 23);
		this.contentPane.add(this.btnAbrilLocal);
		
		this.textFieldCantMesas = new JTextField();
		this.textFieldCantMesas.setBounds(211, 75, 96, 20);
		this.contentPane.add(this.textFieldCantMesas);
		this.textFieldCantMesas.setColumns(10);
		
		this.textFieldOcupar = new JTextField();
		this.textFieldOcupar.setBounds(211, 164, 96, 20);
		this.contentPane.add(this.textFieldOcupar);
		this.textFieldOcupar.setColumns(10);
		
		this.textFieldCerrar = new JTextField();
		this.textFieldCerrar.setBounds(211, 238, 96, 20);
		this.contentPane.add(this.textFieldCerrar);
		this.textFieldCerrar.setColumns(10);
		
		this.btnOcuparMesa = new JButton("Ocupar");
		this.btnOcuparMesa.setActionCommand("OCUPAR");
		this.btnOcuparMesa.setBounds(98, 163, 89, 23);
		this.contentPane.add(this.btnOcuparMesa);
		
		this.btnCerrarMesa = new JButton("Cerrar");
		this.btnCerrarMesa.setActionCommand("CERRAR");
		this.btnCerrarMesa.setBounds(98, 237, 89, 23);
		this.contentPane.add(this.btnCerrarMesa);
		
		this.lblImporte = new JLabel("New label");
		this.lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.lblImporte.setBounds(102, 364, 158, 58);
		this.contentPane.add(this.lblImporte);
	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.btnAbrilLocal.addActionListener(listener);
		this.btnCerrarMesa.addActionListener(listener);
		this.btnOcuparMesa.addActionListener(listener);
		
	}
	
	public int getTextAbrir()
	{
		String a=this.textFieldCantMesas.getText();
		assert a!=null:"Fromato incorrecto";
		assert Util.isNumeric(a):"Formato incorrecto";
		return Integer.parseInt(a);
	}
	
	public int getTextOcupar()
	{
		String a=this.textFieldOcupar.getText();
		assert a!=null:"Fromato incorrecto";
		assert Util.isNumeric(a):"Formato incorrecto";
		return Integer.parseInt(a);
	}
	
	public int getTextCerrar()
	{
		String a=this.textFieldCerrar.getText();
		assert a!=null:"Fromato incorrecto";
		assert Util.isNumeric(a):"Formato incorrecto";
		return Integer.parseInt(a);
	}

	@Override
	public void muestraImporte(double cerrarMesa) 
	{
		this.lblImporte.setText("IMPORTE:" + String.valueOf(cerrarMesa));
		
	}
}
