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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\workspaceDam\\proyectoFinal\\src\\descarga.jpg"));
		setBackground(new Color(0, 102, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 199, 20);
		contentPane.add(comboBox);
		
		JLabel lblColRecetas = new JLabel("Colecci\u00F3n de Recetas");
		lblColRecetas.setBounds(10, 11, 149, 14);
		contentPane.add(lblColRecetas);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new TitledBorder(null, "Opciones Recetarium", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 82, 414, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAnReceta = new JButton("A\u00F1adir Receta");
		btnAnReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnReceta.setBounds(10, 95, 180, 23);
		panel.add(btnAnReceta);
		
		JButton btnEntrantes = new JButton("Entrantes");
		btnEntrantes.setBounds(286, 11, 118, 23);
		panel.add(btnEntrantes);
		
		JButton btnPlatosFros = new JButton("Platos fr\u00EDos");
		btnPlatosFros.setBounds(286, 45, 118, 23);
		panel.add(btnPlatosFros);
		
		JButton btnPlatosCalientes = new JButton("Platos calientes");
		btnPlatosCalientes.setBounds(286, 79, 118, 23);
		panel.add(btnPlatosCalientes);
		
		JButton btnPostres = new JButton("Postres");
		btnPostres.setBounds(286, 113, 118, 23);
		panel.add(btnPostres);
		
		textField = new JTextField();
		textField.setBackground(new Color(153, 153, 204));
		textField.setBounds(10, 45, 180, 22);
		panel.add(textField);
		textField.setColumns(40);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 20, 91, 14);
		panel.add(lblBuscar);
	}
}
