package Hamburegesas;

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
		int precioA = getPrecioTotalPedido();
		PrecioMuyAlto revicion = new PrecioMuyAlto (precioA, nuevoItem.getPrecio());
		try {
		revicion.revisar();
		itemsPedidos.add(nuevoItem);}
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		

		
		
		
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
	
	public int getPrecioNetoPedido() {
		int precioNeto = getPrecioTotalPedido();
		int precioIVA = getPrecioIVAPedido();
		int precioTotal = precioNeto+ precioIVA;
		return (precioTotal);
	}
	
	public String generarTextoFactura() {
		String factura = ("Nombre: " + nombreCliente + ", Direccion: " + direccionCliente) + "\n";
		for (Producto item: itemsPedidos) {
			
			factura += (item.getTextoFactura())+ "\n";
			
		}
		factura +=("El precio totale es: " + getPrecioNetoPedido());
		return factura;
	}
}

