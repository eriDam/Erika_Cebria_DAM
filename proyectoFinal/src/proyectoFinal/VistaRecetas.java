package proyectoFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class VistaRecetas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldN;
	
	//creo atributos
	private DefaultTableModel dtmResultados;
	private JTable table;
	private JScrollPane scpEjemplo;
	

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

	/**
	 * Create the frame.
	 */
	 
	public VistaRecetas(Receta reccetaElegida,DefaultTableModel recetasBuscadas) {
		dtmResultados=recetasBuscadas;
		
		
		setTitle("Recetas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\descarga.jpg"));
		setForeground(new Color(153, 153, 204));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//Oculta la ventana
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnGuardar = new JButton("Listado");
		btnGuardar.setBounds(10, 331, 111, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnGuardar);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(344, 10, 29, 14);
		contentPane.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(364, 6, 47, 20);
		textFieldN.setEditable(false);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JButton btnVolverRecetarium = new JButton("Volver Recetarium");
		btnVolverRecetarium.setBounds(139, 331, 145, 23);
		btnVolverRecetarium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		contentPane.add(btnVolverRecetarium);
		
		JButton btnAadirReceta = new JButton("A\u00F1adir Receta");
		btnAadirReceta.setBounds(294, 331, 130, 23);
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
		contentPane.add(btnAadirReceta);
		
		JLabel label = new JLabel("");
		label.setBounds(10, -1, 414, 102);
		label.setIcon(new ImageIcon("C:\\Users\\Eri\\git\\ErikaCebriaDam\\proyectoFinal\\src\\logo.jpg"));
		contentPane.add(label);
		
		JScrollPane scpEjemplo = new JScrollPane();
		scpEjemplo.setBounds(19, 118, 403, 187);
		contentPane.add(scpEjemplo);
		
		table = new JTable();
		scpEjemplo.setViewportView(table);
	

	
	}
}
