package Pruebas;

import Hamburegesas.ProductoMenu;
import junit.framework.TestCase;

public class ProductoMenuTest extends TestCase{
	private ProductoMenu producto;
	
	
	public void testFacturaProducto() {
		producto = new ProductoMenu("Corral",14000,3300);
		assertEquals( "Corral 14000 3300",producto.getTextoFactura());
		
	}
	
}
