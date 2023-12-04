package Pruebas;

import Hamburegesas.Ingrediente;
import Hamburegesas.ProductoAjustado;
import Hamburegesas.ProductoMenu;
import junit.framework.TestCase;

import java.util.ArrayList;

import org.junit.*;

public class ProductoAjustadoTest extends TestCase{
	private ProductoAjustado productoAjustado;
	private ProductoMenu producto;
	private ArrayList<Ingrediente> anadidos; 	
	private ArrayList<Ingrediente> eliminados; 	
	@Before
	protected void setUp() {
		producto = new ProductoMenu("Corral",14000,330);
		
		anadidos = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();

		eliminados.add(new Ingrediente("Lechuga",1000,5));
		eliminados.add(new Ingrediente("Tomate",1000,22));
		
		anadidos.add(new Ingrediente("Tocineta picada",6000,240));
		anadidos.add(new Ingrediente("Piña",2500,82));
		
		productoAjustado = new ProductoAjustado(producto, anadidos, eliminados);
		
	} 
	
	@Test
	public void testFacturaProducto() {
		assertEquals( "Corral con Tocineta picada con Piña sin Lechuga sin Tomate 22500 625",productoAjustado.getTextoFactura());
		
	}
	@Test
	public void testprecioProducto() {
		assertEquals( 22500,productoAjustado.getPrecio());
		
	}
	@Test
	public void testCalorias() {
		assertEquals(625,productoAjustado.getCalorias());
		
	}
	@Test
	public void testNombre() {
		assertEquals("Corral con Tocineta picada con Piña sin Lechuga sin Tomate",productoAjustado.getNombre());
		
	}
	
}
