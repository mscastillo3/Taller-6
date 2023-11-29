package modificado2;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado (ProductoMenu baseb, ArrayList<Ingrediente> agregadosb, ArrayList<Ingrediente> eliminadosb) {
		base = baseb;
		agregados = agregadosb;
		eliminados = eliminadosb;
	}
	public String getNombre(){
		String nombre = base.getNombre();
		for (Ingrediente adiccion: agregados ) {
			nombre += " con " +adiccion.getNombre();
		} 
		for (Ingrediente sin: eliminados ) {
			nombre += " sin " +sin.getNombre();
		} 
		return nombre;
	}	
	public int getPrecio() {
		int nuevoPrecio = base.getPrecio();
		for (Ingrediente adiccion: agregados ) {
			nuevoPrecio += adiccion.getCostoAdicional();
		}
		return nuevoPrecio;
	}
	
	public int getCalorias() {
		int calorias = 0;
		for (Ingrediente Item: agregados) {
			calorias+= Item.getCalorias();
			 
		}
		for (Ingrediente Item: eliminados) {
			calorias-= Item.getCalorias();
			 
		}
		return calorias;
}
	public String getTextoFactura(){
		int nuevoPrecio = base.getPrecio();
		for (Ingrediente adiccion: agregados ) {
			nuevoPrecio += adiccion.getCostoAdicional();
		}
		
		String nombre = base.getNombre();
		for (Ingrediente adiccion: agregados ) {
			nombre += " con " +adiccion.getNombre();
		} 
		for (Ingrediente sin: eliminados ) {
			nombre += " sin " +sin.getNombre();
		} 
		int calorias = getCalorias();
		return nombre + " "+ nuevoPrecio+" "+calorias;
		
	}

	}
