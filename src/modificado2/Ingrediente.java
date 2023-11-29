package modificado2;

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
	
}
