package prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;

import UI.Usuario;
import excepciones.OperacionImposibleException;
import excepciones.OperandoInvalidoException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panelInservible1;
	private JPanel panel5;
	private JPanel panelInservible2;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JButton botonIgual;
	private JTextField primerOperando;
	private JTextField segundoOperando;
	private JPanel panelResultado;
	private JPanel panelMostrarRes;
	private JLabel labelResultado;
	private Usuario user= new Usuario();
	private JRadioButton sumarRdButton;
	private JRadioButton restarRdButton;
	private JRadioButton multiplicarRdButton;
	private JRadioButton dividirRdButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<Integer> muestraRes;
	private DefaultListModel<Integer> modeloResultado;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		this.panel1 = new JPanel();
		this.panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.contentPane.add(this.panel1);
		this.panel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.primerOperando = new JTextField();
		this.primerOperando.setHorizontalAlignment(SwingConstants.CENTER);
		this.primerOperando.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel1.add(this.primerOperando);
		this.primerOperando.setColumns(10);
		
		this.panel2 = new JPanel();
		this.panel2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel2);
		
		this.sumarRdButton = new JRadioButton("+");
		buttonGroup.add(this.sumarRdButton);
		this.sumarRdButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel2.add(this.sumarRdButton);
		
		this.panel3 = new JPanel();
		this.panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.contentPane.add(this.panel3);
		this.panel3.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.segundoOperando = new JTextField();
		this.segundoOperando.setHorizontalAlignment(SwingConstants.CENTER);
		this.segundoOperando.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel3.add(this.segundoOperando);
		this.segundoOperando.setColumns(10);
		
		this.panel4 = new JPanel();
		this.panel4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel4);
		
		this.restarRdButton = new JRadioButton("-");
		buttonGroup.add(this.restarRdButton);
		this.restarRdButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel4.add(this.restarRdButton);
		
		this.panelInservible1 = new JPanel();
		this.contentPane.add(this.panelInservible1);
		
		this.panel5 = new JPanel();
		this.panel5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel5);
		
		this.multiplicarRdButton = new JRadioButton("*");
		buttonGroup.add(this.multiplicarRdButton);
		this.multiplicarRdButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel5.add(this.multiplicarRdButton);
		
		this.panelInservible2 = new JPanel();
		this.contentPane.add(this.panelInservible2);
		
		this.panel6 = new JPanel();
		this.panel6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel6);
		
		this.dividirRdButton = new JRadioButton("/");
		buttonGroup.add(this.dividirRdButton);
		this.dividirRdButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel6.add(this.dividirRdButton);
		
		this.panel7 = new JPanel();
		this.contentPane.add(this.panel7);
		this.panel7.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelResultado = new JPanel();
		this.panelResultado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panel7.add(this.panelResultado);
		this.panelResultado.setLayout(new BorderLayout(0, 0));
		
		this.labelResultado = new JLabel("        Resultado:");
		this.panelResultado.add(this.labelResultado);
		
		this.panelMostrarRes = new JPanel();
		this.panelMostrarRes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.panel7.add(this.panelMostrarRes);
		this.panelMostrarRes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.muestraRes = new JList<Integer>();
		this.muestraRes.setToolTipText("");
		this.muestraRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.muestraRes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.panelMostrarRes.add(this.muestraRes);
		
		this.panel8 = new JPanel();
		this.panel8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(this.panel8);
		
		this.botonIgual = new JButton("=");
		this.botonIgual.addActionListener(this);
		this.botonIgual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.panel8.add(this.botonIgual);
		this.primerOperando.setPreferredSize(new Dimension(10, 26));
		
		this.lblNewLabel = new JLabel("<- 1er Operando");
		this.panel1.add(this.lblNewLabel);
		this.segundoOperando.setPreferredSize(new Dimension(10, 26));
		
		this.lblNewLabel_1 = new JLabel("<- 2ndo Operando");
		this.panel3.add(this.lblNewLabel_1);
		this.muestraRes.setPreferredSize(new Dimension(60, 26));
		
		this.modeloResultado= new DefaultListModel<Integer>();
		this.muestraRes.setModel(modeloResultado);
	}

	public void actionPerformed(ActionEvent e) {
		
		String operacion=null;
		Integer primerOp, segundoOp;
		
		assert e.getActionCommand().equals("="): "No es posible";
		
		if (this.sumarRdButton.isSelected())
			operacion="+";
		else
			if (this.restarRdButton.isSelected())
				operacion="-";
			else
				if (this.multiplicarRdButton.isSelected())
					operacion="*";
				else
					if (this.dividirRdButton.isSelected())
						operacion="/";
		
		
		//ESTA VALIDACION ESTA HECHA EN LA VENTANA Y NO EN LA CLASE "CALCULAR" PORQUE PARA ESO TENDRIA QUE CAMBIAR LOS PARAMETROS DEL VOID CALCULAR DE INT->STRING 
		//Y NO SERIAN LOS PARAMETROS DE LA CONSIGNA
		
		if (this.primerOperando.getText().isBlank())
			JOptionPane.showMessageDialog(null, "Debe ingresar un primer operando");
		else
			if (!this.primerOperando.getText().matches("[+-]?\\d*(\\.\\d+)?"))
				JOptionPane.showMessageDialog(null, "Primer operando no es un numero");
			else
				if (this.segundoOperando.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Debe ingresar un segundo operando");
				else
					if (!this.segundoOperando.getText().matches("[+-]?\\d*(\\.\\d+)?"))
						JOptionPane.showMessageDialog(null, "Segundo operando no es un numero");
					else
						try
						{
							primerOp=Integer.parseInt(this.primerOperando.getText());
							segundoOp=Integer.parseInt(this.segundoOperando.getText());
							user.calcular(primerOp,segundoOp,operacion);
							this.modeloResultado.clear();
							this.modeloResultado.addElement(user.mostrarResultado());
						}
						catch (OperandoInvalidoException | OperacionImposibleException m)
						{
							user.mostrarEstado(m.getMessage());
						}
	}
}