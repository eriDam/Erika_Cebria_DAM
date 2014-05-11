import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;


	public class ControllerDB {
		//DB
		Connection conexion = null; //maneja la conexión
		Statement instruccion= null;// instrucción de consulta
		ResultSet cResultado= null;// maneja los resultados
		

		public ControllerDB() {
			//Nos conectamos a la base de datos
			crearConexion();
		}

		private void crearConexion(){
		//conectamos a la BD
			//hace una especie de import, la diferencia entre class for name e import es q
			//podemos importar librerias y objetos de forma dinamica,cuando estamos ejecutando
			try{
				Class.forName("com.mysql.jdbc.Driver");
				// establece la conexión a la base de datos
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
			}catch( SQLException excepcionSql ){
				excepcionSql.printStackTrace();
			}// fin de catch
			catch( ClassNotFoundException noEncontroClase )
			{
				noEncontroClase.printStackTrace();
			}// fin de catch
		}

		//En este método leeremos de la base de datos los equipos existentes
		// 1.- Leer de la base de datos
		// 2.- Actualizar el combobox
		public void leerEquipos(JComboBox listadoEquipos){
			//Aquí realizaremos la consulta y actualización del combobox
			// crea objeto Statement para consultar la base de datos
			try
			{			
				// Preparamos la consulta
				Statement instruccion = conexion.createStatement();	 
				// Se realiza la consulta
				cResultado = instruccion.executeQuery ("SELECT nombreEquipo FROM equipos");		 
				// Bucle while para la consulta
			while (cResultado.next())//mientras existan filas
			{
				// Rellenar el combobox a partir de consulta
				//Ultimo Paso Mostrar por pantalla
				listadoEquipos.addItem (cResultado.getObject("nombreEquipo"));
				 //Compruebo...
				   //System.out.println("id Equipo="+conjuntoResultados.getObject("idEquipo")+"id Liga="+conjuntoResultados.getObject("idLiga")+
				     //" nombre Equipo= "+conjuntoResultados.getObject("nombreEquipo") +" , goles a Favor= "+conjuntoResultados.getObject("golesFavor")+", golesEnContra= "+conjuntoResultados.getObject("golesEnContra")+", partidos Ganados= "+conjuntoResultados.getObject("partidosGanados")+", partidos Perdidos
					//= "+conjuntoResultados.getObject("partidosPerdidos"));
				System.out.println("El equipo es " +cResultado.getObject("nombreEquipo")); 
			}	
			//conjuntoResultados.close();
				} catch (Exception e){
				System.out.println (e);
				}

		}

		//En este método leeremos de la base de datos los equipos existentes
		// 1.- Crearemos la consulta a la base de datos (Statement)
		// 2.- Lanzaremos la consulta
		// 3.- Eliminaremos todos los elementos del combobox
		// 4.- Volveremos a rellenar el combobox
		public void insertarEquipos(int idLiga,String nombreEquipo,int golesFavor,int golesEnContra, int partidosGanados,int partidosPerdidos,JComboBox listadoEquipos){
			//Aquí realizaremos la consulta
			 try{
				 instruccion = (Statement) conexion.createStatement();
		            //Insertamos datos
		            String insertBBDD = "INSERT INTO equipos (idLiga, nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos)";    
		            insertBBDD = insertBBDD + "VALUES ("+idLiga+",'"+nombreEquipo+"',"+golesFavor+","
		                    +golesEnContra+","+partidosGanados+","+ ""+partidosPerdidos+" )";
		    
		            instruccion.executeUpdate(insertBBDD);
		            }catch(SQLException excepcionSql ){
		                excepcionSql.printStackTrace();    
		            }
			//Actualización del combobox
			listadoEquipos.removeAllItems();
			leerEquipos(listadoEquipos);
		}

	}