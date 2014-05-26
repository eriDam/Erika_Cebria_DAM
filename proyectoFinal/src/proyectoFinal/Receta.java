package proyectoFinal;

import java.sql.Connection;

public class Receta {
private int idReceta;
private String nombre;
private String ingredientes;
private float precio;
private String dificultad;
private String descripcion;
private String categoria;


	public Receta() {
		// TODO Auto-generated constructor stub
	}
	
	
		public Receta(int idReceta,String nombre,String ingredientes,float precio,String dificultad,String descripcion,String categoria) {
			// TODO Auto-generated constructor stub
			
			this.idReceta = idReceta;
			this.nombre = nombre;
			this.ingredientes=ingredientes;
			this.precio=precio;
			this.dificultad=dificultad;
			this.descripcion=descripcion;
			this.categoria=categoria;
			
		}
		
		public int getIdReceta() {
			return idReceta;
		}


		public void setIdReceta(int idReceta) {
			this.idReceta = idReceta;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getIngredientes() {
			return ingredientes;
		}


		public void setIngredientes(String ingredientes) {
			this.ingredientes = ingredientes;
		}


		public float getPrecio() {
			return precio;
		}


		public void setPrecio(float precio) {
			this.precio = precio;
		}


		public String getDificultad() {
			return dificultad;
		}


		public void setDificultad(String dificultad) {
			this.dificultad = dificultad;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public String getCategoria() {
			return categoria;
		}


		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}


		public Receta(Connection conexion){
			
		}
		//Añado método String toString para que devuelva el nombre en el combobox
		//hara que me muestre por pantalla el nombre
		public String toString() {
			return nombre;
		}	 
	}



