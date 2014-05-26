package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class VPRecetarium extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ConexionDB miConexion;
	private JComboBox<Recetas> comboBoxR;
	Recetas recetas=new Recetas();//Creo objeto para usar Recetas
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(new Color(0, 102, 0));
		setTitle("RECETARIUM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		setBackground(new Color(0, 102, 51));
		setBounds(100, 100, 422, 253);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 82, 406, 133);
		panel.setBackground(new Color(220, 220, 220));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new TitledBorder(null, "Opciones Recetarium", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAnReceta = new JButton("A\u00F1adir Receta");
		btnAnReceta.setBackground(new Color(153, 204, 51));
		btnAnReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Accion para abrir la ventana TabRecetas donde se añaden
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VTabRecetas frame = new VTabRecetas();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAnReceta.setBounds(114, 93, 165, 23);
		panel.add(btnAnReceta);
		
		//Boton entrantes y su accion que llevará a abrir Recetas
		JButton btnEntrantes = new JButton("Entrantes");
		btnEntrantes.setBackground(new Color(153, 204, 102));
		btnEntrantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaRecetas frame = new VistaRecetas();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		btnEntrantes.setBounds(10, 59, 119, 23);
		panel.add(btnEntrantes);
		
		//Botón Primeros que lleva a abrir Ventana Recetas con un Select * from recetas where categoria=primeros
		JButton btnPlatosFros = new JButton("Primeros");
		btnPlatosFros.setBackground(new Color(153, 204, 102));
		btnPlatosFros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaRecetas frame = new VistaRecetas();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
				}
		});
		btnPlatosFros.setBounds(139, 59, 119, 23);
		panel.add(btnPlatosFros);
		
		
		//Botón Postres que lleva a abrir Ventana Recetas con un Select * from recetas where categoria=postres
		JButton btnPlatosCalientes = new JButton("Postres");
		btnPlatosCalientes.setBackground(new Color(153, 204, 102));
		btnPlatosCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaRecetas frame = new VistaRecetas();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		btnPlatosCalientes.setBounds(269, 59, 119, 23);
		panel.add(btnPlatosCalientes);
		
		textField = new JTextField();
		textField.setBackground(new Color(153, 204, 51));
		textField.setBounds(10, 19, 239, 23);
		panel.add(textField);
		textField.setColumns(40);
		
		//Boton buscar
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(new Color(153, 204, 102));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(282, 19, 106, 23);
		panel.add(btnNewButton);
		
		//--------------------------------Combobox Recetas---------------------------------------------------------
		JComboBox<Recetas> combobox= new JComboBox<Recetas>();
		combobox.setBackground(new Color(102, 204, 51));
		combobox.setBounds(10, 36, 199, 20);
		//contentPane.add(Recetas);
		combobox.addItem(new Recetas= 02, "panes", "agua",6,"media","cocer", "entrantes", comboBoxR);
		
		
		
		JLabel lblColRecetas = new JLabel("Colecci\u00F3n de Recetas");
		lblColRecetas.setBounds(10, 11, 149, 14);
		contentPane.add(lblColRecetas);
		lblColRecetas.setBackground(Color.WHITE);
		lblColRecetas.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label = new JLabel("");
		label.setBounds(0, -41, 434, 140);
		contentPane.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
	}
}
