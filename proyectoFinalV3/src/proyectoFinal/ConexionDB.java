package proyectoFinal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;



public class ConexionDB {
	private Connection conexion =null;//maneja la conexión
	private Statement instruccion = null;//instrucción de consulta
	private ResultSet resRecetas = null;// Maneja los resultados de Receta
	private ResultSet resUser = null;//Maneja los resultados de Usuario
	private ResultSet resBuscar = null; //Maneja los resultados de Buscar
	
	public ConexionDB() {
		//conectamos a la BD
		//hace una especie de import, la diferencia entre class for name e import es q
		//podemos importar librerias y objetos de forma dinamica,cuando estamos ejecutando
		try {
			Class.forName("com.mysql.jdbc.Driver");//cargar libreria a traves de build path add external
			// establece la conexión a la base de datos - Conecto 
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/recetarium","root","");
			System.out.println("Has conectado a la BD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		


	}
	
 
			// ****************  Método donde leeremos de la base de datos las recetas existentes  *************
			
			public void leerRecetas(JComboBox comboBoxR){
				//Aquí realizaremos la consulta y actualización del combobox
				// crea objeto Statement para consultar la base de datos
				try
				
				{		
					comboBoxR.removeAllItems();
					// Preparamos la consulta
					Statement instruccion = (Statement) conexion.createStatement();	 
					// Se realiza la consulta
					resRecetas = instruccion.executeQuery ("SELECT * FROM recetas");		 
					// Bucle while para la consulta
					//Añado una rececta en blanco para que aparezca en primera posicion
					Receta nuevaReceta = new Receta("Selecciona Receta");//El string se lo estoy pasando x q  lo indico en los parametros de su constructor que va a recibir un String
					comboBoxR.addItem(nuevaReceta);//añade receta al comboBox para que no quede ninguna seleccionada
				while (resRecetas.next())//mientras existan filas
				{
					nuevaReceta = new Receta(resRecetas.getInt("idReceta"),resRecetas.getString("nombre"),resRecetas.getString("ingredientes"),resRecetas.getFloat("precio"),resRecetas.getString("dificultad"),resRecetas.getString("descripcion"),resRecetas.getString("categoria"));
					// Rellenar el combobox a partir de consulta
					//Ultimo Paso Mostrar por pantalla
					comboBoxR.addItem(nuevaReceta);
					//System.out.println("Receta Añadida: "+nuevaReceta);
					//JOptionPane.showMessageDialog( null, "El nombre de la receta añadida es: " +nuevaReceta);
				}//cierro while
					} catch (Exception e){
					System.out.println ("No hay recetas!!");
					JOptionPane.showMessageDialog( null, "No hay recetas!!");
					}//cierro if

			}//cierro metodo leerRecetas
			
			//***********************  Leer receta filtrando por nombre  ******************************
			
			public void leerRecetasN(String nombre){
				//Aquí realizaremos la consulta y actualización del combobox
				// crea objeto Statement para consultar la base de datos
				try
				{			
					// Preparamos la consulta
					Statement instruccion = (Statement) conexion.createStatement();	 
					// Se realiza la consulta 
					
					resBuscar = instruccion.executeQuery ("SELECT * FROM recetas WHERE '"+nombre+"'");
					while(resBuscar.next()){
						System.out.println("La receta es "+resBuscar.getString("nombre"));
						JOptionPane.showMessageDialog(null, "La receta es "+resBuscar.getString("nombre"));
					}
				
				} catch (Exception e){
					System.out.println ("No hay nada con ese nombre");
					JOptionPane.showMessageDialog( null, "No hay nada con ese nombre");
					}

			}

		
			public void insertarReceta(int idReceta,String nombre, String ingredientes, float precio,String dificultad,String  descripcion,String categoria,JComboBox comboBoxR){
				//Aquí realizaremos la consulta				 
				//VTabRecetas vtRecetas= new VTabRecetas();
				try{
					 //preparamos la conexion con Statement
					 instruccion = (Statement) conexion.createStatement();
			            //Insertamos datos
			            String insertBBDD = "INSERT INTO recetas (idReceta, nombre,ingredientes,precio,dificultad,descripcion,categoria)";    
			            insertBBDD = insertBBDD + "VALUES ("+idReceta+",'"+nombre+"','"+ingredientes+"',"+precio+",'"+dificultad+"','"+descripcion+"','"+categoria+"' )";//los Strings '""' los int ""
			            instruccion.executeUpdate(insertBBDD);
			            System.out.println("Se ha insertado en la BD"+insertBBDD);
			            JOptionPane.showMessageDialog( null, "Receta guardada en la Bd, cierra esta ventana y dale a Leer");
			            //Actualizamos el comboBox
			            //comboBoxR.updateUI();
			           // leerRecetas(vtRecetas.comboBoxR);
			            }catch(SQLException e ){
			            	JOptionPane.showMessageDialog( null, "No se ha guardado la receta");   
			            }
			}
			
			//***************Método para loguear al user con la Bd, lo coloco aquí, por que ya tengo la conexion 
			//en esta clase y me ahorro crearla por todas las clases
			public  boolean getLogin(String user,String password){
				
				boolean conectado=false;//creo la variable, por defecto esta desconectado, ante la duda de si lo esta
				 try{
				// Preparamos la consulta
				Statement instruccion = (Statement) conexion.createStatement();	
				System.out.println(("SELECT * FROM users WHERE `name`='"+user+"' AND `password`='"+password+"'"));
				// Se realiza la consulta
				resUser = instruccion.executeQuery ("SELECT * FROM users WHERE `name`='"+user+"' AND `password`='"+password+"'");
				System.out.println("Leyendo user de la bd"+resUser);
				resUser.last();//llamo al ultimo
				if(resUser.getRow()>0)//si getRow devuelve 0 no hay nada, si devuelve 1 entra
					conectado=true;//lo dejo comentado : si siempre es true, en el boton login me entra siempre en el if
				else
					conectado=false;
			}catch(SQLException e){
				JOptionPane.showInternalMessageDialog(null,"Revisa usuario o contraseña");
                System.out.println("Revisa usuario o contraseña");
                return conectado;//devuelve la variable conectado.
            }
				return conectado;//devuelve la variable conectado.
		
			}
			}

