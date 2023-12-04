package Hamburegesas;

public class Bebida implements Producto{

	private String nombre;
	private int precioBase;
	private int calorias;
	public Bebida (String nombreb, int precioBaseb, int calorias) {
		nombre = nombreb;
		precioBase = precioBaseb;
		this.calorias = calorias;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precioBase;
	}
	public String getTextoFactura(){
		return nombre + " "+ precioBase+ " " + calorias;
		
	}

	@Override
	public int getCalorias() {
		return calorias;
	
	}
	public boolean equals(Object ingre) {
		boolean devolver = false;
		String calse = ingre.getClass().getName();
		if (calse.equals("Hamburegesas.Bebida")) {
			Bebida elIngre= (Bebida) ingre;
			devolver = (elIngre.getNombre().equals(nombre));
		}
		return (devolver);
	}

}
