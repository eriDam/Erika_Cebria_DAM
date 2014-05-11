import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


//Bibliotecas necesarias para usar la conexion de la  DB


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class AdministradorApuestas extends JFrame {
	private JPanel contentPane;
	private JLabel lblNombreDeLa;
	private JLabel lblAdministradorDeApuestas;
	private JButton btnAdministrar;
	private JButton btnGenerarApuesta;
	private JButton btnSeguimientoDeApuestas;
	private VentanaLiga frameLiga;
	private Liga liga;
	private JComboBox<Liga> comboBoxNombreLiga;
	//DB 
	//maneja la conexión, 1 objeto de conexion, se genera aqui por que solo voy a necesitar una conexion de la base de datos 
	Connection conexion = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministradorApuestas frame = new AdministradorApuestas();
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
	public AdministradorApuestas() 
	{
	//conectamos a la BD
		//hace una especie de import, la diferencia entre class for name e import es q
		//podemos importar librerias y objetos de forma dinamica,cuando estamos ejecutando
		try{
			Class.forName("com.mysql.jdbc.Driver");//Una vez cargada la libreria del driver
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
			//tenemos la conexion realizada, si da error, hay que ir a carpeta del proyecto-bot dcho 
			//Build path y añadimos external files en mySqlconector
			
		}
		catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch	
		catch( Exception e )//Capturo todas las excepciones a ver 
		{
			e.printStackTrace();
		}// fin de catch	
		
		final Liga liga= new Liga((com.mysql.jdbc.Connection) conexion);//Crear objeto liga para que
		
		//caracteristicas panel principal
		setBackground(new Color(0, 0, 153));
		setTitle("Administrator");
		setFont(new Font("Adobe Heiti Std R", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\Apuestas\\Apuestas\\src\\balon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(20, 125, 261, -99);
		contentPane.add(horizontalBox);
		
		//Panel secundario generar apuesta
		JButton btnGenerarApuesta = new JButton("Generar Apuesta");
		btnGenerarApuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGenerarApuesta.setBounds(20, 165, 211, 23);
		contentPane.add(btnGenerarApuesta);
		
		JButton btnSeguimiento = new JButton("Seguimiento de apuestas");
		btnSeguimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeguimiento.setBounds(20, 199, 211, 23);
		contentPane.add(btnSeguimiento);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Administrador de Ligas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 389, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeLa_1 = new JLabel("Nombre de la Liga");
		lblNombreDeLa_1.setBounds(10, 34, 151, 14);
		panel.add(lblNombreDeLa_1);
		
		JButton btnAdministrar_1 = new JButton("Administrar");
		btnAdministrar_1.setBounds(10, 101, 110, 23);
		panel.add(btnAdministrar_1);
		
		JComboBox comboBoxLiga = new JComboBox<Liga>();
		comboBoxLiga.setBounds(20, 59, 169, 20);
		panel.add(comboBoxLiga);
		
		btnAdministrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Liga liga= new Liga((com.mysql.jdbc.Connection) conexion);//Crear objeto liga para que almacene los equipos	
				//Para que abra la ventanaLiga
				/*VentanaLiga v2= new VentanaLiga(liga);
				v2.setVisible(true);
				v2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*///errores
					openLigaWindow(liga);
			}

		});
	
		}
	private void openLigaWindow (Liga liga){
		frameLiga=new VentanaLiga(liga);
		frameLiga.setVisible(true);
		frameLiga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
