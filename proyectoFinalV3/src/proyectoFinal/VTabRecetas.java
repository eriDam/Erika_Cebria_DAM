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
import java.awt.Dialog.ModalExclusionType;

public class VTabRecetas extends JFrame {
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
	private JTextField textFieldNomPo;
	private JTextField textFieldIngPo;
	private JTextField textFieldPrecioPos;
	private JTextField txtEntrantes;
	private JTextField txtCatPr;
	private JTextField txtCatPo;
	private JTextField textFieldIdrecetaEn;
	private JTextField textFieldDifEnt;
	private JTextField textFieldIdRecetaPr;
	private JTextField textFieldDifPr;
	private JTextField textFieldIdRecetaPo;
	private JTextField textFieldDifPo;
//	//Creo el grupo de botones
//	private ButtonGroup grupoDeBotones;
//	private JRadioButton opF;
//	private JRadioButton opN;
//	private JRadioButton opD;
	
	//Creo el ComboBox
	private JComboBox<Receta> comboBoxR;
	
	//Creamos objeto para usar Conexión
	ConexionDB f= new ConexionDB();

	
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
		
		//****************Creo el grupo de Botones************************
		
//		grupoDeBotones = new ButtonGroup();
//		opF = new JRadioButton("OpF");
//		opF.setSelected(true);
//		opF.setBounds(6, 103, 109, 23);
//		contentPane.add(opF);
//		
//		opN = new JRadioButton("OpN");
//		opN.setBounds(6, 140, 109, 23);
//		contentPane.add(opN);
//		
//		opD = new JRadioButton("OpD");
//		opD.setBounds(6, 180, 109, 23);
//		contentPane.add(opD);
//		
//		//Añadimos los botones a un grupo de botones
//				grupoDeBotones.add(opF);
//				grupoDeBotones.add(opN);
//				grupoDeBotones.add(opD);
				
//		JRadioButton rdbtnFcil = new JRadioButton("F\u00E1cil");
//		rdbtnFcil.setBounds(10, 188, 68, 23);
//		panel.add(rdbtnFcil);
//		
//		JRadioButton rdbtnNormal = new JRadioButton("Normal");
//		rdbtnNormal.setBounds(80, 188, 74, 23);
//		panel.add(rdbtnNormal);
//		
//		JRadioButton rdbtnDificil = new JRadioButton("Dificil");
//		rdbtnDificil.setBounds(169, 188, 109, 23);
//		panel.add(rdbtnDificil);
		
		//----------------------------------------
		//           PANEL ENTRANTES
		// --------------------------------------- 
		JPanel panelEntrantes = new JPanel();
		tabbedPane.addTab("Entrantes", null, panelEntrantes, null);
		panelEntrantes.setLayout(null);
		
		JLabel labelEnt = new JLabel("");
		labelEnt.setBounds(238, -2, 225, 234);
		labelEnt.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\entrantes.gif"));
		panelEntrantes.add(labelEnt);
		
		JLabel lblNombreEn = new JLabel("Nombre");
		lblNombreEn.setBounds(10, 31, 46, 14);
		panelEntrantes.add(lblNombreEn);
		
		JLabel lblIngredientesEnt = new JLabel("Ingredientes");
		lblIngredientesEnt.setBounds(10, 77, 74, 14);
		panelEntrantes.add(lblIngredientesEnt);
		
		JLabel lblPrecioEnt = new JLabel("Precio");
		lblPrecioEnt.setBounds(10, 121, 46, 14);
		panelEntrantes.add(lblPrecioEnt);
		
		JLabel lblDificultadEnt = new JLabel("Dificultad");
		lblDificultadEnt.setBounds(10, 167, 95, 14);
		panelEntrantes.add(lblDificultadEnt);
		
		JLabel lblDescripcionEnt = new JLabel("Descripci\u00F3n");
		lblDescripcionEnt.setBounds(10, 218, 95, 14);
		panelEntrantes.add(lblDescripcionEnt);
		
