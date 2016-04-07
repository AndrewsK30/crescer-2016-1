import java.util.*;
public class Invetario{
   private ArrayList<Item> itens = new ArrayList<>();
   
   public void adicionarItem(Item item){
       itens.add(item);
   }
   public void removerItem(Item item){
       this.itens.remove(item);
   }
}