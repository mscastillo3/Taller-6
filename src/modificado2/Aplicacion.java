package modificado2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class Aplicacion {
private static Restaurante restaurante = new Restaurante();
private static boolean continuar = true;
private static String nombre;
private static String direccion;
private static Object[] productos;;
private static Pedido pedido;
public static void main(String[]args) throws IOException, NumberFormatException {
	File combos = new File("./data/combos.txt");
	File ingredientes = new File("./data/ingredientes.txt");
	File menu = new File("./data/menu.txt");
	File bebidas = new File("./data/bebidas.txt");
	restaurante.cargarinformacionRestaurante( ingredientes, menu, combos, bebidas);
	boolean apagar = true;
	while (apagar) {
	System.out.print("1. Mostrar el menú\r\n"
			+ "2. Iniciar un nuevo pedido\r\n"
			+ "3. Agregar un elemento a un pedido\r\n"
			+ "4. Cerrar un pedido y guardar la factura\r\n"
			+ "5. Consultar la información de un pedido dado su id\r\n"
			+"6. Apagar\r\n");
	
	int seleccion = Integer.valueOf(input("Que quieres hacer? ") );
	if (seleccion == 1) {
		System.out.println("Menu del restaurante \r\n" +".....Comidas.......");
		mostrarMenu2();
		System.out.println("............Combos............");
		mostrarCombos2();
		System.out.println("............Bebidas............");
		mostrarBebidas2();
	}
	else if(seleccion == 2) {
		nombre = input("Cual es tu nombre: "); 
		direccion = input("Cual es tu direccion : ");
		restaurante.iniciarPedido(nombre, direccion);
		pedido = restaurante.getPedidoEnCurso();
	}
	else if (seleccion == 3){
		String comboOMenu =(input("¿Quieres un comobo:0, un algo del Menu:1 o una Bebida:2? "));
		if (comboOMenu.equals("1")) {
			mostrarMenu ();
			int eleccion = Integer.parseInt(input("Pon el numero de la comida que deceas."));
			ArrayList<Integer> listaAdiciones = new ArrayList<Integer>();
			String quiere = (input("¿Quieres adiciones? (si, no)"));
			adicionesEliminaciones(listaAdiciones, quiere, "adicione.");
			ArrayList<Integer> listaEliminaciones = new ArrayList<Integer>();
			quiere = (input("¿Quieres eliminar algo? (si, no)"));
			adicionesEliminaciones(listaEliminaciones,quiere, "eliminacion." );
			añadirItem(eleccion, listaAdiciones, listaEliminaciones);
		}
		else if (comboOMenu.equals("2")) {
			mostrarBebidas ();
			int eleccion = Integer.parseInt(input("Pon el numero de la bebida que deceas."));
			añadirItemCombo(eleccion);
		}
		else if (comboOMenu.equals("0")) {
			mostrarCombos();
			int eleccion = Integer.parseInt(input("Pon el numero del combo que deceas."));
			añadirItemBebidas(eleccion);
		}
	}
	else if (seleccion == 4){
			File facutura = new File("factura.txt");
			pedido.generarTextoFactura(facutura);
			restaurante.cerrarYGuardarPedido();
		}
		
	else if (seleccion == 5){
		int id = Integer.valueOf(input("Pon el numero del Pedido que vas a consultar."));
		restaurante.getPedido(id);
	}
		
	}
}

private static void añadirItemBebidas(int eleccion) {
	Map<String, Bebida> menu = restaurante.getBebidas();
	Set<String> lista = menu.keySet();
	Object[] combitos =  lista.toArray();
	Bebida elProducto = menu.get((String)combitos[eleccion]);
	pedido.agregarProdcuto(elProducto);
}

private static void añadirItemCombo(int eleccion) {
	Map<String, Combo> menu = restaurante.getCombos();
	Set<String> lista = menu.keySet();
	Object[] combitos =  lista.toArray();
	Combo elProducto = menu.get((String)combitos[eleccion]);
	pedido.agregarProdcuto(elProducto);
}
private static void mostrarCombos() {
	Map<String, Combo> menu = restaurante.getCombos();
	Set<String> lista = menu.keySet();
	int opcion = 0;
	for (String item: lista) {
		System.out.println(item + ":" + opcion);
		opcion ++;
	}
}
private static void mostrarBebidas() {
	Map<String, Bebida> menu = restaurante.getBebidas();
	Set<String> lista = menu.keySet();
	int opcion = 0;
	for (String item: lista) {
		System.out.println(item + ":" + opcion);
		opcion ++;
	}
}
private static void mostrarBebidas2() {
	Map<String, Bebida> menu = restaurante.getBebidas();
	Set<String> lista = menu.keySet();
	for (String item: lista) {
		System.out.println(item + " "+menu.get(item).getPrecio());
	}
}
private static void mostrarCombos2() {
	Map<String, Combo> menu = restaurante.getCombos();
	Set<String> lista = menu.keySet();
	for (String item: lista) {
		System.out.println(item + " "+menu.get(item).getPrecio() );
	}
}

private static void adicionesEliminaciones(ArrayList<Integer> listaAdiciones, String quiere, String accion) throws IOException {
	boolean continuar3;
	if (quiere.equals("si")) {
		continuar3 = true;
	}
	else {
		continuar3 = false;
	}
	
	while(continuar3) {
		mostrarIngredientes(); 
		int eleccion2 = Integer.parseInt(input("Pon el numero de la " + accion));
		listaAdiciones.add(eleccion2);
		quiere = input("Quieres otra " + accion+ " (si, no)");
		if (quiere.equals("si")) {
			continuar3 = true;
		}
		else {
			continuar3 = false;
		}
		
	}
}
private static void añadirItem(int eleccion, ArrayList<Integer> listaAdiciones, ArrayList<Integer> listaEliminaciones) {
	Map<String, ProductoMenu> menu = restaurante.getMenuBase();
	String item= (String) productos[eleccion];
	ProductoMenu elProducto = menu.get(item);
	if (listaAdiciones.size()> 0 || listaEliminaciones.size() > 0   ) {
		Map<String, Ingrediente> ingredientes = restaurante.getIngredientes();
		Set<String> setLlaves = ingredientes.keySet();
		Object[] listaLlaves =   setLlaves.toArray();
		ArrayList<Ingrediente> adicionesr = new ArrayList<Ingrediente>();
		for (int adicion: listaAdiciones) {
			String llave = (String)listaLlaves[adicion];
			Ingrediente valor = ingredientes.get(llave);
			adicionesr.add(valor);
		}
		ArrayList<Ingrediente> eliminacionesr = new ArrayList<Ingrediente>();
		for (int adicion: listaEliminaciones) {
			adicionesr.add(ingredientes.get((String)listaLlaves[adicion]));
		}
		ProductoAjustado productoModificado = new  ProductoAjustado(elProducto, adicionesr, eliminacionesr);
		pedido.agregarProdcuto(productoModificado);
	}
	else {
		pedido.agregarProdcuto(elProducto);
	}
}

private static void mostrarIngredientes() {
	
	Map<String, Ingrediente> menu = restaurante.getIngredientes();
	Set<String> lista = menu.keySet();
	int opcion = 0;
	for (String item: lista) {
		System.out.println(item + ":" + opcion);
		opcion ++;
	}
}

private static void mostrarMenu() {
	
	Map<String, ProductoMenu> menu = restaurante.getMenuBase();
	Set<String> lista = menu.keySet();
	productos =  lista.toArray();
	int opcion = 0;
	for (String item: lista) {
		System.out.println(item + ":" + opcion);
		opcion ++;
	}
}
private static void mostrarMenu2() {
	
	Map<String, ProductoMenu> menu = restaurante.getMenuBase();
	Set<String> lista = menu.keySet();
	productos =  lista.toArray();
	for (String item: lista) {
		System.out.println(item + " "+menu.get(item).getPrecio());
	}
}
private static String input( String pregunta) throws IOException {
	System.out.print(pregunta);
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String nombre = reader.readLine();
	return (nombre);
	}


}
