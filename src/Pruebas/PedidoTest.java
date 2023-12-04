package Pruebas;

import Hamburegesas.Bebida;
import Hamburegesas.Combo;
import Hamburegesas.Ingrediente;
import Hamburegesas.Pedido;
import Hamburegesas.ProductoAjustado;
import Hamburegesas.ProductoMenu;
import Hamburegesas.Restaurante;
import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.junit.*;

public class PedidoTest extends TestCase{
	private Pedido pedido;
	private Combo combo;
	private ProductoMenu producto;
	private ProductoMenu producto1;
	private Bebida producto2;
	private ArrayList<Ingrediente> anadidos;
	private ArrayList<Ingrediente> eliminados;
	private ProductoAjustado productoAjustado;


	@Before
	protected void setUp() {
		pedido = new Pedido("miguel", "calle 139 #73-20");
		producto = new ProductoMenu("Corral",14000,330);
		producto1 = new ProductoMenu("Papas medianas",5500,230);
		producto2 = new Bebida("Gaseosa",5000,140);
		combo = new Combo("combo corral", 10);
		combo.itemACombo(producto);
		combo.itemACombo(producto1);
		combo.itemACombo(producto2);
		
		anadidos = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();

		eliminados.add(new Ingrediente("Lechuga",1000,5));
		eliminados.add(new Ingrediente("Tomate",1000,22));
		
		anadidos.add(new Ingrediente("Tocineta picada",6000,240));
		anadidos.add(new Ingrediente("Piña",2500,82));
		
		productoAjustado = new ProductoAjustado(producto, anadidos, eliminados);
		
	} 
	
	@Test
	public void testFacturaPedido1() {
		pedido.agregarProdcuto(combo);
		assertSame( "Nombre: miguel, Direccion: calle 139 #73-20 \n" + combo.getTextoFactura()+ "\n"+ "El precio totale es: " + pedido.getPrecioNetoPedido(),pedido.generarTextoFactura());
		
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
