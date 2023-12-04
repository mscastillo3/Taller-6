package Hamburegesas;

import java.util.ArrayList;

public class IngredienteRepetidoException extends HamburguesaException{
	private ArrayList<Ingrediente> listaIngredientes;
	private Ingrediente itemRevisar;
	public IngredienteRepetidoException(){
		listaIngredientes = new ArrayList<Ingrediente>();
	}
	
	public void revisarIngrediente(Ingrediente itemRevisar) throws IllegalArgumentException{
		this.itemRevisar= itemRevisar;
		itemRepetir();
		listaIngredientes.add(itemRevisar);
	}
	@Override
	public void itemRepetir() throws IllegalArgumentException {
		
		for (Ingrediente item: listaIngredientes)
			if (itemRevisar.equals(item)) {
				throw new IllegalArgumentException(item.getNombre()+" esta repetido en los archivos se mantuvo la infomacion de la primera aparición");
			}
		
	}
}
