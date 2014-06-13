package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class VPRecetarium extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private ConexionDB miConexion;
	private JComboBox<Receta> comboBoxR;
	Receta recetas=new Receta();//Creo objeto para usar Recetas
	VistaRecetas vR;
	boolean abrirVistaReceta=false;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPRecetarium frame = new VPRecetarium();
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
	
	public VPRecetarium() {
		//Creamos objeto para llamar al método	
				miConexion = new ConexionDB();
				recetas = new Receta ();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(new Color(0, 102, 0));
		setTitle("RECETARIUM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		setBackground(new Color(0, 102, 51));
		setBounds(100, 100, 422, 268);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 82, 406, 193);
		panel.setBackground(new Color(220, 220, 220));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new TitledBorder(null, "Opciones Recetarium", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//**************** Botón añadir Receta ******************************
		JButton btnAnReceta = new JButton("A\u00F1adir Receta");
		btnAnReceta.setBackground(new Color(153, 204, 51));
		btnAnReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Accion para abrir la ventana TabRecetas donde se añaden, cojo cabecera de su clase
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VTabRecetas frame = new VTabRecetas();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});}
		});;
		btnAnReceta.setBounds(231, 107, 165, 23);
		panel.add(btnAnReceta);
		
		//**********************Boton Leer Recetas ****************************************************
		//y su accion que llevará a Leer las  Recetas que hay
		JButton btnLeerR = new JButton("Leer Recetas");
		btnLeerR.setBackground(new Color(153, 204, 51));
		btnLeerR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 abrirVistaReceta=false;
				comboBoxR.removeAllItems();
				miConexion.leerRecetas(comboBoxR);
				abrirVistaReceta=true;
				
				 		 
				
			}
		});
		btnLeerR.setBounds(10, 107, 165, 23);
		panel.add(btnLeerR);
		
		textBusca = new JTextField();
		textBusca.setBackground(new Color(153, 204, 51));
		textBusca.setBounds(10, 63, 248, 23);
		panel.add(textBusca);
		textBusca.setColumns(40);
		
		//**************Boton buscar*****************************************
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(153, 204, 51));
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setIcon(null);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Se coloca arriba de try antes de coger el texto
				miConexion.leerRecetasN(textBusca.getText());		
				//Utiliza el método buscar..que esta en la clase Conexion
				//try {
					//VistaRecetas frame = new VistaRecetas(recetas, dtmResultados);
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
				
					}
					});
		btnBuscar.setBounds(277, 63, 106, 23);
		panel.add(btnBuscar);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(10, 21, 46, 14);
		panel.add(lblUser);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(43, 18, 86, 20);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(139, 21, 64, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 18, 91, 20);
		panel.add(passwordField);
		
		//******************************* Boton Login **********************************
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//le paso el metodo getLogin igualandolo a
				//coge el password del campopassword, convierte a int desde String coge el campo usuario
				boolean conectado = miConexion.getLogin(textFieldUser.getText(),String.valueOf(passwordField.getPassword()));
				if (conectado==true){
					//Falta poner que compruebe el usuario en la bd bien
					System.out.println("Usuario ok");
					JOptionPane.showMessageDialog(null,"Usuario ok");
				}else {
					System.out.println(" No existe el usuario... utiliza Eri y passwd 12345");
					JOptionPane.showMessageDialog(null," No existe el usuario... utiliza Eri y passwd 12345");
				}
			}
		});
		btnLogin.setBounds(312, 17, 79, 23);
		panel.add(btnLogin);
		
		//--------------------------------Combobox Recetas-----------------------------------------------------
		
		comboBoxR = new JComboBox<Receta>();
		comboBoxR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						//getItemAdd devolverá el objeto completo aunque yo al combobox le pase solo el nombre
						//getSelectedIndex, sacará la posición
						if(comboBoxR.getSelectedIndex()>0){
						VistaRecetas frame = new VistaRecetas(comboBoxR.getItemAt(comboBoxR.getSelectedIndex()));
						frame.setVisible(true);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		comboBoxR.setBackground(new Color(102, 204, 51));
		comboBoxR.setBounds(23, 44, 175, 20);
		contentPane.add(comboBoxR);
		 
		
		
		
		JLabel lblColRecetas = new JLabel("Colecci\u00F3n de Recetas");
		lblColRecetas.setBounds(24, 11, 149, 14);
		contentPane.add(lblColRecetas);
		lblColRecetas.setBackground(Color.WHITE);
		lblColRecetas.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label = new JLabel("");
		label.setBounds(0, -41, 406, 140);
		contentPane.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
	
		
		miConexion.leerRecetas(comboBoxR);
	
	}
}
