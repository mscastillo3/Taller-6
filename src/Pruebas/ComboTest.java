package Pruebas;

import Hamburegesas.Bebida;
import Hamburegesas.Combo;
import Hamburegesas.Ingrediente;
import Hamburegesas.ProductoAjustado;
import Hamburegesas.ProductoMenu;
import junit.framework.TestCase;

import java.util.ArrayList;

import org.junit.*;

public class ComboTest extends TestCase{
	private Combo combo;
	private ProductoMenu producto;
	private ProductoMenu producto1;
	private Bebida producto2;

	@Before
	protected void setUp() {
		producto = new ProductoMenu("Corral",14000,330);
		producto1 = new ProductoMenu("Papas medianas",5500,230);
		producto2 = new Bebida("Gaseosa",5000,140);
		combo = new Combo("combo corral", 10);
		combo.itemACombo(producto);
		combo.itemACombo(producto1);
		combo.itemACombo(producto2);
	} 
	
	@Test
	public void testFacturaProducto() {
		assertEquals( "combo corral 22050 700",combo.getTextoFactura());
		
	}
	@Test
	public void testprecioProducto() {
		assertEquals( 22050,combo.getPrecio());
		
	}
	@Test
	public void testCalorias() {
		assertEquals(700,combo.getCalorias());
		
	}

	
}