		textFieldNomEnt = new JTextField();
		textFieldNomEnt.setBounds(10, 46, 193, 20);
		panelEntrantes.add(textFieldNomEnt);
		textFieldNomEnt.setColumns(10);
		
		textFieldIngrEnt = new JTextField();
		textFieldIngrEnt.setBounds(10, 90, 193, 20);
		panelEntrantes.add(textFieldIngrEnt);
		textFieldIngrEnt.setColumns(10);
		
		textFieldPreEnt = new JTextField();
		textFieldPreEnt.setBounds(10, 136, 86, 20);
		panelEntrantes.add(textFieldPreEnt);
		textFieldPreEnt.setColumns(10);
		
		textFieldDesEnt = new JTextField();
		textFieldDesEnt.setBounds(10, 241, 193, 53);
		panelEntrantes.add(textFieldDesEnt);
		textFieldDesEnt.setColumns(10);
		
		//BOTON GUARDAR ENTRANTES
		//con llamada a insertarRecetas, creado en ConexionDB
		
		JButton btnGuardarEnt = new JButton("Guardar");
		btnGuardarEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
			int idReceta= Integer.valueOf(Integer.parseInt(textFieldIdrecetaEn.getText()));
			String nombre=textFieldNomEnt.getText();
			String ingredientes=textFieldIngrEnt.getText();
			float precio= Float.valueOf(Float.parseFloat(textFieldPreEnt.getText()));
			// String dificultad =rdbtnFcil.getText();//Como es radio button no se como cogerlo
			String dificultad =textFieldDifEnt.getText();
			String descripcion= textFieldDesEnt.getText();
			String categoria=txtEntrantes.getText();
						
