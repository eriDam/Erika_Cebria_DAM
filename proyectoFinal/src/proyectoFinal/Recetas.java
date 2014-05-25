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
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recetas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldN;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

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
		
		JButton btnGuardar = new JButton("Listado");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(10, 331, 111, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(320, 11, 29, 14);
		contentPane.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(359, 8, 47, 20);
		textFieldN.setEditable(false);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JButton btnVolverRecetarium = new JButton("Volver Recetarium");
		btnVolverRecetarium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnVolverRecetarium.setBounds(139, 331, 145, 23);
		contentPane.add(btnVolverRecetarium);
		
		JButton btnAadirReceta = new JButton("A\u00F1adir Receta");
		btnAadirReceta.setBounds(294, 331, 130, 23);
		contentPane.add(btnAadirReceta);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		label.setBounds(10, 0, 424, 179);
		contentPane.add(label);
	}
}
