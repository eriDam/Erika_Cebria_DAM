import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JComboBox;


public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private Liga liga;
	private Equipo equipo;
	private JTextField textFieldNumEquipos;
	private VentanaEquipo frameEquipo;
	private VentanaLiga vLiga;
	//private JComboBox comboBox;
	private JComboBox<Equipo> comboBox;
	
	private JTextField textFieldnombreLiga;
 

		
	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModificar) {
		liga=ligaModificar;
		vLiga=this;
		
		setForeground(Color.GRAY);
		setOpacity(1.0f);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\Apuestas\\Apuestas\\src\\balon.jpg"));		
		setFont(new Font("Adobe Caslon Pro", Font.BOLD, 12));
		setTitle("Ventana Liga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiq NombreLiga
		JLabel lblNombreLiga = new JLabel("Nombre de la Liga");
		lblNombreLiga.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreLiga.setBounds(10, 11, 146, 14);
		contentPane.add(lblNombreLiga);
		
		//Etiqueta Equips
		JLabel lblEquipoAModificar = new JLabel("Equipos");
		lblEquipoAModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipoAModificar.setBounds(10, 73, 127, 14);
		contentPane.add(lblEquipoAModificar);
		
		
		
		JLabel lblNumeroDeEquipos = new JLabel("Numero de equipos");
		lblNumeroDeEquipos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDeEquipos.setBounds(255, 11, 134, 14);
		contentPane.add(lblNumeroDeEquipos);
		
		textFieldNumEquipos = new JTextField();
		textFieldNumEquipos.setEnabled(false);
		textFieldNumEquipos.setText("0");
		textFieldNumEquipos.setBounds(255, 37, 86, 20);
		contentPane.add(textFieldNumEquipos);
		textFieldNumEquipos.setColumns(10);
	
		//Añadir numero de equipos
		textFieldNumEquipos.setText(String.valueOf(liga.getNumEquipos()));
		

		//Boton modificar
		JButton btnModificarEquipo = new JButton("Modificar");
		btnModificarEquipo.addActionListener(new ActionListener() {
			/*Accion Cuando le demos al boton modificar, lanzamos un nuevo ventana equipo, le pasamos el objeto por el constructor para que 
			 * ventanaLiga mantenga todos los equipos
			 * */
			
			public void actionPerformed(ActionEvent e) {
				openEquipoWindow(liga.getEquipo(comboBox.getSelectedIndex()),true);
				frameEquipo.setVisible(true);
				frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnModificarEquipo.setBounds(112, 124, 89, 23);
		contentPane.add(btnModificarEquipo);
		//Creo comboBox
		comboBox = new JComboBox<Equipo>();
		comboBox.setBounds(10, 93, 229, 20);
		contentPane.add(comboBox);
		
		//Añado equipos
		//comboBox.addItem(new Equipo("vlc",0,0,0,0));
		//comboBox.addItem(new Equipo("bcn",0,0,0,0));
		//contentPane.add(comboBox);
		//Como saber que equipo se ha seleccionado
		//Equipo elegido=(Equipo) comboBox.getItemAt(1);

		//Como cambiar el nombre del equipo
		//System.out.println(elegido.getNombreEquipo());
		//elegido.setNombreEquipo("bcn2");
		
		
		//Boton +
		JButton btnNewButtonAdd = new JButton("+");
		btnNewButtonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				liga.newEquipo();
				Equipo e=new Equipo();
				System.out.println(liga.getNumEquipos()-1);
				openEquipoWindow(e,false);
				//liga.newEquipoDB(equipo); Comentado de momento creo que no va aquí
				
			}
		});
		btnNewButtonAdd.setBounds(10, 124, 41, 23);
		contentPane.add(btnNewButtonAdd);
		
		//Boton  -
		JButton btnNewButtonRest = new JButton("-");
		btnNewButtonRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//liga.newEquipo();
				//openEquipoWindow(liga.getEquipo(liga.getNumEquipos()-1),false);
				//liga.deleteEquipo(posicion);
			}
		});
		btnNewButtonRest.setBounds(61, 124, 41, 23);
		contentPane.add(btnNewButtonRest);
		
		textFieldnombreLiga = new JTextField();
		textFieldnombreLiga.setBounds(20, 36, 136, 20);
		contentPane.add(textFieldnombreLiga);
		textFieldnombreLiga.setColumns(10);
	
	
	}


	
		private void openEquipoWindow(Equipo equipo,boolean modifica){
			frameEquipo = new VentanaEquipo(equipo,this.comboBox,modifica,this.liga);
			frameEquipo.setVisible(true);
			frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