			//Llamamos al metodo insertar Receta
            f.insertarReceta(idReceta, nombre, ingredientes, precio, dificultad, descripcion, categoria, comboBoxR);
          //Me falta ponerle que lance un mensaje si se inserta ok
               
			}
			});
			btnGuardarEnt.setBounds(325, 256, 89, 23);
			panelEntrantes.add(btnGuardarEnt);
			
			JLabel lblCatEnt = new JLabel("Categor\u00EDa");
			lblCatEnt.setBounds(10, 6, 74, 14);
			panelEntrantes.add(lblCatEnt);
				
			txtEntrantes = new JTextField();
			txtEntrantes.setEnabled(false);
			txtEntrantes.setEditable(false);
			txtEntrantes.setText("Entrantes");
			txtEntrantes.setBounds(66, 3, 59, 20);
			panelEntrantes.add(txtEntrantes);
			txtEntrantes.setColumns(10);
				
			JLabel lblIdrecetaEn = new JLabel("IdReceta");
			lblIdrecetaEn.setBounds(135, 6, 66, 14);
			panelEntrantes.add(lblIdrecetaEn);
				
			textFieldIdrecetaEn = new JTextField();
			textFieldIdrecetaEn.setBounds(211, 3, 32, 20);
			panelEntrantes.add(textFieldIdrecetaEn);
			textFieldIdrecetaEn.setColumns(10);
				
			textFieldDifEnt = new JTextField();
			textFieldDifEnt.setBounds(85, 164, 86, 20);
			panelEntrantes.add(textFieldDifEnt);
			textFieldDifEnt.setColumns(10);
		
			//----------------------------------------
			//           PANEL PRIMEROS
			// --------------------------------------- 
			
		JPanel panelPr = new JPanel();
		tabbedPane.addTab("Primeros", null, panelPr, null);
		panelPr.setLayout(null);
		
		JLabel lblNombre_Pr = new JLabel("Nombre");
		lblNombre_Pr.setBounds(10, 37, 46, 14);
		panelPr.add(lblNombre_Pr);
		
		JLabel lblIngredientesPr = new JLabel("Ingredientes");
		lblIngredientesPr.setBounds(10, 83, 100, 14);
		panelPr.add(lblIngredientesPr);
		
		JLabel lblPrecioPr = new JLabel("Precio");
		lblPrecioPr.setBounds(10, 128, 46, 14);
		panelPr.add(lblPrecioPr);
		
		JLabel lblDificultadPr = new JLabel("Dificultad");
		lblDificultadPr.setBounds(10, 175, 76, 14);
		panelPr.add(lblDificultadPr);
		
		JLabel lblDescripPo = new JLabel("Descripci\u00F3n");
		lblDescripPo.setBounds(10, 226, 100, 14);
		panelPr.add(lblDescripPo);
		
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
		label_Pr.setBounds(261, 11, 202, 239);
		panelPr.add(label_Pr);
		
		//BOTON GUARDAR PRIMEROS
		JButton btnGuardarPr = new JButton("Guardar");
		btnGuardarPr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idReceta= Integer.valueOf(Integer.parseInt(textFieldIdRecetaPr.getText()));
				String nombre=textFieldNomPr.getText();
				String ingredientes=textFieldIngPr.getText();
				float precio= Float.valueOf(Float.parseFloat(textFieldPrecPr.getText()));
				// String dificultad =rdbtnFcil.getText();//Como es radio button no se como cogerlo
				String dificultad =textFieldDifPr.getText();
				String descripcion= textFieldDescPr.getText();
				String categoria=txtCatPr.getText();
				
				 //Llamamos al metodo insertar Receta
        f.insertarReceta(idReceta, nombre, ingredientes, precio, dificultad, descripcion, categoria, comboBoxR);
      //Me falta ponerle que lance un mensaje si se inserta ok
		}
		});
		btnGuardarPr.setBounds(309, 261, 89, 23);
		panelPr.add(btnGuardarPr);
		
		JLabel lblCatePr = new JLabel("Categor\u00EDa");
		lblCatePr.setBounds(10, 14, 76, 14);
		panelPr.add(lblCatePr);
		
		txtCatPr = new JTextField();
		txtCatPr.setEnabled(false);
		txtCatPr.setEditable(false);
		txtCatPr.setText("Primeros");
		txtCatPr.setBounds(75, 11, 61, 20);
		panelPr.add(txtCatPr);
		txtCatPr.setColumns(10);
		
		JLabel lblIdRePr = new JLabel("IdReceta");
		lblIdRePr.setBounds(146, 14, 54, 14);
		panelPr.add(lblIdRePr);
		
		textFieldIdRecetaPr = new JTextField();
		textFieldIdRecetaPr.setBounds(205, 11, 46, 20);
		panelPr.add(textFieldIdRecetaPr);
		textFieldIdRecetaPr.setColumns(10);
		
		textFieldDifPr = new JTextField();
		textFieldDifPr.setColumns(10);
		textFieldDifPr.setBounds(10, 195, 86, 20);
		panelPr.add(textFieldDifPr);
		
				//----------------------------------------
				//           PANEL POSTRES
				// --------------------------------------- 
		JPanel panelPo = new JPanel();
		tabbedPane.addTab("Postres", null, panelPo, null);
		panelPo.setLayout(null);
		
		JLabel label_Pos2 = new JLabel("");
		label_Pos2.setBounds(243, 31, 220, 229);
		label_Pos2.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		panelPo.add(label_Pos2);
		
		JLabel lblNombrePo = new JLabel("Nombre");
		lblNombrePo.setBounds(10, 38, 46, 14);
		panelPo.add(lblNombrePo);
		
		JLabel lblIngredientesPo = new JLabel("Ingredientes");
		lblIngredientesPo.setBounds(10, 84, 77, 14);
		panelPo.add(lblIngredientesPo);
		
		JLabel lblPrecioPo = new JLabel("Precio");
		lblPrecioPo.setBounds(10, 127, 46, 14);
		panelPo.add(lblPrecioPo);
		
		JLabel lblDificultadPo = new JLabel("Dificultad");
		lblDificultadPo.setBounds(10, 175, 46, 14);
		panelPo.add(lblDificultadPo);
		
		JLabel lblDescripcinPo = new JLabel("Descripci\u00F3n");
		lblDescripcinPo.setBounds(10, 226, 96, 14);
		panelPo.add(lblDescripcinPo);
		
