package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Recetas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldIngredientes;
	private JTextField textFieldPrecio;
	private JTextField textField;
	private JTextField textFieldN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recetas frame = new Recetas();
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
	public Recetas() {
		setTitle("Recetas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		setForeground(new Color(153, 153, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 32, 154, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(10, 53, 77, 14);
		contentPane.add(lblIngredientes);
		
		textFieldIngredientes = new JTextField();
		textFieldIngredientes.setBounds(10, 78, 154, 20);
		contentPane.add(textFieldIngredientes);
		textFieldIngredientes.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 109, 46, 14);
		contentPane.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(10, 127, 154, 20);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setBounds(10, 158, 109, 14);
		contentPane.add(lblDificultad);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(10, 208, 77, 23);
		contentPane.add(rdbtnNormal);
		
		JRadioButton rdbtnComplicado = new JRadioButton("Complicado");
		rdbtnComplicado.setBounds(6, 175, 161, 23);
		contentPane.add(rdbtnComplicado);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(117, 331, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(228, 331, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 251, 109, 14);
		contentPane.add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(10, 284, 414, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		lblFoto.setBounds(188, 29, 246, 236);
		contentPane.add(lblFoto);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(320, 11, 29, 14);
		contentPane.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setEditable(false);
		textFieldN.setBounds(359, 8, 47, 20);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
	}
}
