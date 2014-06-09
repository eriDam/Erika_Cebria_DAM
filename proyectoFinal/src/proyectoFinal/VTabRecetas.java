package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class VTabRecetas extends JFrame {
	//Atributos
	private JPanel contentPane;
	private JTextField textFieldNomEn;
	private JTextField textFieldIngrEn;
	private JTextField textFieldPreEn;
	private JTextField textFieldDesEn;
	private JTextField textFieldDescPr;
	private JTextField textFieldNomPr;
	private JTextField textFieldIngPr;
	private JTextField textFieldPrecPr;
	private JTextField textFieldDesPos;
	private JTextField textFieldNomPos;
	private JTextField textFieldIngPos;
	private JTextField textFieldPrecioPos;
	private JTextField txtEntrantes;
	private JTextField txtPrimerosPr;
	private JTextField txtPostres;
	private JTextField textFieldIdreceta;
	private JComboBox<Receta> comboBoxR;
	private JTextField textFieldDifEn;
	//Creo el grupo de botones
	private ButtonGroup grupoDeBotones;
	private JRadioButton opF;
	private JRadioButton opN;
	private JRadioButton opD;
	//Creamos objeto para llamar al método
		ConexionDB f;
		private JPanel panelPr;
	
	/**
	 * Create the frame.
	 */
	public VTabRecetas() {
		setForeground(Color.WHITE);
		setTitle("Introducir recetas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Dispose la cierra
		setBounds(100, 100, 494, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 24, 478, 333);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Entrantes", null, panel, null);
		panel.setLayout(null);
		
		JLabel labelEn = new JLabel("");
		labelEn.setBounds(238, -2, 225, 234);
		labelEn.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\entrantes.gif"));
		panel.add(labelEn);
		
		JLabel lblNombreE = new JLabel("Nombre");
		lblNombreE.setBounds(10, 31, 46, 14);
		panel.add(lblNombreE);
		
		JLabel lblIngredientesEn = new JLabel("Ingredientes");
		lblIngredientesEn.setBounds(10, 77, 74, 14);
		panel.add(lblIngredientesEn);
		
		JLabel lblPrecioEn = new JLabel("Precio");
		lblPrecioEn.setBounds(10, 121, 46, 14);
		panel.add(lblPrecioEn);
		
		JLabel lblDificultadEn = new JLabel("Dificultad");
		lblDificultadEn.setBounds(156, 146, 95, 14);
		panel.add(lblDificultadEn);
		
		//****************Creo el grupo de Botones************************
		
		/*grupoDeBotones = new ButtonGroup();
		opF = new JRadioButton("OpF");
		opF.setSelected(true);
		opF.setBounds(6, 103, 109, 23);
		contentPane.add(opF);
		
		opN = new JRadioButton("OpN");
		opN.setBounds(6, 140, 109, 23);
		contentPane.add(opN);
		
		opD = new JRadioButton("OpD");
		opD.setBounds(6, 180, 109, 23);
		contentPane.add(opD);*/
		
		//Añadimos los botones a un grupo de botones
				/*grupoDeBotones.add(opF);
				grupoDeBotones.add(opN);
				grupoDeBotones.add(opD);*/
				
				
		JRadioButton rdbtnFcil = new JRadioButton("F\u00E1cil");
		rdbtnFcil.setBounds(10, 209, 68, 23);
		panel.add(rdbtnFcil);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(80, 209, 74, 23);
		panel.add(rdbtnNormal);
		
		JRadioButton rdbtnDificil = new JRadioButton("Dificil");
		rdbtnDificil.setBounds(156, 209, 109, 23);
		panel.add(rdbtnDificil);
		
		JLabel lblDescripcionEn = new JLabel("Descripci\u00F3n");
		lblDescripcionEn.setBounds(34, 260, 95, 14);
		panel.add(lblDescripcionEn);
		
		textFieldNomEn = new JTextField();
		textFieldNomEn.setBounds(10, 46, 193, 20);
		panel.add(textFieldNomEn);
		textFieldNomEn.setColumns(10);
		
		textFieldIngrEn = new JTextField();
		textFieldIngrEn.setBounds(10, 90, 193, 20);
		panel.add(textFieldIngrEn);
		textFieldIngrEn.setColumns(10);
		
		textFieldPreEn = new JTextField();
		textFieldPreEn.setBounds(10, 146, 86, 20);
		panel.add(textFieldPreEn);
		textFieldPreEn.setColumns(10);
		
		textFieldDesEn = new JTextField();
		textFieldDesEn.setBounds(122, 241, 193, 53);
		panel.add(textFieldDesEn);
		textFieldDesEn.setColumns(10);



		
		JButton btnGuardarEn = new JButton("Guardar");
		btnGuardarEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int idReceta= Integer.valueOf(Integer.parseInt(textFieldIdreceta.getText()));
				String nombre=textFieldNomEn.getText();
				String ingredientes=textFieldIngrEn.getText();
				float precio= Float.valueOf(Float.parseFloat(textFieldPreEn.getText()));
				// String dificultad =rdbtnFcil.getText();//Como es radio button no se como cogerlo
				String dificultad =textFieldDifEn.getText();
				String descripcion= textFieldDesEn.getText();
				String categoria=txtEntrantes.getText();
				
				 //Llamamos al metodo insertar Receta
                f.insertarReceta(idReceta, nombre, ingredientes, precio, dificultad, descripcion, categoria, comboBoxR);
               
			}
		});
		btnGuardarEn.setBounds(325, 256, 89, 23);
		panel.add(btnGuardarEn);
		
		JLabel lblCategoriaEn = new JLabel("Categor\u00EDa");
		lblCategoriaEn.setBounds(10, 6, 74, 14);
		panel.add(lblCategoriaEn);
		
		txtEntrantes = new JTextField();
		txtEntrantes.setEnabled(false);
		txtEntrantes.setEditable(false);
		txtEntrantes.setText("Entrantes");
		txtEntrantes.setBounds(66, 3, 86, 20);
		panel.add(txtEntrantes);
		txtEntrantes.setColumns(10);
		
		JLabel lblIdrecetaEn = new JLabel("IdReceta");
		lblIdrecetaEn.setBounds(162, 6, 46, 14);
		panel.add(lblIdrecetaEn);
		
		textFieldIdreceta = new JTextField();
		textFieldIdreceta.setBounds(219, 3, 32, 20);
		panel.add(textFieldIdreceta);
		textFieldIdreceta.setColumns(10);
		
		textFieldDifEn = new JTextField();
		textFieldDifEn.setBounds(208, 143, 86, 20);
		panel.add(textFieldDifEn);
		textFieldDifEn.setColumns(10);
		
		JRadioButtonMenuItem rdbtnmntmDificultad = new JRadioButtonMenuItem("Dificultad");
		rdbtnmntmDificultad.setBounds(10, 180, 125, 22);
		panel.add(rdbtnmntmDificultad);
		
		
		// tab primeros
		
		panelPr = new JPanel();
		tabbedPane.addTab("Primeros", null, panelPr, null);
		panelPr.setLayout(null);
		
		JLabel lblNombrePr = new JLabel("Nombre");
		lblNombrePr.setBounds(10, 37, 46, 14);
		panelPr.add(lblNombrePr);
		
		JLabel lblIngredientesPr = new JLabel("Ingredientes");
		lblIngredientesPr.setBounds(10, 83, 100, 14);
		panelPr.add(lblIngredientesPr);
		
		JLabel lblPrecioPr = new JLabel("Precio");
		lblPrecioPr.setBounds(10, 128, 46, 14);
		panelPr.add(lblPrecioPr);
		
		JLabel lblDificultadPr = new JLabel("Dificultad");
		lblDificultadPr.setBounds(10, 175, 76, 14);
		panelPr.add(lblDificultadPr);
		
		JRadioButton radioButtonf1 = new JRadioButton("F\u00E1cil");
		radioButtonf1.setBounds(10, 196, 62, 23);
		panelPr.add(radioButtonf1);
		
		JRadioButton rdbtnNormal_1 = new JRadioButton("Normal");
		rdbtnNormal_1.setBounds(75, 196, 76, 23);
		panelPr.add(rdbtnNormal_1);
		
		JRadioButton rdbtnDificil2 = new JRadioButton("Dificil");
		rdbtnDificil2.setBounds(153, 196, 62, 23);
		panelPr.add(rdbtnDificil2);
		
		JLabel lblDescripciPr = new JLabel("Descripci\u00F3n");
		lblDescripciPr.setBounds(10, 226, 100, 14);
		panelPr.add(lblDescripciPr);
		
		textFieldDescPr = new JTextField();
		textFieldDescPr.setBounds(10, 251, 205, 43);
		panelPr.add(textFieldDescPr);
		textFieldDescPr.setColumns(10);
		
		textFieldNomPr = new JTextField();
		textFieldNomPr.setBounds(10, 52, 201, 20);
		panelPr.add(textFieldNomPr);
		textFieldNomPr.setColumns(10);
		
		textFieldIngPr = new JTextField();
		textFieldIngPr.setBounds(10, 108, 201, 20);
		panelPr.add(textFieldIngPr);
		textFieldIngPr.setColumns(10);
		
		textFieldPrecPr = new JTextField();
		textFieldPrecPr.setBounds(10, 144, 86, 20);
		panelPr.add(textFieldPrecPr);
		textFieldPrecPr.setColumns(10);
		
		JLabel label_Pr = new JLabel("");
		label_Pr.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\primeros.jpg"));
		label_Pr.setBounds(221, 11, 242, 239);
		panelPr.add(label_Pr);
		
		JButton btnGuardarPr = new JButton("Guardar");
		btnGuardarPr.setBounds(309, 261, 89, 23);
		panelPr.add(btnGuardarPr);
		
		JLabel lblCategoriaPr = new JLabel("Categor\u00EDa");
		lblCategoriaPr.setBounds(10, 14, 76, 14);
		panelPr.add(lblCategoriaPr);
		
		txtPrimerosPr = new JTextField();
		txtPrimerosPr.setEnabled(false);
		txtPrimerosPr.setEditable(false);
		txtPrimerosPr.setText("Primeros");
		txtPrimerosPr.setBounds(75, 11, 86, 20);
		panelPr.add(txtPrimerosPr);
		txtPrimerosPr.setColumns(10);
		
		//************ TAB POSTRES ****************************
		JPanel panel_Pos = new JPanel();
		tabbedPane.addTab("Postres", null, panel_Pos, null);
		panel_Pos.setLayout(null);
		
		JLabel label_Pos2 = new JLabel("");
		label_Pos2.setBounds(243, 31, 220, 229);
		label_Pos2.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		panel_Pos.add(label_Pos2);
		
		JLabel lblNombrePos = new JLabel("Nombre");
		lblNombrePos.setBounds(10, 38, 46, 14);
		panel_Pos.add(lblNombrePos);
		
		JLabel lblIngredientesPos = new JLabel("Ingredientes");
		lblIngredientesPos.setBounds(10, 84, 77, 14);
		panel_Pos.add(lblIngredientesPos);
		
		JLabel lblPrecioPos = new JLabel("Precio");
		lblPrecioPos.setBounds(10, 127, 46, 14);
		panel_Pos.add(lblPrecioPos);
		
		JLabel lblDificultadPos = new JLabel("Dificultad");
		lblDificultadPos.setBounds(10, 175, 46, 14);
		panel_Pos.add(lblDificultadPos);
		
		JLabel lblDescripcinPos = new JLabel("Descripci\u00F3n");
		lblDescripcinPos.setBounds(10, 226, 96, 14);
		panel_Pos.add(lblDescripcinPos);
		
		JRadioButton rdbtnFcil_1 = new JRadioButton("F\u00E1cil");
		rdbtnFcil_1.setBounds(10, 196, 58, 23);
		panel_Pos.add(rdbtnFcil_1);
		
		JRadioButton rdbtnMedia = new JRadioButton("Media");
		rdbtnMedia.setBounds(81, 196, 67, 23);
		panel_Pos.add(rdbtnMedia);
		
		JRadioButton rdbtnDificil_1 = new JRadioButton("Dificil");
		rdbtnDificil_1.setBounds(150, 196, 77, 23);
		panel_Pos.add(rdbtnDificil_1);
		
		textFieldDesPos = new JTextField();
		textFieldDesPos.setBounds(10, 251, 194, 43);
		panel_Pos.add(textFieldDesPos);
		textFieldDesPos.setColumns(10);
		
		textFieldNomPos = new JTextField();
		textFieldNomPos.setBounds(10, 53, 194, 20);
		panel_Pos.add(textFieldNomPos);
		textFieldNomPos.setColumns(10);
		
		textFieldIngPos = new JTextField();
		textFieldIngPos.setBounds(10, 109, 194, 20);
		panel_Pos.add(textFieldIngPos);
		textFieldIngPos.setColumns(10);
		
		textFieldPrecioPos = new JTextField();
		textFieldPrecioPos.setBounds(10, 152, 86, 20);
		panel_Pos.add(textFieldPrecioPos);
		textFieldPrecioPos.setColumns(10);
		
		JButton btnGuardarPos = new JButton("Guardar");
		btnGuardarPos.setBounds(307, 271, 89, 23);
		panel_Pos.add(btnGuardarPos);
		
		
		JLabel lblCategoraPos = new JLabel("Categor\u00EDa");
		lblCategoraPos.setBounds(10, 11, 67, 14);
		panel_Pos.add(lblCategoraPos);
		
		txtPostres = new JTextField();
		txtPostres.setEnabled(false);
		txtPostres.setEditable(false);
		txtPostres.setText("Postres");
		txtPostres.setBounds(80, 8, 86, 20);
		panel_Pos.add(txtPostres);
		txtPostres.setColumns(10);

		f= new ConexionDB();
	}
}
