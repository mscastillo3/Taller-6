package Hamburegesas;

public class PrecioMuyAlto {
	private int precioA;
	private int precio;
	public PrecioMuyAlto(int precio, int precioA) {
		this.precioA = precioA;
		this.precio = precio;
	}
	public void revisar()throws IllegalArgumentException{
		if (precioA + precio > 150000) {
			throw new IllegalArgumentException("El precio total supero el maximo el producto no se puede añadir.");
		}
	}
}
