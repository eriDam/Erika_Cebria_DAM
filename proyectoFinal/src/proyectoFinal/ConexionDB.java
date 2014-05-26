package proyectoFinal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;



public class ConexionDB {
	private Connection conexion =null;//maneja la conexión
	private Statement instruccion = null;//instrucción de consulta
	private ResultSet resRecetas = null;// maneja los resultados
	
	
	public ConexionDB() {
		//Nos conectamos a la base de datos
		crearConexion();
	}
	private void crearConexion(){
		//conectamos a la BD
		//hace una especie de import, la diferencia entre class for name e import es q
		//podemos importar librerias y objetos de forma dinamica,cuando estamos ejecutando
		try {
			Class.forName("com.mysql.jdbc.Driver");//cargar libreria a traves de build path add external
			// establece la conexión a la base de datos
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
	//En este método leeremos de la base de datos las recetas existentes
			// 1.- Leer de la base de datos
			// 2.- Actualizar el combobox
			public void leerRecetas(JComboBox listadoRecetas){
				//Aquí realizaremos la consulta y actualización del combobox
				// crea objeto Statement para consultar la base de datos
				try
				{			
					// Preparamos la consulta
					Statement instruccion = (Statement) conexion.createStatement();	 
					// Se realiza la consulta
					resRecetas = instruccion.executeQuery ("SELECT nombre FROM recetas");		 
					// Bucle while para la consulta
				while (resRecetas.next())//mientras existan filas
				{
					// Rellenar el combobox a partir de consulta
					//Ultimo Paso Mostrar por pantalla
					listadoRecetas.addItem (resRecetas.getObject("nombre"));
					
					   //System.out.println("id Equipo="+conjuntoResultados.getObject("idEquipo")+"id Liga="+conjuntoResultados.getObject("idLiga")+
					     //" nombre Equipo= "+conjuntoResultados.getObject("nombreEquipo") +" , goles a Favor= "+conjuntoResultados.getObject("golesFavor")+", golesEnContra= "+conjuntoResultados.getObject("golesEnContra")+", partidos Ganados= "+conjuntoResultados.getObject("partidosGanados")+", partidos Perdidos
						//= "+conjuntoResultados.getObject("partidosPerdidos"));
					System.out.println("La receta  es " +resRecetas.getObject("nombre")); 
				}	
				//conjuntoResultados.close();
					} catch (Exception e){
					System.out.println (e);
					}

			}

			
			public void insertarReceta(int idReceta,String nombre, String ingredientes, float precio,String dificultad,String  descripcion,String categoria,JComboBox listadoRecetas){
				//Aquí realizaremos la consulta
				//TabReceta nuevaReceta = new TabReceta (resRecetas.getInt("idReceta"),resRecetas.getString("nombre"),resRecetas.getFloat("precio"),resRecetas.getString("dificultad"),resRecetas.getString("descripcion"),resRecetas.getString("categoria"));
				 
				 try{
					 instruccion = (Statement) conexion.createStatement();
			            //Insertamos datos
			            String insertBBDD = "INSERT INTO recetas (idReceta, nombre,ingredientes,precio,dificultad,descripcion,categoria)";    
			            insertBBDD = insertBBDD + "VALUES ("+idReceta+",'"+nombre+"','"+ingredientes+"',"+precio+","+dificultad+",'"+descripcion+"','"+categoria+"' )";
			    
			            instruccion.executeUpdate(insertBBDD);
			            }catch(SQLException excepcionSql ){
			                excepcionSql.printStackTrace();    
			            }
				//Actualización del combobox
				listadoRecetas.removeAllItems();
				leerRecetas(listadoRecetas);
			}

}

