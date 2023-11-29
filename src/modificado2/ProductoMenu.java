package modificado2;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	private int calorias;
	public ProductoMenu (String nombreb, int precioBaseb, int calorias) {
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
		return nombre + " "+ precioBase;
		
	}

	@Override
	public int getCalorias() {
		return calorias;
	}
}
