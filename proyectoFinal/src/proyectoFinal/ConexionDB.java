package proyectoFinal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;



public class ConexionDB {
	private Connection conexion =null;
	private Statement instruccion = null;
	private ResultSet resRecetas = null;

	public ConexionDB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/recetarium","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		


	}
	
/*	public void leerRecetas(JComboBox comboBoxRecetas){
		try{
			instruccion = (Statement) conexion.createStatement();
			resRecetas = instruccion.executeQuery("SELECT * FROM recetarium");
			while(resRecetas.next()){
				TabReceta nuevaReceta = new TabReceta (resRecetas.getInt("idReceta"),resRecetas.getString("nombre"),resRecetas.getFloat("precio"),resRecetas.getString("dificultad"),resRecetas.getString("descripcion"),resRecetas.getString("categoria"));
				resRecetas.addItem(nuevaReceta);
				System.out.println("Receta Añadida: "+nuevaReceta);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		

	}*/
}

