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

public class Recetarium extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recetarium frame = new Recetarium();
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
	public Recetarium() {
		setForeground(new Color(0, 102, 0));
		setTitle("RECETARIUM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		setBackground(new Color(0, 102, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 199, 20);
		contentPane.add(comboBox);
		
		JLabel lblColRecetas = new JLabel("Colecci\u00F3n de Recetas");
		lblColRecetas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColRecetas.setBounds(10, 11, 149, 14);
		contentPane.add(lblColRecetas);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 96, 434, 166);
		panel.setBackground(new Color(220, 220, 220));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new TitledBorder(null, "Opciones Recetarium", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAnReceta = new JButton("A\u00F1adir Receta");
		btnAnReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Recetas frame = new Recetas();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});*/
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TabReceta frame = new TabReceta();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAnReceta.setBounds(10, 95, 180, 23);
		panel.add(btnAnReceta);
		
		JButton btnEntrantes = new JButton("Entrantes");
		btnEntrantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TabReceta frame = new TabReceta();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnEntrantes.setBounds(262, 11, 142, 23);
		panel.add(btnEntrantes);
		
		JButton btnPlatosFros = new JButton("Platos fr\u00EDos");
		btnPlatosFros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TabReceta frame = new TabReceta();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				}
		});
		btnPlatosFros.setBounds(262, 45, 142, 23);
		panel.add(btnPlatosFros);
		
		JButton btnPlatosCalientes = new JButton("Platos calientes");
		btnPlatosCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TabReceta frame = new TabReceta();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnPlatosCalientes.setBounds(262, 79, 142, 23);
		panel.add(btnPlatosCalientes);
		
		JButton btnPostres = new JButton("Postres");
		btnPostres.setBounds(262, 113, 142, 23);
		panel.add(btnPostres);
		
		textField = new JTextField();
		textField.setBackground(new Color(153, 153, 204));
		textField.setBounds(10, 45, 180, 22);
		panel.add(textField);
		textField.setColumns(40);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 20, 91, 14);
		panel.add(lblBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		label.setBounds(0, -59, 434, 192);
		contentPane.add(label);
	}
}
