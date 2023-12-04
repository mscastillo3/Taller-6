package Hamburegesas;

public class Ingrediente {
	private String nombre;
	private int costoAdicional;
	private int calorias;
	public Ingrediente (String nombreb,int costoAdicionalb, int calorias ) {
		nombre = nombreb;
		costoAdicional = costoAdicionalb;
		this.calorias = calorias;
		
	}
	public String getNombre() {
		return nombre;
	}
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	public int getCalorias() {
		return calorias;
	}
	
	public boolean equals(Object ingre) {
		boolean devolver = false;
		if (ingre.getClass().getName().equals("Hamburegesas.Ingrediente")) {
			Ingrediente elIngre= (Ingrediente) ingre;
			devolver = (elIngre.getNombre().equals(nombre));
		}
		return (devolver);
	}
	
}
