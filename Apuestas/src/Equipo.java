import java.io.Serializable;

public class Equipo implements Serializable{
	
	//Atributos del equipo
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;
	
	//Constructor clase
	public Equipo() {
			//Hay que inicializar todas las variables en el constructor por defecto
			nombreEquipo="";
			golesFavor=0;
			golesEnContra=0;
			partidosGanados=0;
			partidosPerdidos=0;
		}
	
	public Equipo(String nom, int golesF,int golesC,int partidosG, int partidosP ) {
		/* This signidica esto, Utilizo this para referinos especificamente a 
		 * esta clase, para decir de este objeto la propiedad
		 * nombreEquipo va a ser igual a la variable nom que le pase como parametro,
		 *  la propiedad golesFavor va a ser igual a la variable golesF que le pase como parametro  y asi el resto
		 * */	
		this.nombreEquipo=nom;
			this.golesFavor=golesF;
			this.golesEnContra=golesC;
			this.partidosGanados=partidosG;
			this.partidosPerdidos=partidosP;
		}
	
	//Entradas y Salidas de los atributos anteriores:  Getters and Setters de los atributos bot dcho-Soruce-Generate getters and setters
	/*Crear sets and gets (obtener y asignar) me permiten modificar un dato o
	 * aributo de la clase u obtener un dato (devolver un dato o asignar uno) */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}


	public int getGolesFavor() {
		return golesFavor;
	}



	public int getGolesEnContra() {
		return golesEnContra;
	}


	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}


	public int getPartidosGanados() {
		return partidosGanados;
	}


	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}


	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}


	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public String toString(){
		return nombreEquipo;
	}

}
