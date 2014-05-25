package proyectoFinal;

import java.sql.Connection;

public class MetodosRecetas {
private int idReceta;
private String nombre;
private String ingredientes;
private float precio;
private String dificultad;
private String descripcion;
private String categoria;


	public MetodosRecetas() {
		// TODO Auto-generated constructor stub
	}
	
	
		public MetodosRecetas(int idReceta,String nombre,String ingredientes,float precio,String dificultad,String descripcion,String categoria) {
			// TODO Auto-generated constructor stub
			
			this.idReceta = idReceta;
			this.nombre = nombre;
			this.ingredientes=ingredientes;
			this.precio=precio;
			this.dificultad=dificultad;
			this.descripcion=descripcion;
			this.categoria=categoria;
			
		}
		
		public MetodosRecetas(Connection conexion){
			
		}

		 
	}



