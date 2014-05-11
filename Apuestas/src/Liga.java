import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Liga implements Serializable{
//Declaracion de las variables u arrays
	
	private int numEquipos;
	private String nombreLiga;
	//private Equipo equipos[];lo dejo comentado y lo convierto a ArrayList
	private ArrayList <Equipo> equipos=new ArrayList<Equipo>();
	private int idLiga;
	private int idEquipo;
	
	//Creamos el conector con la db
	private Connection conexion = null;//maneja la conexión
	private Statement instruccion=null;//instruccion de consulta
	private ResultSet conjuntoResultados=null;//maneja los resultados
	
	//Constructor
	public Liga(Connection conexion) {//tanto en el constructor por defecto como en el otro le tenemos que pasar la conexion
		numEquipos=0;
		nombreLiga="Liga Futbol Española";
		this.conexion=conexion;
		leerLiga();
		
	}
	
	//Metodo igual q constructor pero con parametros o cuerpo diferente (aplico sobrecarga), 
	//el usuario sera quien introduzca datos
	public Liga(Connection conexion,int numero,String nombre){
		numEquipos=numero;
		nombreLiga=nombre;
		this.conexion=conexion;
		for (int i=0;i<numEquipos;i++)
		{
			equipos.add(new Equipo());//añade equipo en cada 
		}
	}
	public void setnombreLiga(String nombre){
		nombreLiga=nombre;
		
	}
	public String getnombreLiga(){
		return nombreLiga;
	}
	
	public int getNumEquipos(){
		return numEquipos;
	}
	
	public Equipo getEquipo(int posicion){
		 
		return equipos.get(posicion);
	}
	public void newEquipo (){
		equipos.add(new Equipo());
		numEquipos++;
	}
	
	
	public void newEquipoDB(Equipo equipo){
		try{
			//consulta la bd
			instruccion=(Statement)conexion.createStatement();
			//Insercion en la bd
			String sql_inst="INSERT INTO equipos (idEquipo,idLiga,nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos)";
			
			sql_inst=sql_inst+"VALUES("+idEquipo+","+idLiga+",'"+equipo.getNombreEquipo()+"',"+equipo.getGolesFavor()+","+equipo.getGolesEnContra()+","+equipo.getPartidosGanados()+","+equipo.getPartidosPerdidos()+")";
			System.out.println(sql_inst);//Para ver como queda la construccion
			instruccion.executeUpdate(sql_inst);
			}catch(SQLException exceptionSql){
				exceptionSql.printStackTrace();
			}
	}
	
	//Metodo para borrar equipo
	public void deleteEquipo(int posicion) {
		equipos.remove(posicion);
	}

	//Generamos metodo leer liga
	public void leerLiga() {
		try{
			//consulta la base de datos, vamos a crear 1 una instruccion va a ser un SELECT y en vez de mostrarlo por pantalla lo almaceno en la liga
			instruccion=(Statement) conexion.createStatement();
			conjuntoResultados=instruccion.executeQuery("SELECT idLiga,nombreLiga,numEquipos FROM ligas LIMIT 1");//Limit 1  significa que le pido que me muetre solo la primera fila
			conjuntoResultados.next();//cojemos los resultados y le pedimos que nos de el siguiente, como solo hay 1, será solo ese
			//Almacenamos en nuestra liga this.idLiga= el "idLiga" "nombre" y el "numEquipos"
			this.idLiga=(int)conjuntoResultados.getObject("idLiga");
			this.nombreLiga=(String)conjuntoResultados.getObject("nombreLiga"); 
			this.numEquipos=(int)conjuntoResultados.getObject("numEquipos");	
			
			//insercion en la bd 
		}catch(SQLException exceptionSql){
				exceptionSql.printStackTrace();
		}
		catch(Exception e){
				e.printStackTrace();
}
	}
}
