package Hamburegesas;

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
		double precios = 0;
		for (Producto Item: ItemsCombo) {
			precios+= Item.getPrecio();
			 
		}
		precios =  precios-(precios*(descuento/100));
		return (int) precios;
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
	public boolean equals(Object ingre) {
		boolean devolver = false;
		if (ingre.getClass().getName().equals("Hamburegesas.Combo")) {
			Combo elIngre= (Combo) ingre;
			devolver = (elIngre.getNombre().equals(nombreCombo));
		}
		return (devolver);
	}
	
}