package modificado2;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.util.ArrayList;

public class Pedido {
	private int idPedido = 0;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedidos; 
	public Pedido (String nombreClienteb, String direccionClienteb ) {
		nombreCliente = nombreClienteb;
		direccionCliente = direccionClienteb;
		itemsPedidos = new ArrayList<Producto>();
		idPedido ++;
	}
	public int getIdPedido() {
		return idPedido;
	}
	
	public void agregarProdcuto(Producto nuevoItem) {
		itemsPedidos.add(nuevoItem);
	}
	
	private int getPrecioTotalPedido() {
		int precioNeto = 0;
		for (Producto item: itemsPedidos) {
			precioNeto +=item.getPrecio();}
		return (precioNeto);
	}
	private int getPrecioIVAPedido() {
		int precioNeto = getPrecioTotalPedido(); 
		int precioIVA = (int)( precioNeto*0.19);
		return (precioIVA);
	}
	
	private int getPrecioNetoPedido() {
		int precioNeto = getPrecioTotalPedido();
		int precioIVA = getPrecioIVAPedido();
		int precioTotal = precioNeto+ precioIVA;
		return (precioTotal);
	}
	public void generarTextoFactura(File archivo) {
		try {
			PrintStream consola = System.out;
			
			System.setOut(new PrintStream((archivo)));
			System.out.println("Nombre: " + nombreCliente + ", Direccion: " + direccionCliente);
			for (Producto item: itemsPedidos) {
				
				System.out.println(item.getTextoFactura());
				
			}
			System.out.println("El precio totale es: " + getPrecioNetoPedido());
			System.setOut(consola);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generarTextoFactura() {
		System.out.println("Nombre: " + nombreCliente + ", Direccion: " + direccionCliente);
		for (Producto item: itemsPedidos) {
			
			System.out.println(item.getTextoFactura());
			
		}
		System.out.println("El precio totale es: " + getPrecioNetoPedido());
	}
}

