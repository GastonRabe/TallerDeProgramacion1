package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ayuda.Util;

public class Interfaz extends JFrame implements IVista
{

	private JPanel contentPane;
	private JLabel lblEstado;
	private JButton btnIniciaJuego;
	private JButton btnProbar;
	private JTextField textFieldNumero;
	private JLabel lblIntentos;

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
		setBounds(100, 100, 682, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblEstado = new JLabel("");
		this.lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		this.lblEstado.setBounds(49, 373, 244, 56);
		this.contentPane.add(this.lblEstado);
		
		this.btnIniciaJuego = new JButton("Nuevo juego");
		this.btnIniciaJuego.setActionCommand("NuevoJuego");
		this.btnIniciaJuego.setBounds(289, 109, 89, 23);
		this.contentPane.add(this.btnIniciaJuego);
		
		this.btnProbar = new JButton("Probar");
		this.btnProbar.setBounds(345, 166, 89, 23);
		this.contentPane.add(this.btnProbar);
		
		this.textFieldNumero = new JTextField();
		this.textFieldNumero.setBounds(228, 167, 96, 20);
		this.contentPane.add(this.textFieldNumero);
		this.textFieldNumero.setColumns(10);
		
		this.lblIntentos = new JLabel("");
		this.lblIntentos.setFont(new Font("Tahoma", Font.PLAIN, 27));
		this.lblIntentos.setBounds(381, 373, 233, 56);
		this.contentPane.add(this.lblIntentos);
	}

	@Override
	public void setActionListener(ActionListener listener) 
	{
		this.btnIniciaJuego.addActionListener(listener);
		this.btnProbar.addActionListener(listener);
	}

	
	
	@Override
	public int getTextNumero() {
		// TODO Auto-generated method stub
		String a=this.textFieldNumero.getText();
		assert Util.isNumeric(a):"Formato incorrecto";
		return Integer.parseInt(this.textFieldNumero.getText());
	}

	@Override
	public void mostrarEstado(String traerEstado) {
		this.lblIntentos.setText("Estado" + traerEstado);
		
	}

	@Override
	public void mostrarIntentos(int traerIntentos) 
	{
		this.lblEstado.setText("Intentos:" + String.valueOf(traerIntentos));
		
	}

	@Override
	public void deshabilita() {
		this.btnProbar.setEnabled(false);
		this.textFieldNumero.setEnabled(false);
		
	}

	@Override
	public void habilita() {
		this.btnProbar.setEnabled(true);
		this.textFieldNumero.setEnabled(true);
		
	}
}
