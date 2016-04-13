import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest{
   @After
   public void tearDown(){
       System.gc();
   }
   @Test
    public void atira2flecha(){
        Elfo legolas=new ElfoVerde("Legolas",32);
        Dwarf dwarf=new Dwarf("dwarf");
        legolas.atirarFlecha(dwarf);
        legolas.atirarFlecha(dwarf);
        assertEquals(4,legolas.getExp());        
    }
   @Test
   public void atira3flecha(){
        Elfo legolas=new ElfoVerde("Legolas",32);
        Dwarf dwarf=new Dwarf("dwarf");
        legolas.atirarFlecha(dwarf);
        legolas.atirarFlecha(dwarf);
        legolas.atirarFlecha(dwarf);
        assertEquals(6,legolas.getExp());        
   }
   @Test
   public void AdicionaItem(){
        Elfo legolas=new ElfoVerde("Legolas",32);
        Item espada =new Item(1,"Espada de Aço valiriano");
        Item arco =new Item(1,"Arco e Flecha de Vidro");
        legolas.adicionarItem(espada);
        legolas.adicionarItem(arco);
        assertEquals("Espada de Aço valiriano", legolas.getInventario().getItens().get(0).getDescricao());
        assertEquals("Arco e Flecha de Vidro", legolas.getInventario().getItens().get(1).getDescricao());              
   }   
}
