package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TabReceta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldIngr;
	private JTextField textFieldPrecio;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldN;
	private JTextField textFieldIng;
	private JTextField textFieldPrec;


	/**
	 * Create the frame.
	 */
	public TabReceta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 468, 318);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Entrantes", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(238, -2, 225, 234);
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\entrantes.gif"));
		panel.add(label);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(10, 58, 74, 14);
		panel.add(lblIngredientes);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 109, 46, 14);
		panel.add(lblPrecio);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setBounds(10, 150, 95, 14);
		panel.add(lblDificultad);
		
		JRadioButton rdbtnFcil = new JRadioButton("F\u00E1cil");
		rdbtnFcil.setBounds(6, 171, 62, 23);
		panel.add(rdbtnFcil);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(82, 171, 74, 23);
		panel.add(rdbtnNormal);
		
		JRadioButton rdbtnDificil = new JRadioButton("Dificil");
		rdbtnDificil.setBounds(172, 171, 109, 23);
		panel.add(rdbtnDificil);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 201, 95, 14);
		panel.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 27, 118, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldIngr = new JTextField();
		textFieldIngr.setBounds(10, 83, 86, 20);
		panel.add(textFieldIngr);
		textFieldIngr.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(10, 129, 86, 20);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 226, 437, 53);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Primeros", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 11, 46, 14);
		panel_1.add(lblNombre_1);
		
		JLabel lblIngredientes_1 = new JLabel("Ingredientes");
		lblIngredientes_1.setBounds(10, 63, 100, 14);
		panel_1.add(lblIngredientes_1);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setBounds(10, 111, 46, 14);
		panel_1.add(lblPrecio_1);
		
		JLabel lblDificultad_1 = new JLabel("Dificultad");
		lblDificultad_1.setBounds(10, 160, 76, 14);
		panel_1.add(lblDificultad_1);
		
		JRadioButton radioButtonf1 = new JRadioButton("F\u00E1cil");
		radioButtonf1.setBounds(10, 181, 62, 23);
		panel_1.add(radioButtonf1);
		
		JRadioButton rdbtnNormal_1 = new JRadioButton("Normal");
		rdbtnNormal_1.setBounds(73, 181, 76, 23);
		panel_1.add(rdbtnNormal_1);
		
		JRadioButton rdbtnDificil2 = new JRadioButton("Dificil");
		rdbtnDificil2.setBounds(153, 181, 62, 23);
		panel_1.add(rdbtnDificil2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 211, 100, 14);
		panel_1.add(lblDescripcin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 236, 443, 52);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(10, 32, 86, 20);
		panel_1.add(textFieldN);
		textFieldN.setColumns(10);
		
		textFieldIng = new JTextField();
		textFieldIng.setBounds(10, 88, 86, 20);
		panel_1.add(textFieldIng);
		textFieldIng.setColumns(10);
		
		textFieldPrec = new JTextField();
		textFieldPrec.setBounds(10, 129, 86, 20);
		panel_1.add(textFieldPrec);
		textFieldPrec.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\primeros.jpg"));
		label_1.setBounds(211, 0, 242, 254);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Postres", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(233, 11, 220, 229);
		label_2.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		panel_2.add(label_2);
	}
}
