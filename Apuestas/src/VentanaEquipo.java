//La ventana va a servir para modificar cada uno de los campos que hemos creado y los guardaremos en un fichero de texto
/*Utilizaremos Equipo de una manera distinta ya que si lo declaramos como variable interna aqui en VentanaEquipo,
 *  al cerrar la ventana perdemos el atributo equipo y no lo podemos utilizar para el resto de programas. 
 *  En lugar de crearlo aqui por eso lo dejo con comentario, se crea en la clase principal
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;


public class VentanaEquipo extends JFrame {
	//Controles de la ventama
	private Equipo equipo;//Para utilizar Equipo, creamos la variable para luego generarla en el constructor
	private JPanel contentPane;
	private JTextField textFieldNombreEquipo;
	private JTextField textFieldGolesFavor;
	private JTextField textFieldGolesEnContra;
	private JTextField textFieldPartidosGanados;
	private JTextField textFieldPartidosPerdidos;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private JButton btnGuardar;
	private boolean modifica;
	private JComboBox jLiga;
	private VentanaLiga vLiga;
	private Liga liga;
	



	/**
	 * Create the frame.
	 */
		public VentanaEquipo(Equipo equipoAModificar,JComboBox jLiga,boolean modifica,Liga liga) {//A traves del constructor le hago llegar equipo creado en la clase principal
		//ahora la inicializo aqui pasandole todos los parametros que necesita por que el constructor de equipo los tiene 
		//equipo=new Equipo("",0,0,0,0); Lo crearé en la clase principal
		equipo=equipoAModificar;//lo igualamos al que acabamos de modificar
		this.jLiga=jLiga;
		this.modifica=modifica;
		this.liga=liga;
		
		//Caracteristicas ventana que puedo modificar
		setForeground(new Color(0, 0, 51));
		setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD, 12));
		//pongo icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eri\\git\\Apuestas\\Apuestas\\src\\balon.jpg"));
		//Pongo Título
		setTitle("Ventana del Equipo");
		//Para que al cerrar termine
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Etiqueta Nombre del equipo
		JLabel lblNombreEquipo = new JLabel("Nombre del equipo");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreEquipo.setBounds(23, 11, 116, 14);
		contentPane.add(lblNombreEquipo);
		
		//Etiqueta Goles a favor
		JLabel lblGolesFavor = new JLabel("Goles a favor");
		lblGolesFavor.setBounds(23, 65, 88, 14);
		contentPane.add(lblGolesFavor);
		
		//Etiqueta Goles en Contra
		JLabel lblGolesEnContra = new JLabel("Goles en contra");
		lblGolesEnContra.setBounds(267, 65, 100, 14);
		contentPane.add(lblGolesEnContra);
		
		//Etiqueta  PartidosGanados
		JLabel lblPartidosGanados = new JLabel("Partidos ganados");
		lblPartidosGanados.setBounds(23, 102, 104, 14);
		contentPane.add(lblPartidosGanados);
		
		//Etiqueta  PartidosPerdidos
		JLabel lblPartidosPerdidos = new JLabel("Partidos perdidos");
		lblPartidosPerdidos.setBounds(267, 102, 120, 14);
		contentPane.add(lblPartidosPerdidos);
		
		//Campo de Texto Nombre del equipo
		textFieldNombreEquipo = new JTextField();
		textFieldNombreEquipo.setBounds(23, 31, 401, 20);
		contentPane.add(textFieldNombreEquipo);
		textFieldNombreEquipo.setColumns(10);
		
		//Campo de Texto Goles a Favor
		textFieldGolesFavor = new JTextField();
		textFieldGolesFavor.setBounds(114, 62, 69, 20);
		contentPane.add(textFieldGolesFavor);
		textFieldGolesFavor.setColumns(10);
		
		//Campo de Texto Goles en contra
		textFieldGolesEnContra = new JTextField();
		textFieldGolesEnContra.setBounds(355, 62, 69, 20);
		contentPane.add(textFieldGolesEnContra);
		textFieldGolesEnContra.setColumns(10);
		
		//Campo de Texto PartidosGanados
		textFieldPartidosGanados = new JTextField();
		textFieldPartidosGanados.setBounds(114, 99, 69, 20);
		contentPane.add(textFieldPartidosGanados);
		textFieldPartidosGanados.setColumns(10);
		
		//Campo de Texto PartidosPerdidos
		textFieldPartidosPerdidos = new JTextField();
		textFieldPartidosPerdidos.setBounds(355, 99, 69, 20);
		contentPane.add(textFieldPartidosPerdidos);
		textFieldPartidosPerdidos.setColumns(10);
		
		//*************Botones*******************************
		
		//BOTON GUARDAR EQUIPO
		JButton btnGuardar = new JButton("Guardar Equipo");
		btnGuardar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						guardarEquipo();
				}
		});				
		btnGuardar.setBounds(279, 144, 145, 31);
		contentPane.add(btnGuardar);
		
		//BOTON LEER
		JButton btnLeer = new JButton("Leer Equipo");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//usamos el metodo
				leerFichero();
				//Hacemos que extraiga los datos del fichero
				textFieldNombreEquipo.setText(equipo.getNombreEquipo());
				textFieldGolesFavor.setText(String.valueOf(equipo.getGolesFavor()));
				textFieldGolesEnContra.setText(String.valueOf(equipo.getGolesEnContra()));
				textFieldPartidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
				textFieldPartidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
			}
		});
		btnLeer.setBounds(23, 186, 136, 27);
		contentPane.add(btnLeer);
		
		//BOTON GUARDAR EN DISCO
				JButton btnGuardarDisco = new JButton("Guardar en Disco");
				btnGuardarDisco.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*equipo.setGolesFavor(Integer.valueOf(textFieldGolesFavor.getText()));
						equipo.setGolesEnContra(Integer.valueOf(textFieldGolesEnContra.getText()));
						equipo.setNombreEquipo(textFieldNombreEquipo.getText());
						equipo.setPartidosGanados(Integer.valueOf(textFieldPartidosGanados.getText()));
						equipo.setPartidosPerdidos(Integer.valueOf(textFieldPartidosPerdidos.getText()));*/
					guardarEquipo();
					guardarEnFichero();
					//pruebo
					System.out.println("esto guarda GolesFavor:"+equipo.getGolesFavor());
					}
				});
				btnGuardarDisco.setBounds(23, 144, 136, 31);
				contentPane.add(btnGuardarDisco);
		
		
				//Leer el equipo ya modificado 
		        textFieldNombreEquipo.setText(equipo.getNombreEquipo());
		        textFieldGolesFavor.setText(String.valueOf(equipo.getGolesFavor()));
		        textFieldGolesEnContra.setText(String.valueOf(equipo.getGolesEnContra()));
		        textFieldPartidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
		        textFieldPartidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
		        
		        JButton btnBorrar = new JButton("Borrar");
		        btnBorrar.setBounds(279, 186, 145, 27);
		        contentPane.add(btnBorrar);
		}
		//------------------------------Metodo GuardarEquipo
		//Metodo que guarda datos en el objeto equipo
		private void guardarEquipo(){
			equipo.setGolesFavor(Integer.valueOf(textFieldGolesFavor.getText()));
			equipo.setGolesEnContra(Integer.valueOf(textFieldGolesEnContra.getText()));
			equipo.setNombreEquipo(textFieldNombreEquipo.getText());
			equipo.setPartidosGanados(Integer.valueOf(textFieldPartidosGanados.getText()));
			equipo.setPartidosPerdidos(Integer.valueOf(textFieldPartidosPerdidos.getText()));
			if(!modifica)
			{
				jLiga.addItem(equipo);
				this.liga.newEquipoDB(equipo);
			}else {
				Equipo equipoElegido=(Equipo)jLiga.getSelectedItem();
				equipoElegido.setNombreEquipo(equipo.getNombreEquipo());
			}
		}

	//------------------------------Metodo GuardarEnFichero--------------------------------------------------------
		//Metodo
		private void guardarEnFichero(){
			ObjectOutputStream salida;
			//abre el archivo
			try{
		salida= new ObjectOutputStream (new FileOutputStream("equipo.ser"));
		 
		salida.writeObject(equipo);//envía el registro como salida
		if (salida != null)
			salida.close();
		System.out.println("Archivo guardado ok");
		JOptionPane.showMessageDialog(null,"Archivo guardado ok ");
		}//Fin try
		catch(IOException ioException){
			System.err.println("Error al abrir el archivo");
		}//fin catch
		}//fin metodo

//----------------------------metodo que pone datos desde el objeto equipo
		private void leerEquipo(){
			textFieldNombreEquipo.setText(equipo.getNombreEquipo());
			textFieldGolesFavor.setText(String.valueOf(equipo.getGolesFavor()));
			textFieldGolesEnContra.setText(String.valueOf(equipo.getGolesEnContra()));
			textFieldPartidosGanados.setText(String.valueOf(equipo.getPartidosGanados()));
			textFieldPartidosPerdidos.setText(String.valueOf(equipo.getPartidosPerdidos()));
		}
//------------------------------Metodo LeerFichero-------------------------------------------------------------------
	    private void leerFichero(){
	    	try{
	    		entrada=new ObjectInputStream(new FileInputStream("equipo.ser"));
	    		equipo=(Equipo) entrada.readObject();//envia el registro como salida
	    		if(entrada !=null)
	    			entrada.close();
	    	}//fin try
	    	catch(IOException ioException)
	    	{
	    		System.err.println("Error al abrir el archivo");
	    	}//fin catch
	    	catch (ClassNotFoundException e) {
	    		System.err.println("Error al crear la clase");
			}
	    	
//------------------------------Métod Borrar Equipo	    	
	    }
	    }