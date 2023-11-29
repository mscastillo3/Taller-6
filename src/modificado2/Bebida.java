package modificado2;

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


}