//		JRadioButton rdbtnFcil_1 = new JRadioButton("F\u00E1cil");
//		rdbtnFcil_1.setBounds(10, 196, 58, 23);
//		panel_2.add(rdbtnFcil_1);
//		
//		JRadioButton rdbtnMedia = new JRadioButton("Media");
//		rdbtnMedia.setBounds(81, 196, 67, 23);
//		panel_2.add(rdbtnMedia);
//		
//		JRadioButton rdbtnDificil_1 = new JRadioButton("Dificil");
//		rdbtnDificil_1.setBounds(150, 196, 77, 23);
//		panel_2.add(rdbtnDificil_1);
		
		textFieldDesPos = new JTextField();
		textFieldDesPos.setBounds(10, 251, 194, 43);
		panelPo.add(textFieldDesPos);
		textFieldDesPos.setColumns(10);
		
		textFieldNomPo = new JTextField();
		textFieldNomPo.setBounds(10, 53, 194, 20);
		panelPo.add(textFieldNomPo);
		textFieldNomPo.setColumns(10);
		
		textFieldIngPo = new JTextField();
		textFieldIngPo.setBounds(10, 109, 194, 20);
		panelPo.add(textFieldIngPo);
		textFieldIngPo.setColumns(10);
		
		textFieldPrecioPos = new JTextField();
		textFieldPrecioPos.setBounds(10, 152, 86, 20);
		panelPo.add(textFieldPrecioPos);
		textFieldPrecioPos.setColumns(10);
		
		
		//BOTON GUARDAR POSTRES
		JButton btnGuardarPo = new JButton("Guardar");
		btnGuardarPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idReceta= Integer.valueOf(Integer.parseInt(textFieldIdRecetaPo.getText()));
				String nombre=textFieldNomPo.getText();
				String ingredientes=textFieldIngPo.getText();
				float precio= Float.valueOf(Float.parseFloat(textFieldPrecioPos.getText()));
				// String dificultad =rdbtnFcil.getText();//Como es radio button no se como cogerlo
				String dificultad =textFieldDifPo.getText();
				String descripcion= textFieldDesPos .getText();
				String categoria=txtCatPo.getText();
				//Llamamos al metodo insertar Receta
		        f.insertarReceta(idReceta, nombre, ingredientes, precio, dificultad, descripcion, categoria, comboBoxR);
		        //Me falta ponerle que lance un mensaje si se inserta ok
			}
		});
		btnGuardarPo.setBounds(307, 271, 89, 23);
		panelPo.add(btnGuardarPo);
		
		
		JLabel lblCatPo = new JLabel("Categor\u00EDa");
		lblCatPo.setBounds(10, 11, 67, 14);
		panelPo.add(lblCatPo);
		
		txtCatPo = new JTextField();
		txtCatPo.setEnabled(false);
		txtCatPo.setEditable(false);
		txtCatPo.setText("Postres");
		txtCatPo.setBounds(66, 8, 55, 20);
		panelPo.add(txtCatPo);
		txtCatPo.setColumns(10);
		
		JLabel lblIdeRecetaPo = new JLabel("Id Receta");
		lblIdeRecetaPo.setBounds(131, 11, 73, 14);
		panelPo.add(lblIdeRecetaPo);
		
		textFieldIdRecetaPo = new JTextField();
		textFieldIdRecetaPo.setBounds(200, 8, 46, 20);
		panelPo.add(textFieldIdRecetaPo);
		textFieldIdRecetaPo.setColumns(10);
		
		textFieldDifPo = new JTextField();
		textFieldDifPo.setColumns(10);
		textFieldDifPo.setBounds(10, 200, 86, 20);
		panelPo.add(textFieldDifPo);
	}
}
