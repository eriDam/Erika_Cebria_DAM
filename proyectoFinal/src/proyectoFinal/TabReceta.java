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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;

public class TabReceta extends JFrame {
	//Atributos
	private JPanel contentPane;
	private JTextField textFieldNomEnt;
	private JTextField textFieldIngrEnt;
	private JTextField textFieldPreEnt;
	private JTextField textFieldDesEnt;
	private JTextField textFieldDescPr;
	private JTextField textFieldNomPr;
	private JTextField textFieldIngPr;
	private JTextField textFieldPrecPr;
	private JTextField textFieldDesPos;
	private JTextField textFieldNomPos;
	private JTextField textFieldIngPos;
	private JTextField textFieldPrecioPos;


	/**
	 * Create the frame.
	 */
	public TabReceta() {
		setForeground(Color.WHITE);
		setTitle("Introducir recetas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 468, 333);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Entrantes", null, panel, null);
		panel.setLayout(null);
		
		JLabel labelEnt = new JLabel("");
		labelEnt.setBounds(238, -2, 225, 234);
		labelEnt.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\entrantes.gif"));
		panel.add(labelEnt);
		
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
		lblDificultad.setBounds(10, 160, 95, 14);
		panel.add(lblDificultad);
		
		JRadioButton rdbtnFcil = new JRadioButton("F\u00E1cil");
		rdbtnFcil.setBounds(6, 171, 68, 23);
		panel.add(rdbtnFcil);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(82, 171, 74, 23);
		panel.add(rdbtnNormal);
		
		JRadioButton rdbtnDificil = new JRadioButton("Dificil");
		rdbtnDificil.setBounds(172, 171, 109, 23);
		panel.add(rdbtnDificil);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 201, 95, 14);
		panel.add(lblDescripcion);
		
		textFieldNomEnt = new JTextField();
		textFieldNomEnt.setBounds(10, 27, 193, 20);
		panel.add(textFieldNomEnt);
		textFieldNomEnt.setColumns(10);
		
		textFieldIngrEnt = new JTextField();
		textFieldIngrEnt.setBounds(10, 83, 193, 20);
		panel.add(textFieldIngrEnt);
		textFieldIngrEnt.setColumns(10);
		
		textFieldPreEnt = new JTextField();
		textFieldPreEnt.setBounds(10, 129, 86, 20);
		panel.add(textFieldPreEnt);
		textFieldPreEnt.setColumns(10);
		
		textFieldDesEnt = new JTextField();
		textFieldDesEnt.setBounds(10, 226, 193, 53);
		panel.add(textFieldDesEnt);
		textFieldDesEnt.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(325, 256, 89, 23);
		panel.add(btnGuardar);
		
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
		
		textFieldDescPr = new JTextField();
		textFieldDescPr.setBounds(10, 236, 205, 43);
		panel_1.add(textFieldDescPr);
		textFieldDescPr.setColumns(10);
		
		textFieldNomPr = new JTextField();
		textFieldNomPr.setBounds(10, 32, 201, 20);
		panel_1.add(textFieldNomPr);
		textFieldNomPr.setColumns(10);
		
		textFieldIngPr = new JTextField();
		textFieldIngPr.setBounds(10, 88, 201, 20);
		panel_1.add(textFieldIngPr);
		textFieldIngPr.setColumns(10);
		
		textFieldPrecPr = new JTextField();
		textFieldPrecPr.setBounds(10, 129, 86, 20);
		panel_1.add(textFieldPrecPr);
		textFieldPrecPr.setColumns(10);
		
		JLabel label_Pr = new JLabel("");
		label_Pr.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\primeros.jpg"));
		label_Pr.setBounds(221, 0, 242, 225);
		panel_1.add(label_Pr);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.setBounds(318, 246, 89, 23);
		panel_1.add(btnGuardar_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Postres", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_Pos2 = new JLabel("");
		label_Pos2.setBounds(233, 11, 220, 229);
		label_Pos2.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		panel_2.add(label_Pos2);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setBounds(10, 11, 46, 14);
		panel_2.add(lblNombre_2);
		
		JLabel lblIngredientes_2 = new JLabel("Ingredientes");
		lblIngredientes_2.setBounds(10, 58, 77, 14);
		panel_2.add(lblIngredientes_2);
		
		JLabel lblPrecio_2 = new JLabel("Precio");
		lblPrecio_2.setBounds(10, 116, 46, 14);
		panel_2.add(lblPrecio_2);
		
		JLabel lblDificultad_2 = new JLabel("Dificultad");
		lblDificultad_2.setBounds(10, 175, 46, 14);
		panel_2.add(lblDificultad_2);
		
		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setBounds(10, 226, 96, 14);
		panel_2.add(lblDescripcin_1);
		
		JRadioButton rdbtnFcil_1 = new JRadioButton("F\u00E1cil");
		rdbtnFcil_1.setBounds(10, 196, 58, 23);
		panel_2.add(rdbtnFcil_1);
		
		JRadioButton rdbtnMedia = new JRadioButton("Media");
		rdbtnMedia.setBounds(81, 196, 67, 23);
		panel_2.add(rdbtnMedia);
		
		JRadioButton rdbtnDificil_1 = new JRadioButton("Dificil");
		rdbtnDificil_1.setBounds(150, 196, 77, 23);
		panel_2.add(rdbtnDificil_1);
		
		textFieldDesPos = new JTextField();
		textFieldDesPos.setBounds(10, 251, 194, 43);
		panel_2.add(textFieldDesPos);
		textFieldDesPos.setColumns(10);
		
		textFieldNomPos = new JTextField();
		textFieldNomPos.setBounds(10, 27, 194, 20);
		panel_2.add(textFieldNomPos);
		textFieldNomPos.setColumns(10);
		
		textFieldIngPos = new JTextField();
		textFieldIngPos.setBounds(10, 83, 194, 20);
		panel_2.add(textFieldIngPos);
		textFieldIngPos.setColumns(10);
		
		textFieldPrecioPos = new JTextField();
		textFieldPrecioPos.setBounds(10, 141, 86, 20);
		panel_2.add(textFieldPrecioPos);
		textFieldPrecioPos.setColumns(10);
		
		JButton btnGuardar_2 = new JButton("Guardar");
		btnGuardar_2.setBounds(307, 261, 89, 23);
		panel_2.add(btnGuardar_2);
	}
}
