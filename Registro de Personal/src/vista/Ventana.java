package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import controlador.IVista;
import modelo.Empleado;
import util.Mensajes;

public class Ventana extends JFrame implements ActionListener, IVista, KeyListener
{


	private JPanel contentPane;
	private JPanel panelIngreso;
	private JPanel panelConsulta;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTextField textFieldNombre;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblDni;
	private JPanel panel_3;
	private JTextField textFieldDNI;
	private JPanel panel_4;
	private JLabel lblSueldoXHora;
	private JPanel panel_5;
	private JTextField textFieldSueldoHora;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblAntigedad;
	private JPanel panel_9;
	private JTextField textFieldAntiguedad;
	private JRadioButton rdbtnPermanente;
	private JRadioButton rdbtnTemporario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnAgregar;
	private JPanel panel_14;
	private JPanel panel_12;
	private JLabel lblDni_1;
	private JPanel panel_13;
	private JTextField textFieldDNIConsulta;
	private JPanel panel_15;
	private JButton btnAceptar;
	private JTextArea textArea;
	private JPanel panel_16;
	private JLabel lblNewLabel_1;
	private JTextField textFieldEmpleadoActual;

	/**
	 * Create the frame.
	 */
	public Ventana()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 100, 860, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		this.panelIngreso = new JPanel();
		this.panelIngreso
				.setBorder(new TitledBorder(null, Mensajes.INGRESO.getValor(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		this.contentPane.add(this.panelIngreso);
		this.panelIngreso.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_2 = new JPanel();
		this.panelIngreso.add(this.panel_2);

		this.lblDni = new JLabel(Mensajes.DNI.getValor());
		this.panel_2.add(this.lblDni);

		this.panel_3 = new JPanel();
		this.panelIngreso.add(this.panel_3);

		this.textFieldDNI = new JTextField();

	
		this.textFieldDNI.setColumns(10);
		this.panel_3.add(this.textFieldDNI);

		this.panel = new JPanel();
		this.panelIngreso.add(this.panel);

		this.lblNewLabel = new JLabel(Mensajes.NOMBRE.getValor());
		this.panel.add(this.lblNewLabel);

		this.panel_1 = new JPanel();
		this.panelIngreso.add(this.panel_1);

		this.textFieldNombre = new JTextField();
		this.panel_1.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);

		this.panel_6 = new JPanel();
		this.panelIngreso.add(this.panel_6);

		this.rdbtnPermanente = new JRadioButton(Mensajes.PERMANENTE.getValor());
		this.rdbtnPermanente.addActionListener(this);
		this.buttonGroup.add(this.rdbtnPermanente);
		this.panel_6.add(this.rdbtnPermanente);

		this.panel_7 = new JPanel();
		this.panelIngreso.add(this.panel_7);

		this.rdbtnTemporario = new JRadioButton(Mensajes.TEMPORARIO.getValor());
		this.rdbtnTemporario.addActionListener(this);
		this.buttonGroup.add(this.rdbtnTemporario);

		this.panel_7.add(this.rdbtnTemporario);

		this.panel_8 = new JPanel();
		this.panelIngreso.add(this.panel_8);

		this.lblAntigedad = new JLabel(Mensajes.ANTIGUEDAD.getValor());
		this.panel_8.add(this.lblAntigedad);

		this.panel_9 = new JPanel();
		this.panelIngreso.add(this.panel_9);

		this.textFieldAntiguedad = new JTextField();
		this.textFieldAntiguedad.setColumns(10);
		this.panel_9.add(this.textFieldAntiguedad);

		this.panel_4 = new JPanel();
		this.panelIngreso.add(this.panel_4);

		this.lblSueldoXHora = new JLabel(Mensajes.SUELDO_HORA.getValor());
		this.lblSueldoXHora.setName("lblSueldoXHora");
		this.panel_4.add(this.lblSueldoXHora);

		this.panel_5 = new JPanel();
		this.panelIngreso.add(this.panel_5);

		this.textFieldSueldoHora = new JTextField();
		this.textFieldSueldoHora.setColumns(10);
		this.panel_5.add(this.textFieldSueldoHora);

		this.panel_10 = new JPanel();
		this.panelIngreso.add(this.panel_10);

		this.panel_11 = new JPanel();
		this.panelIngreso.add(this.panel_11);

		this.btnAgregar = new JButton(Mensajes.AGREGAR.getValor());
		this.btnAgregar.addActionListener(this);
		this.panel_11.add(this.btnAgregar);

		this.panelConsulta = new JPanel();
		this.panelConsulta
				.setBorder(new TitledBorder(null, Mensajes.CONSULTAS.getValor(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.contentPane.add(this.panelConsulta);
		this.panelConsulta.setLayout(new GridLayout(0, 1, 0, 0));

		this.panel_14 = new JPanel();
		this.panelConsulta.add(this.panel_14);
		this.panel_14.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_12 = new JPanel();
		this.panel_14.add(this.panel_12);

		this.lblDni_1 = new JLabel(Mensajes.DNI_CONSULTA.getValor());
		this.panel_12.add(this.lblDni_1);

		this.panel_13 = new JPanel();
		this.panel_14.add(this.panel_13);

		this.textFieldDNIConsulta = new JTextField();
		this.textFieldDNIConsulta.setColumns(10);
		this.panel_13.add(this.textFieldDNIConsulta);

		this.panel_15 = new JPanel();
		this.panelConsulta.add(this.panel_15);

		this.btnAceptar = new JButton(Mensajes.ACEPTAR.getValor());
		this.btnAceptar.addActionListener(this);
		this.panel_15.add(this.btnAceptar);

		this.panel_16 = new JPanel();
		this.panelConsulta.add(this.panel_16);

		this.lblNewLabel_1 = new JLabel(Mensajes.EMPLEADO_ACTUAL.getValor());
		this.panel_16.add(this.lblNewLabel_1);

		this.textFieldEmpleadoActual = new JTextField();
		this.textFieldEmpleadoActual.setEditable(false);
		this.panel_16.add(this.textFieldEmpleadoActual);
		this.textFieldEmpleadoActual.setColumns(30);

		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		
		this.panelConsulta.add(this.textArea);
		this.btnAceptar.addActionListener(Controlador.getInstance());
		this.btnAgregar.addActionListener(Controlador.getInstance());
		this.textFieldDNI.addKeyListener(this);
		this.textFieldNombre.addKeyListener(this);
		this.textFieldAntiguedad.addKeyListener(this);
		this.textFieldSueldoHora.addKeyListener(this);
		this.textFieldDNIConsulta.addKeyListener(this);
		Controlador.getInstance().setVista(this);
		
		
		this.seteaNombres();
		this.setVisible(true);
		this.enabledDisabledButtons();
		this.enabledDisabledRadios();
	}
	
	private void seteaNombres() 
	{
		this.panelConsulta.setName("panelConsulta");
		this.panelIngreso.setName("panelIngreso");
		
		this.textFieldDNI.setName("textFieldDNI");
		this.textFieldNombre.setName("textFieldNombre");
		this.rdbtnPermanente.setName("rdbtnPermanente");
		this.rdbtnTemporario.setName("rdbtnTemporario");
		this.textFieldAntiguedad.setName("textFieldAntiguedad");
		this.textFieldSueldoHora.setName("textFieldSueldoHora");
		this.btnAgregar.setName("btnAgregar");
		this.textFieldDNIConsulta.setName("textFieldDNIConsulta");
		this.textFieldEmpleadoActual.setName("textFieldEmpleadoActual");
		this.btnAceptar.setName("btnAceptar");
		this.textArea.setName("textArea");
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.rdbtnTemporario || e.getSource() == this.rdbtnPermanente)
		{
			this.enabledDisabledRadios();
		}

		if (e.getSource() == this.btnAceptar || e.getSource() == this.btnAgregar)
		{
		this.borraText();
		}
		
	}

	
	@Override
	public int getDNI()
	{
		return Integer.parseInt(this.textFieldDNI.getText());
	}

	@Override
	public String getNombre()
	{

		return this.textFieldNombre.getText();
	}

	@Override
	public int getAntiguedad()
	{
		return Integer.parseInt(this.textFieldAntiguedad.getText());
	}

	@Override
	public double getSueldoHora()
	{
		return Double.parseDouble(this.textFieldSueldoHora.getText());
	}
	

	@Override
	public String getTipoEmpleado()
	{
		String respuesta = null;
		if (this.rdbtnPermanente.isSelected())
			respuesta = "PERMANENTE";
		if (this.rdbtnTemporario.isSelected())
			respuesta = "TEMPORARIO";

		return respuesta;
	}

	@Override
	public int getDNIConsulta()
	{
		return Integer.parseInt(this.textFieldDNIConsulta.getText());
	}

	@Override
	public void actualizaEmpleadoActual(Empleado empleado)
	{
		this.textFieldEmpleadoActual.setText(empleado.getNombre());
		this.textArea.setText(empleado.toString());
	}

	private void enabledDisabledRadios()
	{
		this.textFieldSueldoHora.setText("");
		this.textFieldAntiguedad.setText("");
		this.textFieldAntiguedad.setEnabled(this.rdbtnPermanente.isSelected());
		this.textFieldSueldoHora.setEnabled(this.rdbtnTemporario.isSelected());
	}

	public void keyPressed(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
		this.enabledDisabledButtons();
	}

	public void keyTyped(KeyEvent e)
	{
	}

	
	private void enabledDisabledButtons() 
	{
		int dni = -1;
		int dniConsulta = -1;

		int antiguedad = -1;
		double sueldo = -1;
		try
		{
			antiguedad = Integer.parseInt(this.textFieldAntiguedad.getText());

		} catch (NumberFormatException f)
		{
		}

		try
		{
			dni = Integer.parseInt(this.textFieldDNI.getText());

		} catch (NumberFormatException f)
		{
		}

		try
		{
			sueldo = Double.parseDouble(this.textFieldSueldoHora.getText());
		} catch (NumberFormatException f)
		{
		}

		try
		{
			dniConsulta = Integer.parseInt(this.textFieldDNIConsulta.getText());

		} catch (NumberFormatException f)
		{
		}

		boolean condicion = this.textFieldNombre.getText().length() > 0 && dni > 0
				&& ((this.rdbtnPermanente.isSelected() && antiguedad > -1)
						|| (this.rdbtnTemporario.isSelected() && sueldo > -1));
		this.btnAgregar.setEnabled(condicion);
		this.btnAceptar.setEnabled(dniConsulta > -1);
		
	}
private void borraText() 
{
this.textFieldAntiguedad.setText("");
this.textFieldNombre.setText("");
this.textFieldDNI.setText("");
this.textFieldSueldoHora.setText("");
this.textFieldDNIConsulta.setText("");
this.enabledDisabledButtons();

}

@Override
public boolean aceptarEnabled() {
	return this.btnAceptar.isEnabled();
}

@Override
public boolean agregarEnabled() {
	return this.btnAgregar.isEnabled();
}

@Override
public boolean antiguedadEnabled() {
	return this.textFieldAntiguedad.isEnabled();
}

@Override
public boolean sueldoEnabled() {
	// TODO Auto-generated method stub
	return this.textFieldSueldoHora.isEnabled();
}


}
