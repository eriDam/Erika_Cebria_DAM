package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class VistaRecetas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

	/**
	 * Create the frame.
	 */
	public VistaRecetas(Receta reccetaElegida) {
		setTitle("Recetas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		setForeground(new Color(153, 153, 204));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//Oculta la ventana
		setBounds(100, 100, 453, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAadirReceta = new JButton("A\u00F1adir Receta");
		btnAadirReceta.setBounds(166, 444, 117, 23);
		btnAadirReceta.addActionListener(new ActionListener() {
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
				});}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAadirReceta);
		
		JLabel labelCabecera = new JLabel("");
		labelCabecera.setBounds(0, 0, 435, 101);
		labelCabecera.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		contentPane.add(labelCabecera);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				JOptionPane.showMessageDialog( null, "Pronto se verán las recetas!!");
			
			}
		});
		lblNewLabel.setBounds(72, 143, 309, 255);
		lblNewLabel.setIcon(new ImageIcon(VistaRecetas.class.getResource("/ImageVentanas/android construccion.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblEstamosEnConstruccinpronto = new JLabel("Estamos en construcci\u00F3n");
		lblEstamosEnConstruccinpronto.setBounds(98, 95, 288, 41);
		lblEstamosEnConstruccinpronto.setFont(new Font("Usuzi Italic", Font.BOLD, 14));
		contentPane.add(lblEstamosEnConstruccinpronto);
		
		JLabel lblSiQuieresPuedes = new JLabel("Mientras puedes");
		lblSiQuieresPuedes.setForeground(new Color(154, 205, 50));
		lblSiQuieresPuedes.setFont(new Font("Usuzi Italic", Font.BOLD, 14));
		lblSiQuieresPuedes.setBounds(139, 409, 176, 14);
		contentPane.add(lblSiQuieresPuedes);
	}
}
