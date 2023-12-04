package Hamburegesas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Restaurante {
	private Map<Integer, Pedido> pedidos; 
	private Pedido pedidoEnCurso;
	private Map<String, Combo> combos;
	private  Map<String, ProductoMenu>  menuBase;
	private Map<String, Ingrediente> ingredientes;
	private Map<String, Bebida> bebidas;
	public Restaurante() {
		ingredientes = new HashMap<String, Ingrediente>();
		combos = new HashMap<String, Combo>();
		menuBase = new HashMap<String, ProductoMenu>();
		pedidos = new HashMap<Integer, Pedido>();
		bebidas = new HashMap<String, Bebida>();
		}
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		pedidoEnCurso = new Pedido(nombreCliente,direccionCliente );
		
	}
	public void cerrarYGuardarPedido() {
		pedidos.put(pedidoEnCurso.getIdPedido(), pedidoEnCurso);
	} 
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	public Map<String, ProductoMenu> getMenuBase() {
		return menuBase;
	}
	public Map<String, Bebida> getBebidas() {
		return bebidas;
	}
	public Map<String, Combo> getCombos() {
		return combos;
	}
	public Map<String, Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void cargarinformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebidas ) {
		cargarIngredientes(archivoIngredientes);
		cargarBebidas(archivoBebidas);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
			}
	private void cargarBebidas(File archivoBebidas) {
		ProductoRepetidoException revisar = new ProductoRepetidoException();
		try (BufferedReader lector = new BufferedReader(new FileReader (archivoBebidas))) {
			String linea = lector.readLine().toLowerCase();
			while (linea != null) {
				linea = linea.toLowerCase();
				String[] ingredienteItems = linea.split(";");
				int costo = Integer.parseInt(ingredienteItems[1]);
				int calorias = Integer.parseInt(ingredienteItems[2]);
				Bebida ingredienteActual = new Bebida(ingredienteItems[0], costo, calorias );
				
				
				try {
					revisar.revisarIngrediente(ingredienteActual);
					bebidas.put(ingredienteItems[0], ingredienteActual);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				linea = lector.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cargarIngredientes(File archivoIngredientes) {
		IngredienteRepetidoException revisar = new IngredienteRepetidoException();
		try (BufferedReader lector = new BufferedReader(new FileReader (archivoIngredientes))) {
			String linea = lector.readLine().toLowerCase();
			while (linea != null) {
				linea = linea.toLowerCase();
				
				String[] ingredienteItems = linea.split(";");
				int costo = Integer.parseInt(ingredienteItems[1]);
				int calorias = Integer.parseInt(ingredienteItems[2]);
				Ingrediente ingredienteActual = new Ingrediente(ingredienteItems[0], costo, calorias );
				
				try {
					revisar.revisarIngrediente(ingredienteActual);
					ingredientes.put(ingredienteItems[0], ingredienteActual);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				linea = lector.readLine();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cargarMenu(File archivoMenu) {
		ProductoRepetidoException revisar = new ProductoRepetidoException();
		try (BufferedReader lector = new BufferedReader(new FileReader (archivoMenu))) {
			String linea = lector.readLine().toLowerCase();
			while (linea != null) {
				linea = linea.toLowerCase();
				String[] menuItems = linea.split(";");
				int costo = Integer.parseInt(menuItems[1]);
				int calorias = Integer.parseInt(menuItems[2]);
				ProductoMenu ingredienteActual = new ProductoMenu(menuItems[0], costo, calorias );
				
				try {
					revisar.revisarIngrediente(ingredienteActual);
					menuBase.put(menuItems[0], ingredienteActual);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				linea = lector.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cargarCombos(File archivoCombos) {
		ProductoRepetidoException revisar = new ProductoRepetidoException();
		try (BufferedReader lector = new BufferedReader(new FileReader (archivoCombos))) {
			String linea = lector.readLine();
			while (linea != null) {
				linea = linea.toLowerCase();
				String[] comboItems = linea.split(";");
				int descuento = Integer.parseInt(comboItems[1].replace("%", ""));
				Combo ingredienteActual = new Combo(comboItems[0], descuento);
				
				for (int i = 2; i < comboItems.length; i++) {
					Producto itemCombo;
					if (menuBase.containsKey(comboItems[i])) {
						itemCombo = menuBase.get(comboItems[i]);
						ingredienteActual.itemACombo(itemCombo);
					}
					else {
						itemCombo = (Producto) bebidas.get(comboItems[i]);
						ingredienteActual.itemACombo(itemCombo);
					}
					
					
				}
				try {
					revisar.revisarIngrediente(ingredienteActual);
					combos.put(comboItems[0], ingredienteActual);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				linea = lector.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getPedido(int id) {
		Pedido pedio = pedidos.get(id);
		return(pedio.generarTextoFactura());
		
	}
	
}
