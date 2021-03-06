import java.util.*;
public class Inventario{
   private ArrayList<Item> itens = new ArrayList<>();
   public void adicionarItem(Item item){
       itens.add(item);
   }
   public void removerItem(Item item){
       this.itens.remove(item);
   }
   public ArrayList<Item> getItens(){
    return itens;
   }
   public String getDescricoesItens(){
    String retorno = "";
    for (Item item : this.itens) {
       retorno += item.getDescricao() + ",";
    }
    return !this.itens.isEmpty() ? retorno.substring(0, retorno.length() - 1) : retorno;
   } 
   public Item retornaMaiorQuant(){
       Item maiorReturn = null;
       int maiorInt = -1;
       for(Item item : this.itens){
           if(maiorInt < item.getQuantidade()){
               maiorReturn = item;
           }
       }
       return maiorReturn;
   }
   public void ordenarItens(){
       Item aux = null;
       for(int i = 0; i<itens.size(); i++){
           for(int j = 0; j<itens.size()-1; j++){
               if(itens.get(j).getQuantidade() > itens.get(j+1).getQuantidade()){ 
                   aux = itens.get(j); 
                   itens.set(j,itens.get(j+1));
                   itens.set(j+1,aux);                    
               }
           } 
       }
   }
}