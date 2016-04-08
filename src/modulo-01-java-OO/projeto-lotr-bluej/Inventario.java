import java.util.*;
public class Inventario{
   private ArrayList<Item> itens = new ArrayList<>();
   public Inventario(){
   }
   public void adicionarItem(Item item){
       itens.add(item);
   }
   public void removerItem(Item item){
       this.itens.remove(item);
   }
   public ArrayList getItens(){
    return itens;
   }
}