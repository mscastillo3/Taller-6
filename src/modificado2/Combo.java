package modificado2;

import java.util.ArrayList;

public class Combo implements Producto{
	private String nombreCombo;
	private double descuento;
	private ArrayList<Producto> ItemsCombo; 
	public String getNombre() {
		return nombreCombo;
	}
	public Combo (String nombreCombob, int descuentob) {
		nombreCombo = nombreCombob;
		descuento = descuentob;
		ItemsCombo = new ArrayList<Producto>(); 
	}
	public void itemACombo(Producto itemCombo) {
		ItemsCombo.add(itemCombo);
	}
	
	public int getPrecio() {
		int precios = 0;
		for (Producto Item: ItemsCombo) {
			precios+= Item.getPrecio();
			 
		}
		precios = (int) (precios*(descuento));
		return precios;
	}
	
	public int getCalorias() {
		int calorias = 0;
		for (Producto Item: ItemsCombo) {
			calorias+= Item.getCalorias();
			 
		}
		return calorias;
	}
	public String getTextoFactura(){
		int precios = getPrecio() ;
		int calorias = getCalorias() ;
		return nombreCombo + " "+ precios + " " +calorias;
		
	}
	
}