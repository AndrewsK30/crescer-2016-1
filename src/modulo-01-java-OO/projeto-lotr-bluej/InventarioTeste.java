import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public  class InventarioTeste {
	@Test
	public void adicionando2Itens(){
		ArrayList array;
	    Inventario inventario = new Inventario();
	    Item espada = new Item(2,"Espada");
		Item arco = new Item(1,"Arco");
		inventario.adicionarItem(espada);
		inventario.adicionarItem(arco);
		array = inventario.getInventario();
		assertTrue(array.contains(arco));
		assertTrue(array.contains(espada));
	}
	@Test
	public void adicionando2ItensRemove(){
		ArrayList array;
	    Inventario inventario = new Inventario();
	    Item espada = new Item(2,"Espada");
		Item arco = new Item(1,"Arco");
		inventario.adicionarItem(espada);
		inventario.adicionarItem(arco);
		inventario.removerItem(arco);
		inventario.removerItem(espada);
		array = inventario.getInventario();
		assertFalse(array.contains(arco));
		assertFalse(array.contains(espada));
	}
}