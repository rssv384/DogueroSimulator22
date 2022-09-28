import java.util.HashMap;

public class Factores {
	
	public HashMap<String,Integer> TiempoPrepPrevia; // Pasos y tiempos de preparación previa
	public HashMap<String,Integer> CantidadIng; // Ingredientes y su cantidad por hot dog
	public HashMap<String,Integer> TiempoIng; // Ingredientes y su tiempo para servir al preparar un hot dog 

	public Factores () {
		this.TiempoPrepPrevia = new HashMap<String,Integer>();
		this.CantidadIng = new HashMap<String,Integer>();
		this.TiempoIng = new HashMap<String,Integer>();

		// Cargar valores para los HashMap
		cargarTiempoPrepPrevia();
		cargarCantidadIng();
		cargarTiempoIng();
	} // end constructor


	// Método para agregar pares (key,value) al HashMap de pasos y
	// tiempos de la preparación previa
	private void cargarTiempoPrepPrevia() {
		TiempoPrepPrevia.put("picar_tomate",40);
		TiempoPrepPrevia.put("picar_lechuga",127);
		TiempoPrepPrevia.put("envolver_tocino",13);
		TiempoPrepPrevia.put("calentar_sarten",120);
		TiempoPrepPrevia.put("calentar_pan",60);
		TiempoPrepPrevia.put("freir",70);
	}

	// Método para agregar pares (key,value) al HashMap de ingredientes
	// y sus cantidades al servir
	private void cargarCantidadIng() {
		CantidadIng.put("Pan",1);
		CantidadIng.put("Salchicha",1);
		CantidadIng.put("Tocino",1);
		CantidadIng.put("Tomate",14);
		CantidadIng.put("Lechuga",22);
		CantidadIng.put("Mayonesa",5);
	}

	// Método para agregar pares (key,value) al HashMap de ingredientes
	// y sus tiempos al servir
	private void cargarTiempoIng() {
		TiempoIng.put("Pan",4);
		TiempoIng.put("Salchicha",4);
		TiempoIng.put("Tocino",0);
		TiempoIng.put("Tomate",4);
		TiempoIng.put("Lechuga",4);
		TiempoIng.put("Mayonesa",4);
	}

}