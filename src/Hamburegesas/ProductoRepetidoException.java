package Hamburegesas;

import java.util.ArrayList;

public class ProductoRepetidoException extends HamburguesaException {
	private ArrayList<Producto> listaProductos;
	private Producto itemRevisar;
	public ProductoRepetidoException(){
		listaProductos = new ArrayList<Producto>();
	}
	
	
	public void revisarIngrediente(Producto itemRevisar) throws IllegalArgumentException{
		this.itemRevisar= itemRevisar;
		itemRepetir();
		listaProductos.add(itemRevisar);
	}
	@Override
	public void itemRepetir() throws IllegalArgumentException {
		
		for (Producto item: listaProductos)
			if (itemRevisar.equals(item)) {
				throw new IllegalArgumentException(item.getNombre()+" esta repetido en los archivos se mantuvo la infomacion de la primera aparición");
			}
		
	}
}
